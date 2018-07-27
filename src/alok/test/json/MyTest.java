package alok.test.json;

import java.io.IOException;
import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
* 
* @author alok
* Facebook Class - maintains the Facbook account details including posts
*/
class Facebook {
	private String id;
	private String fbid;
	private String fbname;
	private String fbemail;
	private Post fbPost;
	
	class Post {
		private String id;
		private String bannerId;
		transient private String created_time;
		
		/*
		Post(final String id, final String bannerId, final String created_time)
		{
			System.out.println("Alok Constructor called");
			this.id = id;
			this.bannerId = bannerId;
			this.created_time = created_time;
		}*/
		
		@Override
		public String toString()
		{
			StringBuffer str = new StringBuffer();
			return str.append("Post Data: \n\t\tID: " + id 
					+ "\n\t\tbannerId: " + bannerId
					+ "\n\t\tCreation Time: " + created_time
					).toString();
		}
	}
	
	/*
	Facebook(final String id, final String fbid, final String fbname, final String fbemail, Post fbPost)
	{
		this.id = id;
		this.fbid = fbid;
		this.fbname = fbname;
		this.fbname = fbemail;
		this.fbPost = fbPost;
	}*/
	
	@Override
	public String toString()
	{
		System.out.println("Alok toString called");
		StringBuffer str = new StringBuffer();
		return str.append("Facebook Data: \n\tID: " + id 
				+ "\n\tFacebookID: " + fbid
				+ "\n\tName: " + fbname
				+ "\n\tEmail: " + fbemail
				+ "\n\tPosts: " + fbPost
				).toString();
	}	
}

public class MyTest {

	public static void main(String[] args) {
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//from json sring to Facebook object generation
		String jsonMyFBData = "{\"id\": \"Alok.Singh@evolving.com\", \"fbid\": \"10154149978873611\", \"fbname\": \"Alok Singh\", \"fbemail\": \"alok.ku.singh@gmail.com\", \"fbPost\": {\"id\": \"10154228946963611_10154232235698611\", \"bannerId\": \"CounterStrike\", \"created_time\": \"2016-10-26T12:17:41+0000\"}}";
		//String jsonMyFBData = "{\"id\": \"Alok.Singh@evolving.com\", \"fbid\": \"10154149978873611\", \"fbname\": \"Alok Singh\", \"fbemail\": \"alok.ku.singh@gmail.com\", \"fbPost\": {\"id\": \"10154228946963611_10154232235698611\", \"bannerId\": \"CounterStrike\"}}";
		Facebook fbObject = gson.fromJson(jsonMyFBData, Facebook.class);
		System.out.println(fbObject);
		
		//From Facebook object to json string generation
		String str = gson.toJson(fbObject);
		System.out.println(str);
		
		//Read the JSON string
		JsonReader jsonReader = new JsonReader(new StringReader(jsonMyFBData));
		try {
			while (jsonReader.hasNext())
			{
		        JsonToken nextToken = jsonReader.peek();
		        System.out.println("nextToken: " + nextToken);

		        if(JsonToken.BEGIN_OBJECT.equals(nextToken))
		        {
		            jsonReader.beginObject();

		        } 
		        else if(JsonToken.NAME.equals(nextToken))
		        {
		            String name  =  jsonReader.nextName();
		            System.out.print(name + " --> ");

		        } 
		        else if(JsonToken.STRING.equals(nextToken))
		        {
		            String value =  jsonReader.nextString();
		            System.out.println(value);
		        } 
		        else if(JsonToken.NUMBER.equals(nextToken))
		        {
		            long value =  jsonReader.nextLong();
		            System.out.println(value);
		        }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Parse the JSON string - fbObject.fbPost.bannerId
		JsonParser jParser = new  JsonParser();
		JsonElement jTree = jParser.parse(jsonMyFBData);
		
		JsonObject jObject = null;
		if (jTree.isJsonObject())
		{
			jObject = jTree.getAsJsonObject();
		}
		
		if (jObject != null)
		{
			System.out.println("Alok: " + jObject.get("fbname"));
			System.out.println("Alok: " + jObject.get("fbPost"));
			System.out.println("Alok: " + jObject.getAsJsonObject("fbPost").get("bannerId"));
		}
		

	}

}
