

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

  
public class ddd {
    /*
     * Complete the function below.
     */
	public static String[] getMovieTitles(String substr) throws Exception {
	      StringBuilder result = new StringBuilder();
	    	String urlToRead = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+ substr;

	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      System.out.println(result.toString());
	      
	      return null;
	   }

   

    public static void main(String[] args) throws IOException{
    	try {
			getMovieTitles("Spiderman");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    }