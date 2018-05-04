package cs.utep.freightPerformance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseCSVExcelTwoTTI {

	public ParseCSVExcelTwoTTI() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){

		try{
			String csvFile = "C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\TTI UMR complete-dataELP.csv";
			String currentLine = "";
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			List<String []> dataList = new ArrayList<String []>();
			//FileInputStream file = new FileInputStream(new File("C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv 2014 incidents.csv"));
			while((currentLine = reader.readLine())!=null){

				String [] items = currentLine.split(",");

				if(items[0].equals("El Paso TX-NM")&&items[0]!=""){
					//System.out.println(currentLine);
					dataList.add(items);
				}
			}
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
			
			
			for(int i=0;i<dataList.size();i++){


				//Average Peak Hour Delay (Column V - 21)
				if(!dataList.get(i)[21].equals("")){
					hourDelay += Double.parseDouble(dataList.get(i)[21]);
					hourDelayCount++;
					
				}
				

				//Congestion Cost (Column AD - 29)
				if(!dataList.get(i)[29].equals("")){
					congestionCost += Double.parseDouble(dataList.get(i)[29]);
					congestionCostCount++;
					
				}

				//Congestion Time (Column O - 14)
				if(!dataList.get(i)[14].equals("")){
					congestionTime += Double.parseDouble(dataList.get(i)[14]);
					congestionTimeCount++;
				
				}
				
				
				//Percent of system congested (Column N - 13)
				if(!dataList.get(i)[13].equals("")){
					percentSystem += Double.parseDouble(dataList.get(i)[13]);
					percentSystemCount++;
					
					
				}

				//Percent of Travel Congested (Column M - 12)
				if(!dataList.get(i)[12].equals("")){
					percentTravel += Double.parseDouble(dataList.get(i)[12]);
					percentTravelCount++;				
					
				}


				//Gasoline Price (Column K - 10)
				if(!dataList.get(i)[10].equals("")){
					gasPrice += Double.parseDouble(dataList.get(i)[10]);
					gasPriceCount++;
					
				}

				//Diesel Price (Column L - 11)
				if(!dataList.get(i)[11].equals("")){
					dieselPrice += Double.parseDouble(dataList.get(i)[11]);
					dieselPriceCount++;
				}

				//Travel Time Index (Column X - 23)
				if(!dataList.get(i)[23].equals("")){
					travelTimeIndex += Double.parseDouble(dataList.get(i)[23]);
					travelTimeIndexCount++;
					
				}

				//Commuter Stress Index (Column Z - 25) 
				if(!dataList.get(i)[25].equals("")){
					comuterStress += Double.parseDouble(dataList.get(i)[25]);
					comuterStressCount++;
					
				}

				//Value of Time (Column I - 9)
				if(!dataList.get(i)[9].equals("")){
					valueTime += Double.parseDouble(dataList.get(i)[9]);
					valueTimeCount++;
					
				}
			}

			double averageDelay = hourDelay/hourDelayCount;
			double averageCongestionCost = congestionCost/congestionCostCount;
			double averageCongestionTime = congestionTime/congestionTimeCount;
			double averagePercentSystem = percentSystem/percentSystemCount;
			double averageGasPrice = gasPrice/gasPriceCount;
			double averageDieselPrice = dieselPrice/dieselPriceCount;
			double averageTravelTimeIndex = travelTimeIndex/travelTimeIndexCount;
			double averageComuterStress = comuterStress/comuterStressCount;
			double averageValueTime = valueTime/valueTimeCount;
			
			System.out.println("delay: "+averageDelay);
			System.out.println("congestion: "+averageCongestionCost);
			System.out.println("cong Time: "+averageCongestionTime);
			System.out.println("perSyst: "+averagePercentSystem);
			System.out.println("avg gas: "+averageGasPrice);
			System.out.println("avg diesel: "+averageDieselPrice);
			System.out.println("avg TTI: "+averageTravelTimeIndex);
			System.out.println("avg comuterStress: "+averageComuterStress);
			System.out.println("avg ValTime: "+averageValueTime);
			
		}catch(Exception e){}






	}
}






