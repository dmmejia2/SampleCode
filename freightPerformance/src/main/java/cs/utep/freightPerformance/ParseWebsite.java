package cs.utep.freightPerformance;
import java.io.*;
import java.net.*;

public class ParseWebsite {
   public double averageCrossTime;
   public String[] portOfEntryDates = new String[12];
   public int[] portOfEntryWait = new int[12];
	
   public void getHTML(String urlToRead) throws Exception {
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
      
      String [] arrString = webData.split("\"");
      
      //System.out.println("Website data : " + result.toString());
      
      int sum = 0;
      int count = 0;
      int monthCount = 0;
      for (int i = 0; i < arrString.length; i++) {
    	    //System.out.println(i + " : " + item);
    	  
    	  if(arrString[i].trim().equals("MONTHYEAR=")){
    		  
    		  int j=i+1;
    		  //System.out.println(arrString[j]);
    		  String[] tempDate = arrString[j].split("/");
    		  String tempMonth = tempDate[0];
    		  String tempYear = tempDate[1];
    		  int tempIntMonth = Integer.parseInt(tempMonth);
    		  if(tempIntMonth<10){
    			  tempMonth = "0"+tempMonth;
    		  }
    		  String crossDate = tempYear+"-"+tempMonth+"-01T00:00:00-07:00";
    		  portOfEntryDates[monthCount] = crossDate;
    		  monthCount++;
    		  //System.out.println(portOfEntry[monthCount]);
    		  //System.out.println(crossDate);
    		  
    	  }
    	  
    	    if(arrString[i].trim().equals("AVG_CROSS_TIME=")){
    	    	int j=i+1;
    	    	//System.out.println(arrString[j]);
    	    	portOfEntryWait[count] = Integer.parseInt(arrString[j]);    	    	
    	    	count++;
    	    	sum += Integer.parseInt(arrString[j]);
    	    	//System.out.println("AvgCrossTime " + count + " : " +arrString[j]);
        	}
      }
      for(int j=0; j<portOfEntryDates.length-1;j++){
    	  //System.out.println("Dates: "+portOfEntryDates[j]);
    	  //System.out.println("Time: "+portOfEntryWait[j]);
      }
      averageCrossTime = sum / count;
      //System.out.println("Total AverageCrossTime : " + averageCrossTime);
      return;
   }
}