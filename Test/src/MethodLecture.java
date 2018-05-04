
public class MethodLecture {
	public static void main(String[] args){
		
		System.out.println(addNumbers(1,2));
		getCurrentGradeLetter(48);
		
		
		
		int[] grades = new int[5];
		grades[0] = 90;
		grades[1] = 100;
		grades[2] = 95;
		grades[3] = 100;
		grades[4] = 80;
		System.out.println(addArray(grades));
	
		System.out.println(findMax(20,20));
		
	}
	
	public static int findMax(int a, int b){
		if(a>b){
			return a;
		}else if(b>a){
			return b;
		}else{
			return -1;
		}
		
	}
	
	public static int addArray(int[] myArray){
		int sum = 0;
		for(int i=0;i<myArray.length;i++){
			sum+=myArray[i];
		}
		return sum;
	}
	
	
	public static int addNumbers(int a, int b){
		return a+b;
	}
	
	
	public static boolean isAliceEnergetic(int energyLevel){
		if(energyLevel>6){
			return true;
		}else{
			return false;
		}
	}
	
	public static void getCurrentGradeLetter(double grade){
		if(grade>=90){
			System.out.println("I Have an A so far");
		}
		else if(grade>=80){
			System.out.println("I have a B so far");
		}
		else if(grade>=70){
			System.out.println("I have a C so far");
		}
		else if(grade>=60){
			System.out.println("I have a D so far");
		}else{
			System.out.println("I have an F so far");
		}
	}
	
}
