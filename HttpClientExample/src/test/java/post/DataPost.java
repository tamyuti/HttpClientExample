package post;



import pojoPost.UserData;

public class DataPost {
	
	UserData data=new UserData();
	public UserData setData(){
		data.setName("Test");
		data.setUsername("Test");
		data.setEmail("Test@test.com");
		return data;
	}
	
	
	


}
