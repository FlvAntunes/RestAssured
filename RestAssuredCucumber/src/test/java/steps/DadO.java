package steps;

import io.cucumber.java.pt.Dado;
import io.restassured.RestAssured;


public class DadO {
	
	public static Object body;
	


	@Dado("que minha URL base é {string}")
	public void queMinhaURLBaseE(String string) {
		RestAssured.baseURI = string;
	}

	@Dado("que o body Json contem {string}")
	public void que_o_body_json_contem(String string) {
		body = "{ \"name\": \"jose\", \"age\":50}";
	}
	
	
	
}
