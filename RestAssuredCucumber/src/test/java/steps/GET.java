package steps;


import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matchers;
import org.junit.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET {


	private Response responseGet;
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Quando("realizar um GET na URL {string}")
	public void realizar_um_get_na_url(String string) {

		responseGet = RestAssured.get(string);


	}

	@Entao("^o status code deve ser (\\d+)$")
	public void o_status_code_deve_ser(int arg1) throws Throwable {
		responseGet.then().statusCode(200);

	}

	@Entao("no caminho {string} do body da resposta deve ser a string {string}")
	public void noCaminhoDoBodyDaRespostaDeveSerAString(String string, String string2) {
		responseGet.then().body(string, containsString(string2));

	}

	@Entao("no caminho {string} do body da resposta deve ser o inteiro {int}")
	public void noCaminhoDoBodyDaRespostaDeveSerOInteiro(String string, Integer int1) {
		responseGet.then().body(string, is(int1));

	}

	@Entao("anexo o body de resposta no relatorio")
	public void anexoOBodyDaRespostaNoRelatorio() {
		// Para anexar texto no relatorio
		// scenario.attach(response.prettyPrint(), "text/plain", "obs");
		scenario.attach(responseGet.getBody().asString(), "application/json", "obs");

	}

	@Entao("utilizando o Path, no caminho {string} do body da resposta deve ser o inteiro {int}")
	public void utilizandoOPathNoCaminhoDoBodyDaRespostaDeveSerOInteiro(String string, Integer int1) {
		// path
		Assert.assertEquals(int1, responseGet.path(string));
	}

	@Entao("usando o Jsonpath, no caminho {string} do body da resposta deve ser o inteiro {int}")
	public void utilizandoOJsonpathNoCaminhoDoBodyDaRespostaDeveSerOInteiro(String string, Object int1) {
		// Jsonpath
		JsonPath jpath = new JsonPath(responseGet.asString());
		Assert.assertEquals(int1, jpath.getInt(string));
	}

	@Entao("usando o Fron, no caminho {string} do body da resposta deve ser o inteiro {int}")
	public void usandoOFronNoCaminhoDoBodyDaRespostaDeveSerOInteiro(String string, Object int1) {
		// from
		int id = JsonPath.from(responseGet.asString()).getInt(string);
		Assert.assertEquals(int1, id);
	}

	@Entao("no caminho da lista {string} possui o tamanho {int}")
	public void noCaminhoDaListaPossuiOTamanho(String string, Integer int1) {
		// Validando tamanho da Lista
		responseGet.then().body(string, Matchers.hasSize(int1));

	}

	@Entao("no caminho da lista {string} do body da resposta deve ser a string {string}")
	public void noCaminhoDaListaDoBodyDaRespostaDeveSerAString(String string, String string2) {
		// Validando conteudo especifico da lista
		responseGet.then().body(string, containsString(string2));
	}

	@Entao("no caminho da lista {string} contem o item {string}")
	public void noCaminhoDaListaContemOItem(String string, String string2) {
		// Validando se possui um item na lista
		responseGet.then().body(string, Matchers.hasItem(string2));
	}
	
	@Entao("no caminho da lista {string} contem os itens {string} e {string}")
	public void noCaminhoDaListaContemOsItensE(String string, String string2, String string3) {
		responseGet.then().body(string, Matchers.hasItems(string2, string3));
	}

}
