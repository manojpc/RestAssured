import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class SimpleGetTest {
	
	@Test
	public void GetWeatherDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 
		
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
 
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Pune");
 
		//Response response = given().
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		
		Assert.assertEquals(response.getStatusCode() , 200 , "Status Code failed") ; 
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK" , "Status Line failed");
		
		Headers allheaders = response.getHeaders();
		for (Header header : allheaders)
		{
			System.out.println("Key: " + header.getName() + " | Value: " + header.getValue());
		}
		
		System.out.println("___________________________________________________________________");
		//Response Body
		ResponseBody body = response.body();
		
		System.out.println(body.asString());
		
		
	}

}
