package get;

import java.io.IOException;



import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pojoGet.MyPojo;



public class GetTest {

	String endpointURL="https://jsonplaceholder.typicode.com";
	String requestURL="/users";
	//String URL="https://jsonplaceholder.typicode.com/users";
	HttpGet getReq;
	HttpResponse response;
	private MyPojo user;

	public MyPojo getUser() {
		return user;
	}

	public void setUser(MyPojo user) {
		this.user = user;
	}

	@BeforeClass
	public void getRequest(){
		//create an instance of HTTP Client
		HttpClient client=HttpClientBuilder.create().build();
		//create instance of HTTP GET
		getReq=new HttpGet(endpointURL+requestURL);

		try {
			response=client.execute(getReq);
			if(response!=null){
				setUser(ResourceUtil.retrieveResource(response, MyPojo.class));
			}
			else{
				System.out.println("Error" +response);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testStatusCode(){
		int statusCode=response.getStatusLine().getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	
	@Test
	public void testName(){
		Assert.assertEquals("Leanne Graham", user.getName());
		user.getName();
	}
	
	@Test
	public void testUsername(){
		Assert.assertEquals("Bret", user.getUsername());
	}
	
	@Test
	public void testAddress(){
		System.out.println(user.getAddress());
	}
	
	@Test
	public void testWebsite(){
		Assert.assertEquals("hildegard.org", user.getWebsite());
	}


}
