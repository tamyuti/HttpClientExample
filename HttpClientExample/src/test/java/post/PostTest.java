package post;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pojoPost.UserData;


public class PostTest {
	String endpointURL="https://jsonplaceholder.typicode.com";
	String requestURL="/users";
	
	HttpPost postReq;
	HttpResponse response;
	
	@BeforeClass
	public void postRequest() throws JsonGenerationException, JsonMappingException, IOException{
		HttpClient client=HttpClientBuilder.create().build();
		postReq=new HttpPost(endpointURL+requestURL);
		
		//pass data directly
		/*String data = "{\"name\": \"Test\",\"username\": \"test\",\"email\": \"test@test.com\"}";
        HttpEntity entity = new ByteArrayEntity(data.getBytes("UTF-8"));
        postReq.setEntity(entity);*/
		
		//pass data using Jackson
		DataPost d=new DataPost();
		ObjectMapper mapper = new ObjectMapper();

		UserData val=d.setData();
		
		//Convert object to JSON String
		String jsonInString=mapper.writeValueAsString(val);
        System.out.println(jsonInString);
        
        //Convert object to JSON string and pretty print
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(val);
		System.out.println(jsonInString);
       
		try {
			response=client.execute(postReq); 
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStatusCode(){
		int code=response.getStatusLine().getStatusCode();
		System.out.println(code);
		Assert.assertEquals(201, code);
	}
	
	/*@Test
	public void result() throws ParseException, IOException{
		String result = EntityUtils.toString(response.getEntity());
		System.out.println(result);
	}*/
	
	
	
	

}
