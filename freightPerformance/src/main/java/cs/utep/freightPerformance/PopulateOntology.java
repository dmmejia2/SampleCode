/**
 *  Author: Daniel Mejia
 *  Contributors: Eric Camacho, Jose Caballero, Moinul Porag Chowdhury
 *  Last Modified: March 30, 2017
 *  
 *  The following program takes in a generic ontology that has
 *  been defined with static classes.  From the static classes that are
 *  generically implemented, we will populate the classes with data.
 *  The data comes from heterogeneous formats, including Excel (CSV), 
 *  PDF, and online data.  From the parsed data, it will then be populated
 *  into the ontolgy so that SPARQL queries can be made.
 */
package cs.utep.freightPerformance;
//Java imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.semanticweb.HermiT.Reasoner;
//OWL API Imports
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

public class PopulateOntology {

	@SuppressWarnings("deprecation")
	public static void main( String[] args ) throws OWLOntologyCreationException{

		//Defines the Freight Performance Ontology File
		//Defines the prefix for the Ontology
		String ontFile = "FreightPerformanceProvPopulate3Year14-16FullAssertion.owl";
		String prefix = "http://ontology.cybershare.utep.edu/smart-cities/FreightPerformance/#";



		//Creates the ontology manager and factory
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLDataFactory factory = manager.getOWLDataFactory();
		//Local file of the Freight Performance Classes, where all of the classes are defined
		File file = new File("/Users/danielmejia/Documents/FreightPerformanceClassesProvFullAssertion.owl");

		// Now load the local copy
		//The prefix manager allows us to access the Freight Performance ontology and get the classes from it.
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);
		PrefixManager pm = new DefaultPrefixManager("http://ontology.cybershare.utep.edu/smart-cities/FreightPerformance/#");

		// Use the prefix manager and just specify an abbreviated IRI
		OWLClass IncidentClass = factory.getOWLClass(":Incident", pm);
		OWLClass WeatherRelatedIncidentClass = factory.getOWLClass(":WeatherRelatedIncident", pm);
		OWLClass FatalIncidentClass = factory.getOWLClass(":FatalIncident", pm);
		OWLClass ResponseTimeToIncidentsClass = factory.getOWLClass(":ResponseTimeToIncidents", pm);
		OWLClass TrafficMeasurementsClass = factory.getOWLClass(":TrafficMeasurements", pm);
		OWLClass TrafficVolumeClass = factory.getOWLClass(":TrafficVolume", pm);
		factory.getOWLClass(":WindMeasurement", pm);
		OWLClass AverageWindClass = factory.getOWLClass(":AverageWind", pm);
		OWLClass FastestFiveSecondWindClass = factory.getOWLClass(":FastestFiveSecondWind", pm);
		OWLClass FastestTwoSecondWindClass = factory.getOWLClass(":FastestTwoSecondWind", pm);
		OWLClass SnowMeasurementClass = factory.getOWLClass(":SnowMeasurement", pm);
		OWLClass PrecipitationMeasurementClass = factory.getOWLClass(":PrecipitationMeasurement", pm);
		factory.getOWLClass(":TemperatureMeasurement", pm);
		OWLClass MaximumTemperatureClass = factory.getOWLClass(":MaximumTemperature", pm);
		OWLClass MinimumTemperatureClass = factory.getOWLClass(":MinimumTemperature", pm);
		OWLClass AverageTemperatureClass = factory.getOWLClass(":AverageTemperature", pm);
		OWLClass PortOfEntryClass = factory.getOWLClass(":PortOfEntry", pm);
		OWLClass DustClass = factory.getOWLClass(":Dust",pm);

		//Creates the hasUnit object property
		OWLObjectProperty hasUnit = factory.getOWLObjectProperty(":hasUnit",pm);

		//Creates specific individuals that describe the units
		OWLNamedIndividual minuteIndividual = factory.getOWLNamedIndividual(":Minutes",pm);
		OWLNamedIndividual hourIndividual = factory.getOWLNamedIndividual(":Hours",pm);
		factory.getOWLNamedIndividual(":Celsius",pm);
		OWLNamedIndividual fahrenheitIndividual = factory.getOWLNamedIndividual(":Fahrenheit",pm);
		OWLNamedIndividual inchesIndividual = factory.getOWLNamedIndividual(":Inches",pm);
		OWLNamedIndividual dollarIndividual = factory.getOWLNamedIndividual(":Dollars",pm);
		OWLNamedIndividual percentIndividual = factory.getOWLNamedIndividual(":Percent",pm);
		OWLNamedIndividual congestionToTimeIndividual = factory.getOWLNamedIndividual(":CongestionToTime",pm);
		OWLNamedIndividual peakToActualTravelIndividual = factory.getOWLNamedIndividual(":PeakTravelToAcutalTime",pm);
		OWLNamedIndividual MPHIndividual = factory.getOWLNamedIndividual(":MilesPerHour",pm);
		OWLNamedIndividual tonsIndividual = factory.getOWLNamedIndividual(":Tons",pm);
		factory.getOWLNamedIndividual(":Gallons",pm);




		//OWLDataProperty		
		OWLDataProperty hasIncidentMainStreet = factory.getOWLDataProperty(IRI.create(prefix  + "hasIncident.MainStreet"));
		OWLDataProperty hasIncidentSecondaryStreet = factory.getOWLDataProperty(IRI.create(prefix  + "hasIncident.SecondaryStreet"));
		OWLDataProperty hasIncidentCrashTime = factory.getOWLDataProperty(IRI.create(prefix  + "hasIncident.CrashTime"));
		OWLDataProperty hasResponseTimeToIncidentsArrivalTime = factory.getOWLDataProperty(IRI.create(prefix  + "hasResponseTimeToIncidents.ArrivalTime"));
		factory.getOWLDataProperty(IRI.create(prefix  + "hasResponseTimeToIncidents.FinalResponseTime"));
		OWLDataProperty hasResponseTimeToIncidentsNotifyTime = factory.getOWLDataProperty(IRI.create(prefix  + "hasResponseTimeToIncidents.NotifyTime"));
		OWLDataProperty hasTrafficVolumeValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasTrafficVolume.Value"));
		OWLDataProperty hasTrafficVolumeIntersectionStreet = factory.getOWLDataProperty(IRI.create(prefix  + "hasTrafficVolume.IntersectionStreet"));
		OWLDataProperty hasTrafficVolumePrimaryStreet = factory.getOWLDataProperty(IRI.create(prefix  + "hasTrafficVolume.PrimaryStreet"));
		OWLDataProperty hasPOEMinutes = factory.getOWLDataProperty(IRI.create(prefix  + "hasPOE.Minutes"));
		OWLDataProperty hasPOEMonth = factory.getOWLDataProperty(IRI.create(prefix  + "hasPOE.Month"));
		OWLDataProperty hasPOELocation = factory.getOWLDataProperty(IRI.create(prefix  + "hasPOE.Location"));
		OWLDataProperty hasWeatherLocation = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.Location"));
		OWLDataProperty hasWeatherDate = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.Date"));
		OWLDataProperty hasWeatherAverageWindSpeed = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.AverageWindSpeed"));
		OWLDataProperty hasWeatherFastFiveSecondWind = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.FastFiveSecondWind"));
		OWLDataProperty hasWeatherFastTwoSecondWind = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.FastTwoSecondWind"));
		OWLDataProperty hasWeatherAverageTemp = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.AverageTemp"));
		OWLDataProperty hasWeatherMinTemp = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.MinTemp"));
		OWLDataProperty hasWeatherMaxTemp = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.MaxTemp"));
		OWLDataProperty hasWeatherSnow= factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.Snow"));
		OWLDataProperty hasWeatherPrecipitation = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.Precipitation"));
		OWLDataProperty hasWeatherDust = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeather.Dust"));





