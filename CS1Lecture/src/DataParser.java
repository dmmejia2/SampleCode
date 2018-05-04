import java.io.BufferedReader;
import java.io.FileReader;

public class DataParser {

	public static void main(String[] args) {
		try {
			String csvFile = "//Users//danielmejia//Documents//workspace//PhD//src//2013-2017Incidents.csv";
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			String currentLine;
			String [] items = null;
			while((currentLine = reader.readLine())!=null){
				//System.out.println(currentLine);

				//System.out.println(currentLine);
				items = currentLine.split(",");
				
				for(int i=0;i<items.length;i++) {
					System.out.println(items[i]);
				}
			}
			
			
			
			
		}catch(Exception e) {}

	}

}
