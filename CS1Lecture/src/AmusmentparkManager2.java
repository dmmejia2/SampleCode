import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class AmusmentparkManager2 {

	public static void main(String[] args){
		/**
		 * Part I - Simple Arrays
		 */
		System.out.println("===============Part I===============");
		String[][] characterLocations = new String[6][2];
		characterLocations[0][0] = "Mickey Mouse";
		characterLocations[1][0] = "Minnie Mouse";
		characterLocations[2][0] = "Goofy";
		characterLocations[3][0] = "Pluto";
		characterLocations[4][0] = "Belle";
		characterLocations[5][0] = "Jasmine";
		characterLocations[0][1] = "Main Street U.S.A";
		characterLocations[1][1]= "Toon Town";
		characterLocations[2][1] = "Frontier Land";
		characterLocations[3][1] = "Tomorrowland";
		characterLocations[4][1] = "Fantasyland";
		characterLocations[5][1] = "Adventureland";
		String myCharacter = "Belle";
		System.out.println(myCharacter+" location:"+findLocation(characterLocations,myCharacter));

		/**
		 * Part II - Array manipulation/Methods
		 
		System.out.println("===============Part II===============");
		int[] showCost = new int[7];
		for(int i=0;i<showCost.length;i++){
			showCost[i] = 75000;
		}
		System.out.println("Original Daily Costs");
		printShowCost(showCost);
		
		for(int i=1;i<showCost.length;i=i+2){
			showCost[i] = showCost[i]*2;
		}
		System.out.println("Multiple Shows Per Day Cost");
		printShowCost(showCost);
		
		System.out.println("Suplementary Show Days");
		for(int i=0; i<showCost.length;i=i+2){
			showCost[i] = showCost[i] + 63000;
		}
		
		for(int i=0;i<showCost.length;i++){
			showCost[i] = showCost[i]*52;
		}
		
		System.out.println("Total Show Cost by Day of the Week (Yearly)");
		printShowCost(showCost);
		
		int sum=0;
		for(int i=0;i<showCost.length;i++){		
			sum+=showCost[i];
		}
		int average = sum/365;
		System.out.println("The daily average for the entire year is: $"+average);

*/



		/**
		 * Part II - Read From Files
		 */
		System.out.println("===============Part II===============");
		String line;
		String[] menuItems = new String[12];
		int[] menuPrice = new int[12];
		try{
			BufferedReader menuItemReader = new BufferedReader(new FileReader("/Users/danielmejia/Documents/workspace/CS1Lecture/src/menuItems.txt"));
			BufferedReader menuPriceReader = new BufferedReader(new FileReader("/Users/danielmejia/Documents/workspace/CS1Lecture/src/menuPrices.txt"));

			//Read menu items
			int i=0;
			while((line=menuItemReader.readLine())!=null){
				menuItems[i] = line;
				i++;
			}

			//Read menu prices
			i=0;
			while((line=menuPriceReader.readLine())!=null){
				menuPrice[i] = Integer.parseInt(line);
				i++;
			}

			menuItemReader.close();
			menuPriceReader.close();
		}catch(IOException e){
			System.out.println(e);

		}

		//Print the menu items and their price
		for(int i=0;i<menuItems.length;i++){
			System.out.println(menuItems[i] +" - $"+menuPrice[i]);
		}


		/**
		 * Part III - User Input/Arrays
		 */
		System.out.println("===============Part III===============");
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to order something from the menu? Y/N");
		String answer = input.nextLine().toUpperCase();
		double totalPrice = 0;

		while(answer.equals("Y")){

			//Print all of the items on the menu
			System.out.println("What would you like to order?");
			for(int i=0;i<menuItems.length;i++){
				System.out.println("Enter "+(i+1)+" for: "+menuItems[i]);
			}
			int order = input.nextInt();
			System.out.println("You have ordered "+menuItems[order-1]+" for $"+menuPrice[order-1]);
			totalPrice+=menuPrice[order-1];
			System.out.println("Your current total is: "+totalPrice);
			System.out.println("Would you like to order another item? Y/N");
			answer = input.next().toUpperCase();
		}

		double amountDue = totalPrice;
		if(totalPrice>0 && answer.equals("N")){
			System.out.println("Do you have an annual pass? Y/N");
			answer = input.next().toUpperCase();
			if(answer.equals("Y")){
				//15% off
				amountDue *=.85; 
				System.out.println("The amount due is: "+amountDue);
			}else{
				System.out.println("The amount due is: " +amountDue);
			}
		}

		System.out.println("Thank You!");
		input.close();
		
		/**
		 * Part IV - Bonus
		 */
		System.out.println("===============Part IV===============");
		System.out.println("Oh Boy! You're Hungy pal! The total price is: $"+getMenuPrice(menuPrice,0));


	}

	private static String findLocation(String[][] characterLocations, String characterName) {
		int i=1;
		while(i<characterLocations.length-1){
			i++;
			if(characterLocations[i][0].equals(characterName)){
				return characterLocations[i][1];
			}
		}
		return "Character not in the park!";
		
	}

	public static double getMenuPrice(int[] menuPrice, int index){

		if(index==menuPrice.length){
			return 0;
		}else{
			return menuPrice[index]+ getMenuPrice(menuPrice,index+1);
		}
	}


}
