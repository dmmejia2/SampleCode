/**
 * Author: Daniel Mejia
 * Last Modified: March 30, 2017
 * WeatherObject class to describe weather objects
 */
package cs.utep.freightPerformance;

public class WeatherObject {
	
	//Attributes of Weather
	public String location="";
	public String date = "";
	public String precipitation="0.0";
	public String snow = "0.0";
	public String averageTemp;
	public String maxTemp = "0.0";
	public String minTemp = "0.0";
	public String averageWindSpeed = "0.0";
	public String fastWindTwoSec = "0.0";
	public String fastWindFiveSec = "0.0";
	public boolean dust;
	public boolean fog;
	
	//Default constructor
	public WeatherObject(){
		
	}

}
