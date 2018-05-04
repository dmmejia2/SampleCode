package cs.utep.freightPerformance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseWeatherCSV {
	
	
	public static void main(String[] args){

		try{
			String [] items = null;
			String csvFile = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/El Paso Weather 2014 PreProccessed.csv";
			String currentLine = "";
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			List<String []> dataList = new ArrayList<String []>();
			while((currentLine = reader.readLine())!=null){

				items = currentLine.split(",");
				dataList.add(items);

			//System.out.println(currentLine);
			}
			
			List<WeatherObject> WeatherList = new ArrayList<WeatherObject>();
			
			for(int i=1;i<dataList.size();i++){
				WeatherObject currentWeather = new WeatherObject();
				//System.out.println(dataList.get(i)[0]);
				currentWeather.location = dataList.get(i)[0];
				currentWeather.date = parseWeatherDate(dataList.get(i)[1]);
				currentWeather.precipitation = dataList.get(i)[2];
				currentWeather.snow = dataList.get(i)[3];
				currentWeather.averageTemp = dataList.get(i)[4];
				currentWeather.maxTemp = dataList.get(i)[5];
				currentWeather.minTemp = dataList.get(i)[6];
				currentWeather.averageWindSpeed = dataList.get(i)[7];
				currentWeather.fastWindTwoSec = dataList.get(i)[8];
				currentWeather.fastWindFiveSec = dataList.get(i)[9];
				WeatherList.add(currentWeather);
				
				
			}
			
			for(int i=0;i<WeatherList.size();i++){
				System.out.println("Location "+WeatherList.get(i).location);
				System.out.println("Date: "+WeatherList.get(i).date);
				System.out.println("Precipitation: "+WeatherList.get(i).precipitation);
				System.out.println("snow: "+ WeatherList.get(i).snow);
				System.out.println("Average Temp: "+WeatherList.get(i).averageTemp);
				System.out.println("maxTemp: "+WeatherList.get(i).maxTemp);
				System.out.println("minTemp: "+WeatherList.get(i).minTemp);
				System.out.println("averageWindSpeed: "+WeatherList.get(i).averageWindSpeed);
				System.out.println("fastWindTwoSec: "+WeatherList.get(i).fastWindTwoSec);
				System.out.println("fastWindFiveSec: "+WeatherList.get(i).fastWindFiveSec);
				System.out.println("");
				

				
			}
			
		}catch(Exception e){}
	}
	public static String parseWeatherDate(String tempDate){
		String date="";
		for(int i=0;i<tempDate.length();i++){
			date+=tempDate.charAt(i);
			if(i==3||i==5){
				date+="-";
			}
		}
		
		date+="T00:00:00-07:00";
		return date;
	}

}
