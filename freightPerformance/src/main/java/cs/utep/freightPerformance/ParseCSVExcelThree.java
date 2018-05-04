package cs.utep.freightPerformance;
import java.awt.ItemSelectable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseCSVExcelThree {

	public ParseCSVExcelThree() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){

		try{
			String [] items = null;
			String csvFile = "TxDOT ADT Volume.csv";
			String currentLine = "";
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			List<String []> dataList = new ArrayList<String []>();
			//FileInputStream file = new FileInputStream(new File("C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv 2014 incidents.csv"));
			while((currentLine = reader.readLine())!=null){

				items = currentLine.split(",");
				dataList.add(items);

			//System.out.println(currentLine);
			}
			
			List<ADTObject> ADTList = new ArrayList<ADTObject>();
			
			for(int i=1;i<dataList.size();i++){
				ADTObject currentADT = new ADTObject();
				//System.out.println(dataList.get(i)[0]);
				currentADT.primaryStreet = dataList.get(i)[0];
				currentADT.intersectionStreet = dataList.get(i)[1];
				currentADT.locationFromIntersection = dataList.get(i)[2];
				currentADT.volume = Integer.parseInt(dataList.get(i)[3]);
				ADTList.add(currentADT);
				
				
			}
			
			for(int i=0;i<ADTList.size();i++){
				System.out.println("Primary Street: "+ADTList.get(i).primaryStreet);
				System.out.println("Intersection: "+ADTList.get(i).intersectionStreet);
				System.out.println("Location: "+ADTList.get(i).locationFromIntersection);
				System.out.println("Volume: "+ADTList.get(i).volume);
				System.out.println("");
				
			}
			
		}catch(Exception e){}
	}

}
