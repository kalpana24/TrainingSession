package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class HTTPRequest {
	int id;
	@Test(priority=1)
	void getUser() {
		given()
			
		.when()
			.get("http://reqres.in/api/users/2")
		
		.then()
			.statusCode(200)
		    .log().all();
	}
	
	@Test(priority=2)
	void createUser() {
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");
		
		id =given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
			System.out.println(id);
			
	}
	
	@Test(priority=3)
	void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "kaps");
		data.put("job", "Trainer");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
			
		
	}
	
	
}