		factory.getOWLObjectProperty(IRI.create(prefix  + "isPartOf"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "isIndicatorOf"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "TimeCausedBy"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "cause"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "affects"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "Calculates"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "uses"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "multiplyByLength"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "costOf"));
		factory.getOWLObjectProperty(IRI.create(prefix  + "coversArea"));
		try{
			double startTime=0.0;
			double endTime=0.0;
			//CSV File Location
			Queue<String> csvFileQueue = new LinkedList<String>();
			String cmvIncidents1 = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/cmv 2014 incidents.csv";
			String cmvIncidents2 = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/cmv 2015 incidents.csv";
			String cmvIncidents3 = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/cmv 2016 incidents.csv";
			csvFileQueue.add(cmvIncidents1);
			csvFileQueue.add(cmvIncidents2);
			csvFileQueue.add(cmvIncidents3);
			String currentLine = "";

			Queue<List> allData = new LinkedList<List>();
			while(!(csvFileQueue.isEmpty())){
				String currentFile = csvFileQueue.remove();
				BufferedReader reader = new BufferedReader(new FileReader(currentFile));
				List<String []> dataList = new ArrayList<String []>();


				while((currentLine = reader.readLine())!=null){
					String[] quote = currentLine.split("\"");
					if(quote.length>1){
						boolean startQuote=false;
						for(int i=0;i<currentLine.length();i++){
							if(currentLine.charAt(i)=='"'&&startQuote==false){
								startQuote = true;
								i++;
							}
							if(startQuote){
								if(currentLine.charAt(i)==','){
									String tempLine = currentLine.substring(0,i) +'/'+currentLine.substring(i+1);
									currentLine = tempLine;
									//System.out.println("TEMP: "+currentLine);
								}
							}
							if(currentLine.charAt(i)=='"'&&startQuote==true){
								startQuote = false;
							}
						}
					}

					//Adds all values into an items array	
					String [] items = currentLine.split(",");
					//System.out.println(items[0]);
					dataList.add(items);



				}
				reader.close();
				allData.add(dataList);
			}
			while(!allData.isEmpty()){
				List<String []> dataList = allData.remove();

				//Specifies the first line where the relevant items are at and their column
				List<Object []> indexList = new ArrayList<Object []>();
				for(int i=0;i<dataList.get(0).length;i++){
					//System.out.println("COLUMN NAME: "+dataList.get(0)[i]);

					//Gets column name and creates a meta data array for the item to hold the index position
					//Or the name of the column
					String columnName = dataList.get(0)[i];
					Object [] metaData = new Object[2];//Crash_ID
					if(columnName.equals("Crash_ID")){
						metaData[0] = "Crash_ID";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Crash_Date")){
						metaData[0] = "Crash_Date";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Crash_Time")){
						metaData[0] = "Crash_Time";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Death_Cnt")){
						metaData[0] = "Death_Cnt";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Othr_Factr_ID")){
						metaData[0] = "Othr_Factr_ID";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Wthr_Cond_ID")){
						metaData[0] = "Wthr_Cond_ID";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Investigat_Notify_Time")){
						metaData[0] = "Investigat_Notify_Time";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Investigat_Arrv_Time")){
						metaData[0] = "Investigat_Arrv_Time";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Rpt_Street_Name")){
						metaData[0] = "Rpt_Street_Name";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Rpt_Sec_Street_Name")){
						metaData[0] = "Rpt_Sec_Street_Name";
						metaData[1] = i;
						indexList.add(metaData);
					}	

				}

				//Parser takes all of the incidents and creates a new object currentIncident
				//This object has all of the necessary attributes that are required and taken from the meta data array
				//All of the incidents information are added to the object then added to allIncidents list
				List<IncidentObject> allIncidents = new ArrayList<IncidentObject>();
				for(int i=1;i<dataList.size();i++){			
					IncidentObject currentIncident = new IncidentObject();

					for(int j=0;j<indexList.size();j++){


						if(indexList.get(j)[0].equals("Crash_ID")){
							currentIncident.Crash_ID = Integer.parseInt(dataList.get(i)[(Integer) indexList.get(j)[1]]);
						}


						if(indexList.get(j)[0].equals("Crash_Date")){
							String date = dataList.get(i)[(Integer) indexList.get(j)[1]];
							String[] date2 = date.split("/");
							String month = date2[0];
							String day = date2[1];
							String year = date2[2];
							int tempDay = Integer.parseInt(day);
							int tempMonth = Integer.parseInt(month);
							if(tempDay<10){
								day = "0"+day;
							}
							if(tempMonth<10){
								month = "0"+month;
							}
							date = year+"-"+month+"-"+day;
							currentIncident.setCrashDate(date);

						}
						if(indexList.get(j)[0].equals("Crash_Time")){
							String time = dataList.get(i)[(Integer) indexList.get(j)[1]];
							String[] time2 = time.split(":");
							String hour = time2[0];
							int tempHour = Integer.parseInt(hour);
							if(tempHour<10){
								hour = "0"+hour;
							}
							time = hour+":"+time2[1];
							currentIncident.Crash_Time = time;
						}

						if(indexList.get(j)[0].equals(("Rpt_Street_Name"))){
							String mainStreet = dataList.get(i)[(Integer)indexList.get(j)[1]];
							if(mainStreet.contains("I10")||mainStreet.contains("I 10")||mainStreet.contains("IH 10")||mainStreet.contains("INTERSTATE 10")){
								mainStreet = "I 10";

							}
							if(mainStreet.contains("375")){
								mainStreet = "LOOP 375";

							}
							currentIncident.Rpt_Street_Name=mainStreet;

						}
						if(indexList.get(j)[0].equals(("Rpt_Sec_Street_Name"))){
							String secStreet = dataList.get(i)[(Integer)indexList.get(j)[1]];
							if(secStreet.contains("I10")||secStreet.contains("I 10")||secStreet.contains("IH 10")||secStreet.contains("INTERSTATE 10")){
								secStreet = "I 10";
							}
							if(secStreet.contains("375")){
								secStreet = "LOOP 375";
							}
							currentIncident.Rpt_Sec_Street_Name= secStreet;
						}

						if(indexList.get(j)[0].equals("Death_Cnt")){
							Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
							currentIncident.Death_Cnt = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

						}
						if(indexList.get(j)[0].equals("Othr_Factr_ID")){
							int weatherValue =Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
							if(weatherValue==1){
								currentIncident.Othr_Factr_ID = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

							}
						}
						if(indexList.get(j)[0].equals("Wthr_Cond_ID")){
							int weatherValue =Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
							if(weatherValue==1||weatherValue==2||weatherValue==4||weatherValue==6){
								currentIncident.Wthr_Cond_ID = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

							}
						}
						if(indexList.get(j)[0].equals("Investigat_Arrv_Time")&&indexList.get(j-1)[0].equals("Investigat_Notify_Time")){


							String arriveTime = dataList.get(i)[(Integer) indexList.get(j)[1]];
							String[] arriveTime2 = arriveTime.split(":");
							String arriveHour = arriveTime2[0];
							int arriveTempHour = Integer.parseInt(arriveHour);
							if(arriveTempHour<10){
								arriveHour = "0"+arriveHour;
							}
							String[] atime = arriveTime.split(" ");
							int ahour = Integer.parseInt(atime[0].split(":")[0]);
							int aminutes = Integer.parseInt(atime[0].split(":")[1]);
							if(atime[1].equals("PM")){
								ahour+=12;
							}
							arriveTime = arriveHour+":"+arriveTime2[1];

							endTime = (ahour*60)+aminutes;
							currentIncident.Investigat_Arrv_Time = arriveTime;
							currentIncident.endTime = endTime;

							//Notify Time
							String notifyTime = dataList.get(i)[(Integer) indexList.get(j-1)[1]];
							String[] notifyTime2 = notifyTime.split(":");
							String notifyHour = notifyTime2[0];
							int notifyTempHour = Integer.parseInt(notifyHour);
							if(notifyTempHour<10){
								notifyHour = "0"+notifyHour;
							}
							String[] ntime = arriveTime.split(" ");
							int nhour = Integer.parseInt(ntime[0].split(":")[0]);
							int nminutes = Integer.parseInt(ntime[0].split(":")[1]);
							if(ntime[1].equals("PM")){
								nhour+=12;
							}
							notifyTime = notifyHour+":"+notifyTime2[1];

							startTime = (nhour*60)+nminutes;
							currentIncident.Investigat_Notify_Time = notifyTime;
							currentIncident.startTime = startTime;

							currentIncident.totalTime = (endTime-startTime);

						}
					}

					allIncidents.add(currentIncident);
				}

				//This for loop takes all of the incidents and begins to populate the ontology
				//The syntax used is a standard for the OWL API based on documentation
				for(int i=0;i<allIncidents.size();i++){

					String date = allIncidents.get(i).Crash_Date;
					String time = allIncidents.get(i).Crash_Time;
					String notify = allIncidents.get(i).Investigat_Notify_Time;
					String arrive = allIncidents.get(i).Investigat_Arrv_Time;
					String dateString = formatDateString(date,time);
					String notifyString = formatNotifyString(date,notify);
					String arriveString = formatArriveString(date, arrive);

					if(allIncidents.get(i).Othr_Factr_ID>0 || allIncidents.get(i).Wthr_Cond_ID>0){

						//Named individual
						OWLNamedIndividual weatherIncidentIndividual = factory.getOWLNamedIndividual(IRI.create("weather_incident_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom WeatherIncidentClassAssertion = factory.getOWLClassAssertionAxiom(WeatherRelatedIncidentClass, weatherIncidentIndividual);
						manager.applyChange(new AddAxiom(ontology,WeatherIncidentClassAssertion));

						//Gives the data properties and adds them to the ontology
						OWLAxiom hasMainStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentMainStreet, weatherIncidentIndividual, allIncidents.get(i).Rpt_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasMainStreetAxiom));

						OWLAxiom hasSecStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentSecondaryStreet, weatherIncidentIndividual, allIncidents.get(i).Rpt_Sec_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasSecStreetAxiom));

						OWLNamedIndividual incidentResponseIndividual = factory.getOWLNamedIndividual(IRI.create("weather_incidentResponseTime_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom incidentResponseClassAssertion = factory.getOWLClassAssertionAxiom(ResponseTimeToIncidentsClass, incidentResponseIndividual);
						manager.applyChange(new AddAxiom(ontology,incidentResponseClassAssertion));

						OWLLiteral dateLiteral = factory.getOWLTypedLiteral(dateString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom hasCrashTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentCrashTime, weatherIncidentIndividual, dateLiteral);
						manager.applyChange(new AddAxiom(ontology, hasCrashTimeAxiom));

						OWLLiteral notifyLiteral = factory.getOWLTypedLiteral(notifyString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseNotifyAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsNotifyTime, incidentResponseIndividual, notifyLiteral);
						manager.applyChange(new AddAxiom(ontology, responseNotifyAxiom));

						OWLLiteral arriveLiteral = factory.getOWLTypedLiteral(arriveString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseArriveAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsArrivalTime, incidentResponseIndividual, arriveLiteral);
						manager.applyChange(new AddAxiom(ontology, responseArriveAxiom));

					}else if(allIncidents.get(i).Death_Cnt>0){

						//Incident individual
						OWLNamedIndividual fatalIncidentIndividual = factory.getOWLNamedIndividual(IRI.create("fatal_incident_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom fatalIncidentClassAssertion = factory.getOWLClassAssertionAxiom(FatalIncidentClass, fatalIncidentIndividual);
						manager.applyChange(new AddAxiom(ontology,fatalIncidentClassAssertion));

						OWLNamedIndividual incidentResponseIndividual = factory.getOWLNamedIndividual(IRI.create("fatal_incidentResponseTime_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom incidentResponseClassAssertion = factory.getOWLClassAssertionAxiom(ResponseTimeToIncidentsClass, incidentResponseIndividual);
						manager.applyChange(new AddAxiom(ontology,incidentResponseClassAssertion));


						//Adds data properties
						OWLAxiom hasMainStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentMainStreet, fatalIncidentIndividual, allIncidents.get(i).Rpt_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasMainStreetAxiom));

						OWLAxiom hasSecStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentSecondaryStreet, fatalIncidentIndividual, allIncidents.get(i).Rpt_Sec_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasSecStreetAxiom));

						OWLLiteral dateLiteral = factory.getOWLTypedLiteral(dateString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom hasCrashTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentCrashTime, fatalIncidentIndividual, dateLiteral);
						manager.applyChange(new AddAxiom(ontology, hasCrashTimeAxiom));

						OWLLiteral notifyLiteral = factory.getOWLTypedLiteral(notifyString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseNotifyAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsNotifyTime, incidentResponseIndividual, notifyLiteral);
						manager.applyChange(new AddAxiom(ontology, responseNotifyAxiom));

						OWLLiteral arriveLiteral = factory.getOWLTypedLiteral(arriveString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseArriveAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsArrivalTime, incidentResponseIndividual, arriveLiteral);
						manager.applyChange(new AddAxiom(ontology, responseArriveAxiom));

					}else if(allIncidents.get(i).Death_Cnt==0){
						//Named individuals
						OWLNamedIndividual incidentIndividual = factory.getOWLNamedIndividual(IRI.create("incident_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom incidentClassAssertion = factory.getOWLClassAssertionAxiom(IncidentClass, incidentIndividual);
						manager.applyChange(new AddAxiom(ontology,incidentClassAssertion));

						//Data properties
						OWLAxiom hasMainStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentMainStreet, incidentIndividual, allIncidents.get(i).Rpt_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasMainStreetAxiom));

						OWLAxiom hasSecStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentSecondaryStreet, incidentIndividual, allIncidents.get(i).Rpt_Sec_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasSecStreetAxiom));


						OWLNamedIndividual incidentResponseIndividual = factory.getOWLNamedIndividual(IRI.create("incidentResponseTime_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom incidentResponseClassAssertion = factory.getOWLClassAssertionAxiom(ResponseTimeToIncidentsClass, incidentResponseIndividual);
						manager.applyChange(new AddAxiom(ontology,incidentResponseClassAssertion));


						OWLLiteral dateLiteral = factory.getOWLTypedLiteral(dateString, OWL2Datatype.XSD_DATE_TIME);
						OWLDataPropertyAssertionAxiom hasCrashTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentCrashTime, incidentIndividual, dateLiteral);
						manager.applyChange(new AddAxiom(ontology, hasCrashTimeAxiom));


						OWLLiteral notifyLiteral = factory.getOWLTypedLiteral(notifyString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseNotifyAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsNotifyTime, incidentResponseIndividual, notifyLiteral);
						manager.applyChange(new AddAxiom(ontology, responseNotifyAxiom));

						OWLLiteral arriveLiteral = factory.getOWLTypedLiteral(arriveString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseArriveAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsArrivalTime, incidentResponseIndividual, arriveLiteral);
						manager.applyChange(new AddAxiom(ontology, responseArriveAxiom));

					}

				}
			}
			//Another data source that is parsed
			String csvFile1 = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/TTI UMR complete-dataELP.csv";
			String currentLine1 = "";
			BufferedReader reader1 = new BufferedReader(new FileReader(csvFile1));
			List<String []> dataList1 = new ArrayList<String []>();
			while((currentLine1 = reader1.readLine())!=null){

				String [] items = currentLine1.split(",");

				//Only concerned with data from El Paso TX-NM
				if(items[0].equals("El Paso TX-NM")&&items[0]!=""){
					//System.out.println(currentLine);
					dataList1.add(items);
				}
			}
			reader1.close();
			double hourDelay = 0;
			double hourDelayCount=0;

