package get;




import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import org.codehaus.jackson.map.ObjectMapper;




public class ResourceUtil {
	public static <X>X retrieveResource(HttpResponse response,Class<X> cl){
		String json = null;
		try
		{	
			json=EntityUtils.toString(response.getEntity());
			int length=json.length()-1;		
			String json2=json.substring(1, length);
			
			ObjectMapper mapper=new ObjectMapper();
			return mapper.readValue(json2, cl);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}

