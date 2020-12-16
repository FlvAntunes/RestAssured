package steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Entao;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//import steps.QuandO;

public class EntaO {

	private Response response = steps.QuandO.response;
	private Scenario scenario = BeforeAfter.getScenario();

	@Entao("^o status code deve ser (\\d+)$")
	public void o_status_code_deve_ser(int arg1) throws Throwable {
		response.then().statusCode(arg1);

	}

	@Entao("no caminho {string} do body da resposta deve ser a string {string}")
	public void noCaminhoDoBodyDaRespostaDeveSerAString(String string, String string2) {
		response.then().body(string, containsString(string2));

	}

	@Entao("no caminho {string} do body da resposta deve ser o inteiro {int}")
	public void noCaminhoDoBodyDaRespostaDeveSerOInteiro(String string, Integer int1) {
		response.then().body(string, is(int1));

	}

	@Entao("anexo o body de resposta no relatorio")
	public void anexoOBodyDaRespostaNoRelatorio() {
		// Para anexar texto no relatorio
		// scenario.attach(response.prettyPrint(), "text/plain", "obs");
		scenario.attach(response.getBody().asString(), "application/json", "obs");

	}

	@Entao("utilizando o Path, no caminho {string} do body da resposta deve ser o inteiro {int}")
	public void utilizandoOPathNoCaminhoDoBodyDaRespostaDeveSerOInteiro(String string, Integer int1) {
		// path
		Assert.assertEquals(int1, response.path(string));
	}

	@Entao("usando o Jsonpath, no caminho {string} do body da resposta deve ser o inteiro {int}")
	public void utilizandoOJsonpathNoCaminhoDoBodyDaRespostaDeveSerOInteiro(String string, Object int1) {
		// Jsonpath
		JsonPath jpath = new JsonPath(response.asString());
		Assert.assertEquals(int1, jpath.getInt(string));
	}

	@Entao("usando o Fron, no caminho {string} do body da resposta deve ser o inteiro {int}")
	public void usandoOFronNoCaminhoDoBodyDaRespostaDeveSerOInteiro(String string, Object int1) {
		// from
		int id = JsonPath.from(response.asString()).getInt(string);
		Assert.assertEquals(int1, id);
	}

	@Entao("no caminho da lista {string} possui o tamanho {int}")
	public void noCaminhoDaListaPossuiOTamanho(String string, Integer int1) {
		// Validando tamanho da Lista
		response.then().body(string, hasSize(int1));

	}

	@Entao("no caminho da lista {string} do body da resposta deve ser a string {string}")
	public void noCaminhoDaListaDoBodyDaRespostaDeveSerAString(String string, String string2) {
		// Validando conteudo especifico da lista
		response.then().body(string, containsString(string2));
	}

	@Entao("no caminho da lista {string} contem o item {string}")
	public void noCaminhoDaListaContemOItem(String string, String string2) {
		// Validando se possui um item na lista
		response.then().body(string, hasItem(string2));
	}

	@Entao("no caminho da lista {string} contem os itens {string} e {string}")
	public void noCaminhoDaListaContemOsItensE(String string, String string2, String string3) {
		// Validando se possui um item na lista
		response.then().body(string, hasItems(string2, string3));
	}

	@Entao("no caminho {string} do body da resposta nao deve ser nulo")
	public void noCaminhoDoBodyDaRespostaNaoDeveSerNulo(String string) {
		response.then().body(string, notNullValue());
	}
	
	@Entao("no caminho {string} do body da resposta deve ser nulo")
	public void noCaminhoDoBodyDaRespostaDeveSerNulo(String string) {
		response.then().body(string, nullValue());
	}

}