			double congestionCost=0;
			double congestionCostCount = 0;

			double congestionTime = 0;
			double congestionTimeCount = 0;

			double percentSystem = 0;
			double percentSystemCount = 0;

			double percentTravel = 0;
			double percentTravelCount = 0;

			double gasPrice = 0;
			double gasPriceCount = 0;

			double dieselPrice = 0;
			double dieselPriceCount = 0;

			double travelTimeIndex = 0;
			double travelTimeIndexCount = 0;

			double comuterStress = 0;
			double comuterStressCount = 0;

			double valueTime = 0;
			double valueTimeCount = 0;

			//For all of the information in the dataList1, it is taken with respect to the concept map MainConceptMap.vue
			for(int i=0;i<dataList1.size();i++){


				//Average Peak Hour Delay (Column V - 21)
				if(!dataList1.get(i)[21].equals("")){
					hourDelay += Double.parseDouble(dataList1.get(i)[21]);
					hourDelayCount++;

				}


				//Congestion Cost (Column AD - 29)
				if(!dataList1.get(i)[29].equals("")){
					congestionCost += Double.parseDouble(dataList1.get(i)[29]);
					congestionCostCount++;

				}

				//Congestion Time (Column O - 14)
				if(!dataList1.get(i)[14].equals("")){
					congestionTime += Double.parseDouble(dataList1.get(i)[14]);
					congestionTimeCount++;

				}


				//Percent of system congested (Column N - 13)
				if(!dataList1.get(i)[13].equals("")){
					percentSystem += Double.parseDouble(dataList1.get(i)[13]);
					percentSystemCount++;


				}

				//Percent of Travel Congested (Column M - 12)
				if(!dataList1.get(i)[12].equals("")){
					percentTravel += Double.parseDouble(dataList1.get(i)[12]);
					percentTravelCount++;				

				}


				//Gasoline Price (Column K - 10)
				if(!dataList1.get(i)[10].equals("")){
					gasPrice += Double.parseDouble(dataList1.get(i)[10]);
					gasPriceCount++;

				}

				//Diesel Price (Column L - 11)
				if(!dataList1.get(i)[11].equals("")){
					dieselPrice += Double.parseDouble(dataList1.get(i)[11]);
					dieselPriceCount++;
				}

				//Travel Time Index (Column X - 23)
				if(!dataList1.get(i)[23].equals("")){
					travelTimeIndex += Double.parseDouble(dataList1.get(i)[23]);
					travelTimeIndexCount++;

				}

				//Commuter Stress Index (Column Z - 25) 
				if(!dataList1.get(i)[25].equals("")){
					comuterStress += Double.parseDouble(dataList1.get(i)[25]);
					comuterStressCount++;

				}

				//Value of Time (Column I - 9)
				if(!dataList1.get(i)[9].equals("")){
					valueTime += Double.parseDouble(dataList1.get(i)[9]);
					valueTimeCount++;

				}
			}

