import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
Class description - helper class that is used to retrieve words from API .Uses HTTPURLConnection
class to fetch the words
@developer - Himanshu Mishra
@date - 7/01/2022

*/


public class WordRetrevial {
	protected String getWord() {
		  HttpURLConnection myconnection = null;
		  String word = null; // variable to store the fetched word
		  //this is the url path of api we used
		  String url_path= "https://random-word-api.herokuapp.com/word?number=1";
		  URL url = null;
		  
		  try{
			  url = new URL(url_path);
			  myconnection = (HttpURLConnection)url.openConnection();
			  myconnection.setRequestProperty("Accept","application/json");
			  myconnection.setRequestMethod("GET");
			  myconnection.connect();
			  int status = myconnection.getResponseCode(); //status is used to store the status of our url connection
			  switch(status) {
			  case 200 : //case that url is being fetched from api its in process
			  case 201:
				  //Successfully we have fetched the word
				  BufferedReader br = new BufferedReader(new InputStreamReader(myconnection.getInputStream()));
				 String temp = br.readLine();
				 int length = temp.length();
				 word = temp.substring(2,length-2);
			  }
			  
		
		  }
		  catch(IOException e) {
			  System.out.println(" error occured while word fetching");
		  }
		  finally {
			  myconnection.disconnect();
		  }
		  
		  return word;
	  }
}
