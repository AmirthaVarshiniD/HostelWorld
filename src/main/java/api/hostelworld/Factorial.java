package api.hostelworld;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Factorial {

	@Test(dataProvider="testHostelWorld")
	public void factorial(String number) {

		RestAssured.baseURI = "http://qainterview.pythonanywhere.com";
		Response response = RestAssured 
				.given()
				 .param("number", number)
				.post("/factorial");
		System.out.println("Input Number: "+ number);
		System.out.println("Response Code: "+ response.statusCode());
		JsonPath jsonPath = response.jsonPath();
		System.out.println("Factorial of given number " +number+ " is:::: "+jsonPath.get("answer"));
		response.prettyPrint();
	}
	
	@DataProvider(name="testHostelWorld")
	public  Object[][] getData(){
		return InputDataReader.getSheet("HostelWorld");		
	}
	
}