			double averageDelay = hourDelay/hourDelayCount;
			double averageCongestionCost = congestionCost/congestionCostCount;
			double averageCongestionTime = congestionTime/congestionTimeCount;
			double averagePercentSystem = percentSystem/percentSystemCount;
			double averagePercentTravel = percentTravel/percentTravelCount;
			double averageGasPrice = gasPrice/gasPriceCount;
			double averageDieselPrice = dieselPrice/dieselPriceCount;
			double averageTravelTimeIndex = travelTimeIndex/travelTimeIndexCount;
			double averageComuterStress = comuterStress/comuterStressCount;
			double averageValueTime = valueTime/valueTimeCount;

			//Each of the following follow the same structure
			//Named individual
			//Object property from defined units
			//Data property
			//For each, it is added and updated to the ontology

			//Named individual
			//Hour Delay
			OWLNamedIndividual peakHourIndividual = factory.getOWLNamedIndividual(IRI.create("AveragePeakHourDelay"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion0 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, peakHourIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion0));

			//Object property from defined units
			OWLObjectPropertyAssertionAxiom HourAssertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, peakHourIndividual, hourIndividual);
			manager.applyChange(new AddAxiom(ontology,HourAssertion));

			//Data property
			OWLDataProperty hasAveragePeakHourData = factory.getOWLDataProperty(":hasAveragePeakHourDelay.AveragePeakYear",pm);
			OWLAxiom hasAveragePeakHourAxiom = factory.getOWLDataPropertyAssertionAxiom(hasAveragePeakHourData, peakHourIndividual, averageDelay);
			manager.applyChange(new AddAxiom(ontology, hasAveragePeakHourAxiom));


			//Congestion Cost
			OWLNamedIndividual congestionCostIndividual = factory.getOWLNamedIndividual(IRI.create("CongestionCost"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, congestionCostIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion));

			OWLObjectPropertyAssertionAxiom dollarAssertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, congestionCostIndividual, dollarIndividual);
			manager.applyChange(new AddAxiom(ontology,dollarAssertion));

			OWLDataProperty hasCongestionCostData = factory.getOWLDataProperty(":hasCongestionCost",pm);
			OWLAxiom hasCongestionCostAxiom = factory.getOWLDataPropertyAssertionAxiom(hasCongestionCostData, congestionCostIndividual, averageCongestionCost);
			manager.applyChange(new AddAxiom(ontology, hasCongestionCostAxiom));



			//Congestion Time
			OWLNamedIndividual congestionTimeIndividual = factory.getOWLNamedIndividual(IRI.create("AverageCongestionTime"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion1 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, congestionTimeIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion1));

			OWLObjectPropertyAssertionAxiom HourAssertion2 = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, congestionTimeIndividual, hourIndividual);
			manager.applyChange(new AddAxiom(ontology,HourAssertion2));

			OWLDataProperty hasCongestionTimeData = factory.getOWLDataProperty(":hasCongestionTime.RushHours",pm);
			OWLAxiom hasCongestionTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasCongestionTimeData, congestionTimeIndividual, averageCongestionTime);
			manager.applyChange(new AddAxiom(ontology, hasCongestionTimeAxiom));


			//Percent System Congested
			OWLNamedIndividual percentSystemIndividual = factory.getOWLNamedIndividual(IRI.create("SystemCongestedPercentage"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion2 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, percentSystemIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion2));

			OWLObjectPropertyAssertionAxiom percentAssertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, percentSystemIndividual, percentIndividual);
			manager.applyChange(new AddAxiom(ontology,percentAssertion));

			OWLDataProperty hasCongestionPercentData = factory.getOWLDataProperty(":hasPercentOfSystemCongested",pm);
			OWLAxiom hasCongestionPercentAxiom = factory.getOWLDataPropertyAssertionAxiom(hasCongestionPercentData, percentSystemIndividual, averagePercentSystem);
			manager.applyChange(new AddAxiom(ontology, hasCongestionPercentAxiom));


			//Percent Travel Time
			OWLNamedIndividual percentTravelIndividual = factory.getOWLNamedIndividual(IRI.create("SystemTravelCongestedPercentage"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion3 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, percentTravelIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion3));

			OWLObjectPropertyAssertionAxiom percentAssertion2 = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, percentTravelIndividual, percentIndividual);
			manager.applyChange(new AddAxiom(ontology,percentAssertion2));

			OWLDataProperty hasCongestionTravelPercentData = factory.getOWLDataProperty(":hasPercentOfTravelCongested",pm);
			OWLAxiom hasCongestionTravelPercentAxiom = factory.getOWLDataPropertyAssertionAxiom(hasCongestionTravelPercentData, percentTravelIndividual, averagePercentTravel);
			manager.applyChange(new AddAxiom(ontology, hasCongestionTravelPercentAxiom));


			//Gas Price
			OWLNamedIndividual gasPriceIndividual = factory.getOWLNamedIndividual(IRI.create("AverageGasPrice"));//Double.toString(averageGasPrice)));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion4 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, gasPriceIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion4));

			OWLObjectPropertyAssertionAxiom dollarAssertion2= factory.getOWLObjectPropertyAssertionAxiom(hasUnit, gasPriceIndividual, dollarIndividual);
			manager.applyChange(new AddAxiom(ontology,dollarAssertion2));

			OWLDataProperty hasgasPriceData = factory.getOWLDataProperty(":hasGasolinePrice.Value",pm);
			OWLAxiom hasgasPriceAxiom = factory.getOWLDataPropertyAssertionAxiom(hasgasPriceData, gasPriceIndividual, averageGasPrice);
			manager.applyChange(new AddAxiom(ontology, hasgasPriceAxiom));


			//Diesel Price
			OWLNamedIndividual dieselPriceIndividual = factory.getOWLNamedIndividual(IRI.create("AverageDieselPrice"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion5 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, dieselPriceIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion5));

			OWLObjectPropertyAssertionAxiom dollarAssertion3= factory.getOWLObjectPropertyAssertionAxiom(hasUnit, dieselPriceIndividual, dollarIndividual);
			manager.applyChange(new AddAxiom(ontology,dollarAssertion3));

			OWLDataProperty hasdieselPriceData = factory.getOWLDataProperty(":hasDiesalPrice.Value",pm);
			OWLAxiom hasdieselPriceAxiom = factory.getOWLDataPropertyAssertionAxiom(hasdieselPriceData, dieselPriceIndividual, averageDieselPrice);
			manager.applyChange(new AddAxiom(ontology, hasdieselPriceAxiom));


			//Time Index
			OWLNamedIndividual timeIndexIndividual = factory.getOWLNamedIndividual(IRI.create("CongestionTimeIndex"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion6 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, timeIndexIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion6));

			OWLObjectPropertyAssertionAxiom congestionToTimeAssertion= factory.getOWLObjectPropertyAssertionAxiom(hasUnit, timeIndexIndividual, congestionToTimeIndividual);
			manager.applyChange(new AddAxiom(ontology,congestionToTimeAssertion));

			OWLDataProperty hasTimeIndexData = factory.getOWLDataProperty(":hasTimeIndex",pm);
			OWLAxiom hasTimeIndexAxiom = factory.getOWLDataPropertyAssertionAxiom(hasTimeIndexData, timeIndexIndividual, averageTravelTimeIndex);
			manager.applyChange(new AddAxiom(ontology, hasTimeIndexAxiom));


			//Stress Value
			OWLNamedIndividual stressIndividual = factory.getOWLNamedIndividual(IRI.create("AverageComuterStress"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion7 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, stressIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion7));

			OWLObjectPropertyAssertionAxiom stressAssertion= factory.getOWLObjectPropertyAssertionAxiom(hasUnit, stressIndividual, peakToActualTravelIndividual);
			manager.applyChange(new AddAxiom(ontology,stressAssertion));

			OWLDataProperty hasStressData = factory.getOWLDataProperty(":hasCommuterStressIndex.Value",pm);
			OWLAxiom hasStressAxiom = factory.getOWLDataPropertyAssertionAxiom(hasStressData, stressIndividual, averageComuterStress);
			manager.applyChange(new AddAxiom(ontology, hasStressAxiom));


			//Value of Time
			OWLNamedIndividual valueIndividual = factory.getOWLNamedIndividual(IRI.create("ValueOfTime"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion8 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, valueIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion8));


			OWLObjectPropertyAssertionAxiom dollarAssertion4= factory.getOWLObjectPropertyAssertionAxiom(hasUnit, valueIndividual, dollarIndividual);
			manager.applyChange(new AddAxiom(ontology,dollarAssertion4));

			OWLDataProperty hasValueOfTimeData = factory.getOWLDataProperty(":hasValueOfTime.Value",pm);
			OWLAxiom hasValueOfTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasValueOfTimeData, valueIndividual, averageValueTime);
			manager.applyChange(new AddAxiom(ontology, hasValueOfTimeAxiom));



			try{
				//The next file to be parsed
				//Follows the same pattern as before
				String [] items = null;
				String csvFile2 = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/TxDOT ADT Volume.csv";
				String currentLine2 = "";
				BufferedReader reader2 = new BufferedReader(new FileReader(csvFile2));
				List<String []> dataList2 = new ArrayList<String []>();
				while((currentLine2 = reader2.readLine())!=null){

					items = currentLine2.split(",");
					dataList2.add(items);

				}
				reader2.close();
				List<ADTObject> ADTList = new ArrayList<ADTObject>();

				for(int i=1;i<dataList2.size();i++){
					ADTObject currentADT = new ADTObject();
					//System.out.println(dataList.get(i)[0]);
					currentADT.primaryStreet = dataList2.get(i)[0];
					currentADT.intersectionStreet = dataList2.get(i)[1];
					currentADT.locationFromIntersection = dataList2.get(i)[2];
					currentADT.volume = Integer.parseInt(dataList2.get(i)[3]);
					ADTList.add(currentADT);
				}

				//For every item on the list an individual will be made
				for(int i=0;i<ADTList.size();i++){

					//Named individual
					OWLNamedIndividual trafficVolumeIndividual = factory.getOWLNamedIndividual(IRI.create("ADT_"+i));
					OWLClassAssertionAxiom trafficVolumeClassAssertion = factory.getOWLClassAssertionAxiom(TrafficVolumeClass, trafficVolumeIndividual);
					manager.applyChange(new AddAxiom(ontology,trafficVolumeClassAssertion));

					//Data properties
					OWLAxiom hasPrimaryStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasTrafficVolumePrimaryStreet, trafficVolumeIndividual, ADTList.get(i).primaryStreet);
					manager.applyChange(new AddAxiom(ontology, hasPrimaryStreetAxiom));

					OWLAxiom hasTrafficIntersectionAxiom = factory.getOWLDataPropertyAssertionAxiom(hasTrafficVolumeIntersectionStreet, trafficVolumeIndividual, ADTList.get(i).intersectionStreet);
					manager.applyChange(new AddAxiom(ontology, hasTrafficIntersectionAxiom));

					OWLAxiom hasVolumeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasTrafficVolumeValue, trafficVolumeIndividual, ADTList.get(i).volume);
					manager.applyChange(new AddAxiom(ontology, hasVolumeAxiom));

				}

			}catch(IOException e){
				System.out.println("Error at ADT");
			}



			try{
				//Weather file to be parsed
				String [] items = null;
				String weatherFile = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/WeatherData2014-2016 PreProcessed.csv";
				String mycurrentLine = "";
				BufferedReader input = new BufferedReader(new FileReader(weatherFile));
				List<String []> weatherData = new ArrayList<String []>();
				while((mycurrentLine = input.readLine())!=null){
					items = mycurrentLine.split(",");
					weatherData.add(items);

				}
				input.close();
				List<WeatherObject> WeatherList = new ArrayList<WeatherObject>();

				for(int k=1;k<weatherData.size();k++){
					//Adds all of the weather to a weather object, then the object is added to a list
					WeatherObject currentWeather = new WeatherObject();
					currentWeather.location = weatherData.get(k)[0];
					currentWeather.date = parseWeatherDate(weatherData.get(k)[1]);
					currentWeather.precipitation = weatherData.get(k)[2];
					currentWeather.snow = weatherData.get(k)[3];
					currentWeather.averageTemp = weatherData.get(k)[4];
					currentWeather.maxTemp = weatherData.get(k)[5];
					currentWeather.minTemp = weatherData.get(k)[6];
					currentWeather.averageWindSpeed = weatherData.get(k)[7];
					currentWeather.fastWindTwoSec =  weatherData.get(k)[8];
					currentWeather.fastWindFiveSec =  weatherData.get(k)[9];
					boolean dust = false;
					if(Integer.parseInt(weatherData.get(k)[10])==1){
						dust = true;
					}
					currentWeather.dust = dust;
					WeatherList.add(currentWeather);

				}
				//For every item in the weather list (each weather object), it is populated into the ontology
				for(int k=0;k<WeatherList.size();k++){
					String weatherLocation = WeatherList.get(k).location;
					String weatherDate = WeatherList.get(k).date;
					//All individuals will have a data asserted as a data property for SPARQL queries in the triple store
					//Each will also have an item id (day of the year)
					OWLLiteral dateLiteral = factory.getOWLTypedLiteral(weatherDate, OWL2Datatype.XSD_DATE_TIME);

					//Each of the individuals (precipitaiton, snow, wind, etc.) have the same structure with their respective object/data properties

					int itemID = (k+1);
					//Precipitation
					double precipitation = Double.parseDouble(WeatherList.get(k).precipitation);
					String precipName = "precipitation_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual precipitationIndividual = factory.getOWLNamedIndividual(IRI.create(precipName));
					OWLClassAssertionAxiom precipitationAssertion = factory.getOWLClassAssertionAxiom(PrecipitationMeasurementClass, precipitationIndividual);
					manager.applyChange(new AddAxiom(ontology,precipitationAssertion));

					OWLAxiom hasPrecipitationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherPrecipitation, precipitationIndividual, precipitation);
					manager.applyChange(new AddAxiom(ontology, hasPrecipitationAxiom));

					OWLObjectPropertyAssertionAxiom inchAssertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, precipitationIndividual, inchesIndividual);
					manager.applyChange(new AddAxiom(ontology,inchAssertion));

					OWLDataPropertyAssertionAxiom hasDateAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, precipitationIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom));

					OWLAxiom hasPrecipitationLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation, precipitationIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasPrecipitationLocationAxiom));


					//Snow
					double snow = Double.parseDouble(WeatherList.get(k).snow);
					String snowName = "snow_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual snowIndividual = factory.getOWLNamedIndividual(IRI.create(snowName));
					OWLClassAssertionAxiom snowAssertion = factory.getOWLClassAssertionAxiom(SnowMeasurementClass, snowIndividual);
					manager.applyChange(new AddAxiom(ontology,snowAssertion));

					OWLAxiom hasSnowAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherSnow, snowIndividual, snow);
					manager.applyChange(new AddAxiom(ontology, hasSnowAxiom));

					OWLObjectPropertyAssertionAxiom inchAssertion2 = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, snowIndividual, inchesIndividual);
					manager.applyChange(new AddAxiom(ontology,inchAssertion2));

					OWLDataPropertyAssertionAxiom hasDateAxiom2 = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, snowIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom2));

					OWLAxiom hasSnowLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation, snowIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasSnowLocationAxiom));




					//Temperature
					//Average Temp
					double averageTemp = Double.parseDouble(WeatherList.get(k).averageTemp);
					String averageTempName = "averageTemp_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual avgTempIndividual = factory.getOWLNamedIndividual(IRI.create(averageTempName));
					OWLClassAssertionAxiom avgTempAssertion = factory.getOWLClassAssertionAxiom(AverageTemperatureClass, avgTempIndividual);
					manager.applyChange(new AddAxiom(ontology,avgTempAssertion));

					OWLAxiom hasAvgTempAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherAverageTemp, avgTempIndividual, averageTemp);
					manager.applyChange(new AddAxiom(ontology, hasAvgTempAxiom));

					OWLObjectPropertyAssertionAxiom fahrenheitAssertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, avgTempIndividual, fahrenheitIndividual);
					manager.applyChange(new AddAxiom(ontology,fahrenheitAssertion));

					OWLDataPropertyAssertionAxiom hasDateAxiom3 = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, avgTempIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom3));

					OWLAxiom hasAvgTempLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation, avgTempIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasAvgTempLocationAxiom));

					//Max Temp
					double maxTemp = Double.parseDouble(WeatherList.get(k).maxTemp);
					String maxTempName = "maximumTemp_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual maxTempIndividual = factory.getOWLNamedIndividual(IRI.create(maxTempName));
					OWLClassAssertionAxiom maxTempAssertion = factory.getOWLClassAssertionAxiom(MaximumTemperatureClass, maxTempIndividual);
					manager.applyChange(new AddAxiom(ontology,maxTempAssertion));

					OWLAxiom hasMaxTempAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherMaxTemp, maxTempIndividual, maxTemp);
					manager.applyChange(new AddAxiom(ontology, hasMaxTempAxiom));

					OWLObjectPropertyAssertionAxiom fahrenheitAssertion2 = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, maxTempIndividual, fahrenheitIndividual);
					manager.applyChange(new AddAxiom(ontology,fahrenheitAssertion2));

					OWLDataPropertyAssertionAxiom hasDateAxiom4 = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, maxTempIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom4));

					OWLAxiom hasMaxTempLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation, maxTempIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasMaxTempLocationAxiom));

					//MinTemp
					double minTemp =  Double.parseDouble(WeatherList.get(k).minTemp);
					String minTempName = "minimumTemp_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual minTempIndividual = factory.getOWLNamedIndividual(IRI.create(minTempName));
					OWLClassAssertionAxiom minTempAssertion = factory.getOWLClassAssertionAxiom(MinimumTemperatureClass, minTempIndividual);
					manager.applyChange(new AddAxiom(ontology,minTempAssertion));

					OWLAxiom hasMinTempAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherMinTemp, minTempIndividual, minTemp);
					manager.applyChange(new AddAxiom(ontology, hasMinTempAxiom));

					OWLObjectPropertyAssertionAxiom fahrenheitAssertion3 = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, minTempIndividual, fahrenheitIndividual);
					manager.applyChange(new AddAxiom(ontology,fahrenheitAssertion3));

					OWLDataPropertyAssertionAxiom hasDateAxiom5 = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, minTempIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom5));

					OWLAxiom hasMinTempLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation, minTempIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasMinTempLocationAxiom));


					//Wind
					//Average Wind Speed
					double avgWindSpeed = Double.parseDouble(WeatherList.get(k).averageWindSpeed);
					String avgWindName = "AverageWindSpeed_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual avgWindIndividual = factory.getOWLNamedIndividual(IRI.create(avgWindName));
					OWLClassAssertionAxiom avgWindAssertion = factory.getOWLClassAssertionAxiom(AverageWindClass, avgWindIndividual);
					manager.applyChange(new AddAxiom(ontology,avgWindAssertion));

					OWLAxiom hasavgWindAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherAverageWindSpeed, avgWindIndividual, avgWindSpeed);
					manager.applyChange(new AddAxiom(ontology, hasavgWindAxiom));

					OWLObjectPropertyAssertionAxiom MPHAssertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, avgWindIndividual, MPHIndividual);
					manager.applyChange(new AddAxiom(ontology,MPHAssertion));

					OWLDataPropertyAssertionAxiom hasDateAxiom6 = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, avgWindIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom6));

					OWLAxiom hasavgWindLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation,  avgWindIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasavgWindLocationAxiom));


					//Fastest Wind Over Two Seconds
					double fastWindTwoSec = Double.parseDouble(WeatherList.get(k).fastWindTwoSec);
					String fastWindTwoSecName = "FastestWindOverTwoSeconds_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual fastWindTwoSecIndividual = factory.getOWLNamedIndividual(IRI.create(fastWindTwoSecName));
					OWLClassAssertionAxiom fastWindTwoSecAssertion = factory.getOWLClassAssertionAxiom(FastestTwoSecondWindClass, fastWindTwoSecIndividual);
					manager.applyChange(new AddAxiom(ontology,fastWindTwoSecAssertion));

					OWLAxiom hasfastWindTwoSecAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherFastTwoSecondWind, fastWindTwoSecIndividual, fastWindTwoSec);
					manager.applyChange(new AddAxiom(ontology, hasfastWindTwoSecAxiom));

					OWLObjectPropertyAssertionAxiom MPHAssertion2 = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, fastWindTwoSecIndividual, MPHIndividual);
					manager.applyChange(new AddAxiom(ontology,MPHAssertion2));

					OWLDataPropertyAssertionAxiom hasDateAxiom7 = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, fastWindTwoSecIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom7));

					OWLAxiom hasfastWindTwoSecLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation,  fastWindTwoSecIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasfastWindTwoSecLocationAxiom));


					//Fastest wind over five seconds
					double fastWindFiveSec = Double.parseDouble(WeatherList.get(k).fastWindFiveSec);
					String fastWindFiveSecName = "FastestWindOverFiveSeconds_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual fastWindFiveSecIndividual = factory.getOWLNamedIndividual(IRI.create(fastWindFiveSecName));
					OWLClassAssertionAxiom fastWindFiveSecAssertion = factory.getOWLClassAssertionAxiom(FastestFiveSecondWindClass, fastWindFiveSecIndividual);
					manager.applyChange(new AddAxiom(ontology,fastWindFiveSecAssertion));

					OWLAxiom hasfastWindFiveSecAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherFastFiveSecondWind, fastWindFiveSecIndividual, fastWindFiveSec);
					manager.applyChange(new AddAxiom(ontology, hasfastWindFiveSecAxiom));

					OWLObjectPropertyAssertionAxiom MPHAssertion3 = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, fastWindFiveSecIndividual, MPHIndividual);
					manager.applyChange(new AddAxiom(ontology,MPHAssertion3));

					OWLDataPropertyAssertionAxiom hasDateAxiom8 = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, fastWindFiveSecIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom8));

					OWLAxiom hasfastWindFiveSecLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation,  fastWindFiveSecIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasfastWindFiveSecLocationAxiom));

					//Dust
					boolean dustValue = WeatherList.get(k).dust;
					String dustName = "Dust_"+weatherDate.split("T")[0]+"___"+itemID;
					OWLNamedIndividual dustIndividual = factory.getOWLNamedIndividual(IRI.create(dustName));
					OWLClassAssertionAxiom dustAssertion = factory.getOWLClassAssertionAxiom(DustClass, dustIndividual);
					manager.applyChange(new AddAxiom(ontology,dustAssertion));

					OWLAxiom hasDustAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDust, dustIndividual, dustValue);
					manager.applyChange(new AddAxiom(ontology, hasDustAxiom));

					OWLDataPropertyAssertionAxiom hasDateAxiom9 = factory.getOWLDataPropertyAssertionAxiom(hasWeatherDate, dustIndividual, dateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom9));

					OWLAxiom hasDustLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherLocation,  dustIndividual, weatherLocation);
					manager.applyChange(new AddAxiom(ontology, hasDustLocationAxiom));


				}

			}catch(IOException e){
				System.out.println("Weather Error");
			}

			//PDF Parsing
			/* PDF Parsing */
			/** The original PDF that will be parsed. */
			String PDFFileName = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/Fiscal Year 2014 Financial Report (toll revenue).pdf";
			ParsePDF pdfParser = new ParsePDF();
			pdfParser.parsePdf(PDFFileName);
			/* PDF parsing complete */
			//			/* PDF data insertion as individual start */


			//The individual will be created and have the parsed information as an assertion
			OWLNamedIndividual tollRevenueIndividual = factory.getOWLNamedIndividual(IRI.create("TollRevenue"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion9 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, tollRevenueIndividual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion9));

			OWLObjectPropertyAssertionAxiom tollRevenueAssertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, tollRevenueIndividual, dollarIndividual);
			manager.applyChange(new AddAxiom(ontology,tollRevenueAssertion));

			OWLDataProperty hastollRevenueData = factory.getOWLDataProperty(":hasTollRevenue.Value",pm);
			OWLAxiom hastollRevenueAxiom = factory.getOWLDataPropertyAssertionAxiom(hastollRevenueData, tollRevenueIndividual, pdfParser.tollrevenue);
			manager.applyChange(new AddAxiom(ontology, hastollRevenueAxiom));


			/* PDF data insertion as individual end */

			/* Parsing Avg. Crossing time data from website */
			// Ysleta Bridge, El Paso, TX : ZAR
			String urlYsletaBridge = "http://bcis.tamu.edu/request2.aspx?call=getMonthlyPerformanceIndicators&bridgeID@varchar=ZAR&timeFrom@varchar=01/01/2014%2000:00&timeTo@varchar=12/31/2014%2000:00"; 
			ParseWebsite websiteParserYsletaBridge = new ParseWebsite();
			websiteParserYsletaBridge.getHTML(urlYsletaBridge);
			String[] tempCrossDates = websiteParserYsletaBridge.portOfEntryDates;
			int[] tempCrossWait = websiteParserYsletaBridge.portOfEntryWait;

			// Bridge of America's : BOTA
			String urlBridgeOfAmerica = "http://bcis.tamu.edu/request2.aspx?call=getMonthlyPerformanceIndicators&bridgeID@varchar=BOTA&timeFrom@varchar=01/01/2014%2000:00&timeTo@varchar=12/31/2014%2000:00"; 
			ParseWebsite websiteParserBOA = new ParseWebsite();
			websiteParserBOA.getHTML(urlBridgeOfAmerica);
			String[] americastempCrossDates = websiteParserBOA.portOfEntryDates;
			int[] americastempCrossWait = websiteParserBOA.portOfEntryWait;

			//Each date (monthly) are used for each of the bridges.  It is assumed that all of the bridge will have the same number
			//of months based on the information that is provided on the website
			for(int k=0;k<tempCrossDates.length;k++){
				//Ysleta Bridge
				OWLNamedIndividual ysletabridgeCrossIndividual = factory.getOWLNamedIndividual(IRI.create("ysletaBridgeCrossIndividual_"+(k+1)));
				OWLClassAssertionAxiom ysletaPortOfEntryClassAssertion = factory.getOWLClassAssertionAxiom(PortOfEntryClass, ysletabridgeCrossIndividual);
				manager.applyChange(new AddAxiom(ontology,ysletaPortOfEntryClassAssertion));

				String tempDateString = tempCrossDates[k];
				OWLLiteral crossingDateLiteral = factory.getOWLTypedLiteral(tempDateString, OWL2Datatype.XSD_DATE_TIME);

				OWLAxiom hasysletaDateAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOEMonth, ysletabridgeCrossIndividual, crossingDateLiteral);
				manager.applyChange(new AddAxiom(ontology, hasysletaDateAxiom));

				String ysletaLocation = "Ysleta Port of Entry";
				OWLAxiom hasysletaLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOELocation, ysletabridgeCrossIndividual, ysletaLocation);
				manager.applyChange(new AddAxiom(ontology, hasysletaLocationAxiom));

				OWLAxiom ysletacrossingTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOEMinutes, ysletabridgeCrossIndividual, tempCrossWait[k]);
				manager.applyChange(new AddAxiom(ontology, ysletacrossingTimeAxiom));

				OWLObjectPropertyAssertionAxiom minuteAssertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, ysletabridgeCrossIndividual, minuteIndividual);
				manager.applyChange(new AddAxiom(ontology,minuteAssertion));




				//Americas Bridge
				OWLNamedIndividual americasbridgeCrossIndividual = factory.getOWLNamedIndividual(IRI.create("americasBridgeCrossIndividual_"+(k+1)));
				OWLClassAssertionAxiom americasPortOfEntryClassAssertion = factory.getOWLClassAssertionAxiom(PortOfEntryClass, americasbridgeCrossIndividual);
				manager.applyChange(new AddAxiom(ontology,americasPortOfEntryClassAssertion));

				String tempamericasDateString = americastempCrossDates[k];
				OWLLiteral americascrossingDateLiteral = factory.getOWLTypedLiteral(tempamericasDateString, OWL2Datatype.XSD_DATE_TIME);

				OWLAxiom hasamericasDateAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOEMonth, americasbridgeCrossIndividual, americascrossingDateLiteral);
				manager.applyChange(new AddAxiom(ontology, hasamericasDateAxiom));

				String americasLocation = "Americas Port of Entry";
				OWLAxiom hasamericasLocationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOELocation, americasbridgeCrossIndividual, americasLocation);
				manager.applyChange(new AddAxiom(ontology, hasamericasLocationAxiom));

				OWLAxiom americascrossingTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOEMinutes, americasbridgeCrossIndividual, americastempCrossWait[k]);
				manager.applyChange(new AddAxiom(ontology, americascrossingTimeAxiom));

				OWLObjectPropertyAssertionAxiom minuteAssertion2 = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, americasbridgeCrossIndividual, minuteIndividual);
				manager.applyChange(new AddAxiom(ontology,minuteAssertion2));
			}


			//Standard conversions as described by Department of Civil Engineering (Freight Experts)
			double convertionUNIT = 0.008887;
			double gasolineAmount = 9360000;
			double co2EmissionValue = (convertionUNIT*gasolineAmount);

			//Individuals created to describe environment quality
			OWLNamedIndividual CO2Individual = factory.getOWLNamedIndividual(IRI.create("CO2Emission"));
			OWLClassAssertionAxiom TrafficMeasurementsClassAssertion10 = factory.getOWLClassAssertionAxiom(TrafficMeasurementsClass, CO2Individual);
			manager.applyChange(new AddAxiom(ontology,TrafficMeasurementsClassAssertion10));

			OWLObjectPropertyAssertionAxiom CO2Assertion = factory.getOWLObjectPropertyAssertionAxiom(hasUnit, CO2Individual, tonsIndividual);
			manager.applyChange(new AddAxiom(ontology,CO2Assertion));

			OWLDataProperty hasCO2Data = factory.getOWLDataProperty(":hasCO2Emission.Equivalent",pm);
			OWLAxiom hasCO2Axiom = factory.getOWLDataPropertyAssertionAxiom(hasCO2Data, CO2Individual, co2EmissionValue);
			manager.applyChange(new AddAxiom(ontology, hasCO2Axiom));


		}catch(Exception e){ e.printStackTrace();}


		/* Important for testing and debugging of namespaces
		 * for (OWLClass cls : ontology.getClassesInSignature()) {

			System.out.println(cls);
		}
		 */

		//Creates a new IRI based on the ontology that has been built
		//Creates a new file to be used in Protege or other Ontology editor


		//Shows the ontology that was developed and its IRI
		

		Reasoner hermit = new Reasoner(ontology);
		System.out.println("Ontology consistency (HermiT): " + hermit.isConsistent());
		long startTime = System.currentTimeMillis();
		hermit.precomputeInferences(
				InferenceType.CLASS_ASSERTIONS,
				InferenceType.CLASS_HIERARCHY,


				InferenceType.OBJECT_PROPERTY_ASSERTIONS,
				InferenceType.OBJECT_PROPERTY_HIERARCHY,

				InferenceType.DATA_PROPERTY_ASSERTIONS,
				InferenceType.DATA_PROPERTY_HIERARCHY
				);
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime)/1000;
		System.out.println(totalTime);

		IRI documentIRI = manager.getOntologyDocumentIRI(ontology);
		File outFile = new File(ontFile);
		try {
			outFile.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(outFile);
			manager.saveOntology(ontology, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (OWLOntologyStorageException e) {
			e.printStackTrace();
		}
		System.out.println("Loaded ontology: " + ontology);
		System.out.println("    from: " + documentIRI);
		System.out.println("Done");


	}

	//Method to formatDateStrings to a standard xsd:dateTime format
	public static String formatDateString(String date, String time){
		String month = date.split("-")[1];
		String day = date.split("-")[2];
		String year = date.split("-")[0];

		String[] myTime = time.split(" ");
		String hour = myTime[0].split(":")[0];
		int tempHour = Integer.parseInt(hour);
		String minutes = myTime[0].split(":")[1];
		if(myTime[1].equals("PM")){
			if(tempHour<12){
				tempHour+=12;
			}
			hour = Integer.toString(tempHour);
		}

		String dateString = year+"-"+month+"-"+day+"T"+hour+":"+minutes+":00-07:00";;
		return dateString ;
	}
	//Method to formatNotifyStrings to a standard xsd:dateTime format
	public static String formatNotifyString(String date, String notify){
		String month = date.split("-")[1];
		String day = date.split("-")[2];
		String year = date.split("-")[0];
		String[] myNotify = notify.split(" ");
		String nhour = myNotify[0].split(":")[0];

		int tempnhour = Integer.parseInt(nhour);
		String nminutes = myNotify[0].split(":")[1];
		if(myNotify[1].equals("PM")){
			if(tempnhour<12){
				tempnhour+=12;
			}
			nhour = Integer.toString(tempnhour);
		}
		String notifyString = year+"-"+month+"-"+day+"T"+nhour+":"+nminutes+":00-07:00";
		return notifyString;

	}

	//Method to formatArriveString to a standard xsd:dateTime format
	public static String formatArriveString(String date, String arrive){
		String month = date.split("-")[1];
		String day = date.split("-")[2];
		String year = date.split("-")[0];
		String[] myArrive = arrive.split(" ");
		String ahour = myArrive[0].split(":")[0];
		int tempahour = Integer.parseInt(ahour);
		String aminutes = myArrive[0].split(":")[1];
		if(myArrive[1].equals("PM")){
			if(tempahour<12){
				tempahour+=12;
			}
			ahour = Integer.toString(tempahour);
		}
		String arriveString = year+"-"+month+"-"+day+"T"+ahour+":"+aminutes+":00-07:00";
		return arriveString;
	}

	//Method to parse the weather date and create a standard xsd:dateTime format
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