/**
 * Heading of your program
 * Important information goes here:
 */
public class ReviewWeek7 {
	public static void main(String[] args){
		/**
		 * The following are variables that are being declared.
		 * This means that our program is allocating a space in
		 * the computer memory to hold these variables.
		 */
		//Variable that will eventually contain the value of some string (e.g."Computer Science")
		String meaningfulStringName;

		//Variable that will eventually contain the value of some integer (e.g. 10042017)
		int meaningfulIntegerName;

		//Variable that will eventually contain the value of some double (e.g. 93.1)
		double meaningfulDoubleName;

		//Variable that will eventually contain the value of some boolean (e.g. False)
		boolean meaningfulBooleanName;
		/**
		 * The following are variables that are being initialized.
		 * This means that the program is allocating space in
		 * the computer memory and assigning it a value to the variable
		 * at the same time.
		 */
		//Variable that contains the string value given
		String initializedStringName = "Go Miners!";

		//Variable that contains the integer value given
		int initializedIntegerName = 100;

		//Variable that contains the double value given
		double initializedDoubleName = 25.34;

		//Variable that contains the boolean value given
		boolean initializedBooleanName = true;

		//Condition is a boolean expression (True/False)
		if(condition){
			//THEN executes this section, exits if statement

			//if first condition is not met, it will check this condition
			//if it is true then it will execute section 2
		}else if(condition){
			//Section 2

			//if none of the above conditions are met, it will execute section 3
		}else{
			//Section 3
		}

		//While condition is true
		while(condition){
			//Execute this code

			//At the end of the loop, go back and check the condition
			//if true then loop again, otherwise exit loop
		}

		//Some variable is initialized to a start value
		//Checks if the condition is true, if true enters the loop
		for(initialized value; condition; iterator){
			//Execute this code

			//At the end of the loop, returns to iterator
			//After the iterator, the condition is checked and if met
			//it goes back into the loop, otherwise it exits
		}
	}
}