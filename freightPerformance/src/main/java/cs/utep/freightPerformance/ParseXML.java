package cs.utep.freightPerformance;

import java.util.LinkedList;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXML {

	public ParseXML() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		String xmlURL = "C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv2014incidents-XML.xml";
		//String xmlURL = "https://www.dropbox.com/s/a3kguqopth5un9i/cmv%202014%20incidents.xlsx?dl=0";

		try {


			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlURL);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Row");

			System.out.println("----------------------------");
			LinkedList<Integer> indexList = new LinkedList<Integer>();
			//for (int i = 0; i < nList.getLength(); i++) {
			for (int i = 0; i < 200; i++) {
				Node nNode = nList.item(i);

				//System.out.println("Employee tag #" + (i+1) + "\n");
				int j=0;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//while(j<200){
					if(i==0){
						while(j<=172){
							//Crash ID
							if(eElement.getElementsByTagName("Data").item(j).getTextContent().equals("Crash_ID")){

								indexList.add(j);
								System.out.println("CrashID: "+j);
							}
							//Crash Date
							else if(eElement.getElementsByTagName("Data").item(j).getTextContent().equals("Crash_Date")){
								indexList.add(j);
								System.out.println("CrashDate: "+j);
							}
							//Fatal Incidents
							else if(eElement.getElementsByTagName("Data").item(j).getTextContent().equals("Death_Cnt")){
								indexList.add(j);
								System.out.println("DeathCount: "+j);

								//Column BT - Other Factor (Weather)
							}else if(eElement.getElementsByTagName("Data").item(j).getTextContent().equals("Othr_Factr_ID")){
								indexList.add(j);
								System.out.println("OTHER FACTOR: "+j);
								//Column AK - Weather
							}else if(eElement.getElementsByTagName("Data").item(j).getTextContent().equals("Wthr_Cond_ID")){
								indexList.add(j);
								System.out.println("WTHR "+j);

								//Time Notified
							}else if(eElement.getElementsByTagName("Data").item(j).getTextContent().equals("Investigat_Notify_Time")){
								indexList.add(j);
								System.out.println("Notify: "+j);
							}
							//Time Arrived
							else if(eElement.getElementsByTagName("Data").item(j).getTextContent().equals("Investigat_Arrv_Time")){
								indexList.add(j);
								System.out.println("Arrive: "+j);
							}
							j++;
						}
						for(int k=0;k<indexList.size();k++){
							System.out.println("K: "+indexList.get(k));
						}
					}
					//System.out.println("I: "+i);
					Element attribute = (Element) eElement.getElementsByTagName("Cell");
					System.out.println(eElement.getChildNodes().item(0).getNodeName());
					if(i!=0){

						try{

							int k=0;

							//System.out.println("HERE");
							while(k<172){
								//if(eElement.getTagName()!=""){

								//Element attribute = (Element) eElement.getElementsByTagName("Cell");
								//System.out.println((Element) eElement.getElementsByTagName("Cell"));
								//}
								k++;
								//if(eElement.getElementsByTagName("Data").item(j).getAttributes()=){}
							}

							/*
							System.out.println("CrashID: "+eElement.getElementsByTagName("Data").item(0).getTextContent());

							System.out.println("CrashDate: "+eElement.getElementsByTagName("Data").item(8).getTextContent());
							if(eElement.getElementsByTagName("Data").item(1).getTextContent().equals("Y")){
								System.out.println("Death Count: "+eElement.getElementsByTagName("Data").item(168).getTextContent());
							}
							System.out.println("OtherFact(Weather): "+eElement.getElementsByTagName("Data").item(71).getTextContent());

							System.out.println("WeatherCondID: "+eElement.getElementsByTagName("Data").item(47).getTextContent());

							System.out.println("Time Notify: "+eElement.getElementsByTagName("Data").item(54).getTextContent());

							System.out.println("Time Arrive: "+eElement.getElementsByTagName("Data").item(56).getTextContent());
							 */
						}catch(Exception e){}

					}

					//System.out.println("ID : " + eElement.getAttribute("id"));
					//System.out.println("First Name : " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
					//System.out.println("Last Name : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
					//System.out.println("Data Length: "+eElement.getElementsByTagName("Data").getLength());
					//j++;
					//}

				}
			}
			System.out.println("Number of Incidents: "+nList.getLength());

			nList = doc.getElementsByTagName("department");

			System.out.println("----------------------------");

			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);

				System.out.println("Department tag #" + (i+1) + "\n");

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("ID : " + eElement.getAttribute("id"));
					System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
