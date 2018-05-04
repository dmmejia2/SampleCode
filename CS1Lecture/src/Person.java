
public class Person {
	
	private String name = "";
	private String birthdate = "";
	private boolean isRightHanded;
	private String height = "";
	private int age = 0;
	private boolean isMale;
	
	public static void main(String[] args) {

	}

	//Default constructor
	public Person(){
		
	}
	
	
	public Person(String name, String birthdate, boolean isRightHanded, String age, int weight, boolean isMale) {
		this.name = name;
		this.birthdate = birthdate;
		this.isRightHanded = isRightHanded;
		this.height = age;
		this.age = weight;
		this.isMale = isMale;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public boolean isRightHanded() {
		return isRightHanded;
	}


	public void setRightHanded(boolean isRightHanded) {
		this.isRightHanded = isRightHanded;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public int getWeight() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isMale() {
		return isMale;
	}


	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}



	
	

}
