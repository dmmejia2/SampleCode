package cs.utep.freightPerformance;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import statements
public class ParseExcel 
{
	public static void main(String[] args) 
	{
		try
		{
			FileInputStream file = new FileInputStream(new File("C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv 2014 incidents.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			LinkedList<Object []> indexValues = new LinkedList<Object []>();
			int deathCount=0;
			int weatherIssues=0;
			double startTime=0.0;
			double endTime = 0.0;
			double totalTime = 0.0;
			int numberOfIncidents=0;
			while (rowIterator.hasNext()) 
			{
				numberOfIncidents++;
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				//Map<String,Integer> indexValues = new Map<>();
				//System.out.println("row: "+row.getRowNum());
				while (cellIterator.hasNext()) 
				{

					Cell cell = cellIterator.next();
					//System.out.println("CELL INDEX: "+cell.getColumnIndex());
					//Check the cell type and format accordingly
					if(row.getRowNum()==0){
						Object [] metaValue = new Object[2];

						switch (cell.getCellType()){
						case Cell.CELL_TYPE_NUMERIC:
							//System.out.println(cell.getNumericCellValue() + "t");
							break;
						case Cell.CELL_TYPE_STRING:
							/*
							if(cell.getStringCellValue().equals("Crash_ID")){
								//System.out.println(cell.getStringCellValue() + cell.getColumnIndex());
								metaValue[0] = "Crash_ID";
								metaValue[1] = cell.getColumnIndex();
								indexValues.add(metaValue);
							}else if(cell.getStringCellValue().equals("Crash_Date")){
								//System.out.println(cell.getStringCellValue() + cell.getColumnIndex());
								metaValue[0] = "Crash_Date";
								metaValue[1] = cell.getColumnIndex();
								indexValues.add(metaValue);
							}else 
							 */
							if(cell.getStringCellValue().equals("Death_Cnt")){
								//System.out.println(cell.getStringCellValue() + cell.getColumnIndex());
								metaValue[0] = "Death_Cnt";
								metaValue[1] = cell.getColumnIndex();
								indexValues.add(metaValue);
							}else if(cell.getStringCellValue().equals("Othr_Factr_ID")){
								//System.out.println(cell.getStringCellValue() + cell.getColumnIndex());
								metaValue[0] = "Othr_Factr_ID";
								metaValue[1] = cell.getColumnIndex();
								indexValues.add(metaValue);
							}else if(cell.getStringCellValue().equals("Wthr_Cond_ID")){
								//System.out.println(cell.getStringCellValue() + cell.getColumnIndex());
								metaValue[0] = "Wthr_Cond_ID";
								metaValue[1] = cell.getColumnIndex();
								indexValues.add(metaValue);
							}else if(cell.getStringCellValue().equals("Investigat_Notify_Time")){
								metaValue[0] = "Investigat_Notify_Time";
								metaValue[1] = cell.getColumnIndex();
								indexValues.add(metaValue);
							}else if(cell.getStringCellValue().equals("Investigat_Arrv_Time")){
								metaValue[0] = "Investigat_Arrv_Time";
								metaValue[1] = cell.getColumnIndex();
								indexValues.add(metaValue);
							}
							break;
						}
					}else if(row.getRowNum()>0){
						//System.out.println("ROW: "+cell.getColumnIndex());


						for(int i=0;i<indexValues.size();i++){
							switch (cell.getCellType()){
							case Cell.CELL_TYPE_NUMERIC:
								if(cell.getColumnIndex()==(Integer)indexValues.get(i)[1]){

									if(indexValues.get(i)[0].equals("Death_Cnt")){
										deathCount+=cell.getNumericCellValue();
									}else if(indexValues.get(i)[0].equals("Othr_Factr_ID")){
										if((int)cell.getNumericCellValue()==1){
											weatherIssues++;
										}
									}else if(indexValues.get(i)[0].equals("Wthr_Cond_ID")){
										int weatherCode = (int) cell.getNumericCellValue();
										if(weatherCode==2 ||weatherCode==3||weatherCode==4||weatherCode==6){
											weatherIssues++;
										}

									}else if(indexValues.get(i)[0].equals("Investigat_Notify_Time")){
										String time = cell.getDateCellValue().toString().split("Sun Dec 31 ")[1].split(" MST 1899")[0];
										String hour = time.split(":")[0];
										String minute = time.split(":")[1].split(":")[0];
										startTime = (Integer.parseInt(hour)*60)+Integer.parseInt(minute);


									}else if(indexValues.get(i)[0].equals("Investigat_Arrv_Time")){
										String time = cell.getDateCellValue().toString().split("Sun Dec 31 ")[1].split(" MST 1899")[0];
										String hour = time.split(":")[0];
										String minute = time.split(":")[1].split(":")[0];
										endTime = (Integer.parseInt(hour)*60)+Integer.parseInt(minute);
										totalTime += endTime-startTime;

									}
								}
								break;

							}

						}

					}
				}
				//System.out.println("");
			}
			
			
			System.out.println("Number of Incidents: "+numberOfIncidents);
			System.out.println("Number of Fatal Incidents: "+deathCount);
			System.out.println("Number of Weather Incidents: "+weatherIssues);
			System.out.println("Average number of minutes waiting: "+totalTime/numberOfIncidents);
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}