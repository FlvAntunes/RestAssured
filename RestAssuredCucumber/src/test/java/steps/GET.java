package steps;

import org.junit.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET {

	private Response response;
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Quando("realizar um GET na URL {string}")
	public void realizar_um_get_na_url(String string) {

		response = RestAssured.request(Method.GET, string);


	}

	@Entao("^o status code deve ser (\\d+)$")
	public void o_status_code_deve_ser(int arg1) throws Throwable {
		Assert.assertEquals(arg1, response.getStatusCode());
		// jsonpath
		JsonPath jpath = new JsonPath(response.asString());
		Assert.assertEquals(1, jpath.getInt("id"));

		// fron
		int id = JsonPath.from(response.asString()).getInt("id");
		Assert.assertEquals(1, id);
		

//		System.out.println(response.getBody().asString());
		System.out.println("Status code: " + response.getStatusCode());

	}
	
	@Entao("no caminho do body da resposta {string} deve ser {string}")
	public void noCaminhoDoBodyDaRespostaDeveSer(String string, String string2) {
		
		JsonPath jpath = new JsonPath(response.asString());
		Assert.assertEquals(string2, jpath.get(string));
	}

	@Entao("anexo o body de resposta no relatorio")
	public void anexoOBodyDaRespostaNoRelatorio() {
//		scenario.attach(response.prettyPrint(), "text/plain", "obs");
		scenario.attach(response.getBody().asString(), "application/json", "obs");
	}

}
