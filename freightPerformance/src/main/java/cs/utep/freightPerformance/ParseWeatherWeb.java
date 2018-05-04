package cs.utep.freightPerformance;
import java.io.*;
import java.net.*;

public class ParseWeatherWeb {

	public static void main(String [] args) throws Exception{
		//getHTML("http://api.wunderground.com/api/e4de49fb18a77c27/history_20140101/settings/q/TX/El_Paso.json");
		getHTML("https://www.wunderground.com/history/airport/KELP/2014/3/10/DailyHistory.html?req_city=El+Paso&req_state=TX&req_statename=&reqdb.zip=79901&reqdb.magic=1&reqdb.wmo=99999");
	}
	
   public static void getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      String webData = result.toString();
      System.out.println(webData);
      
      String [] arrString = webData.split("\"");
      
      //System.out.println("Website data : " + result.toString());
      
      int sum = 0;
      int count = 0;
      int monthCount = 0;
      
}
}