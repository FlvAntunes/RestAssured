package steps;

import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class QuandO {
	public static Response response;

	private Object body = DadO.body;

	@Quando("realizar um {string} na URL {string}")
	public void realizarUmNaURL(String string, String string2) {
//		response = RestAssured.get(string2);

		if (string.equals("get") || string.equals("GET")) {
			response = RestAssured.get(string2);
		} else {

			if (string.equals("post") || string.equals("POST")) {
				response = RestAssured.given().contentType(ContentType.JSON).body(body).post(string2);
				response.then().log().all();
			} else {
				if (string.equals("put") || string.equals("PUT")) {
					response = RestAssured.given().contentType(ContentType.JSON).body(body).put(string2);
					response.then().log().all();
				} else {
					if (string.equals("delete") || string.equals("DELETE")) {
						response = RestAssured.delete(string2);
						response.then().log().all();
					}
				}
			}
		}
	}

//	@Quando("realizar um POST na URL {string}")
//	public void realizar_um_post_na_url(String string) {
//		response = RestAssured.given().contentType("application/json").body(body).post(string);
//		response.then().log().all();
//		response.then().statusCode(201);
//	}

}
