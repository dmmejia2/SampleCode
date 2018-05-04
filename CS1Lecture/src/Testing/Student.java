package Testing;

public class Student {

	private String firstName;
	private String lastName;
	private int idNumber;
	private boolean isActiveStudent;
	private boolean isUndergraduate;
	private double totalTuition;
	private double currentGPA;
	//Let's say you are limited to only 4 courses
	private Course [] currentCourses = new Course[4];
	private int courseIndex = 0;



	public Student() {
	}


	public Student(String firstName, String lastName, int idNumber, boolean isActiveStudent, boolean isUndergraduate, double totalTuition, double currentGPA) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.isActiveStudent = isActiveStudent;
		this.isUndergraduate = isUndergraduate;
		this.totalTuition = totalTuition;
		this.currentGPA = currentGPA;
	}

	public void addCourse(Course myCourse) {
		if(courseIndex<currentCourses.length) {
			currentCourses[courseIndex] = myCourse;
			courseIndex++;
		}
	}

	//Getters
	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public int getIdNumber() {
		return idNumber;
	}


	public boolean isActiveStudent() {
		return isActiveStudent;
	}


	public boolean isUndergraduate() {
		return isUndergraduate;
	}


	public double getTotalTuition() {
		return totalTuition;
	}


	public double getCurrentGPA() {
		return currentGPA;
	}


	public Course[] getCurrentCourses() {
		return currentCourses;
	}


	//Setters

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}


	public void setActiveStudent(boolean isActiveStudent) {
		this.isActiveStudent = isActiveStudent;
	}


	public void setUndergraduate(boolean isUndergraduate) {
		this.isUndergraduate = isUndergraduate;
	}


	public void setTotalTuition(double totalTuition) {
		this.totalTuition = totalTuition;
	}


	public void setCurrentGPA(double currentGPA) {
		this.currentGPA = currentGPA;
	}


	public void setCurrentCourses(Course[] currentCourses) {
		this.currentCourses = currentCourses;
	}



	public static void main(String[] args) {

		//Is the following constructor correct? If not what would you do to make it correct?
		Student studentOne = new Student("Paydirt", "Pete", 12345678, "true", "true", 3643.79, 4.0);

		//Is the following constructor correct? If not what would you do to make it correct?
		Course courseOne = new Course("Intro to Computer Science", 1301, 3, 12345, "Villanueva");

		Course courseTwo = new Course();
		courseTwo.setCourseName("Elementary Data Structures");
		courseTwo.setCourseNumber(2302);
		courseTwo.setCourseCost(1100);

		Course courseFive = new Course();
		courseFive.setCourseName("Discrete Mathematics");
		courseFive.setCourseNumber(1304);
		courseFive.setCourseCost(1200.00);

		Course courseThree = new Course();
		courseThree.setCourseName("Pysics");
		courseThree.setCourseNumber(1305);
		courseThree.setCourseCost(1300);

		Course courseFour = new Course();
		courseFour.setCourseName("Jazz To Rock");
		courseFour.setCourseNumber(1306);
		courseFour.setCourseCost(1400.00);

		Course courseSix = new Course();
		courseSix.setCourseName("Biology");
		courseSix.setCourseNumber(1301);
		courseSix.setCourseCost(1500);


		Student studentTwo = new Student();
		studentTwo.setFirstName("Donald");
		studentTwo.addCourse(courseThree);
		studentTwo.setLastName("Duck");
		studentTwo.addCourse(courseTwo);
		studentTwo.setUndergraduate(true);
		studentTwo.addCourse(courseSix);
		studentTwo.setIdNumber(12345678);
		studentTwo.addCourse(courseFive);
		studentTwo.setCurrentGPA(3.87);
		studentTwo.addCourse(courseFour);


		//What are the outputs of the following?
		System.out.println(studentTwo.getFirstName()+" "+studentTwo.getLastName());
		for(int i=0;i<studentTwo.getCurrentCourses().length;i++) {
			System.out.println(studentTwo.getCurrentCourses()[i].getCourseName());
		}

		int averageOne = averageCourseCostTESTONE(studentTwo);
		double averageTwo = averageCourseCostTESTTWO(studentTwo);
		double averageThree = averageCourseCostTESTTHREE(studentTwo);

		//The expected output for each is: 1275.00
		//What is the actual output for each?
		//What errors, if any, would each give?
		//System.out.println(averageOne);
		System.out.println(averageTwo);
		System.out.println(averageThree);

		Student studentThree = new Student();
		studentThree.setFirstName("Mickey");
		studentThree.addCourse(courseThree);
		studentThree.setLastName("Mouse");
		studentThree.addCourse(courseFour);
		studentThree.setUndergraduate(true);
		studentThree.setIdNumber(12345678);
		studentThree.setCurrentGPA(3.87);





		//There is an error in the following piece of code. How would you
		//address it?
		//Assuming that the error is fixed, what would the output of the following be?
		//ERROR IS IN THIS PART------------------------------------------------------------

		System.out.println(studentThree.getFirstName()+" "+studentThree.getLastName());
		for(int i=0;i<studentThree.getCurrentCourses().length;i++) {
			System.out.println(studentThree.getCurrentCourses()[i].getCourseName());
		}
		//ERROR ENDS HERE-------------------------------------------------------------------

		int averageFour = averageCourseCostTESTONE(studentThree);
		double averageFive = averageCourseCostTESTTWO(studentThree);
		double averageSix = averageCourseCostTESTTHREE(studentThree);

		//The expected output for each is: 1350.00
		//What is the actual output for each?
		//What errors, if any, would each give?
		System.out.println(averageFour);
		System.out.println(averageFive);
		System.out.println(averageSix);


	}


	//Averages the total cost for the given student
	public static int averageCourseCostTESTONE(student myStudent) {
		for(int i=0;i<myStudent.getCurrentCourses().length;i++) {
			int totalCost += myStudent.getCurrentCourses()[i].getCourseCost();	
		}
		return totalCost;
	}

	public static double averageCourseCostTESTTWO(Student myStudent) {
		double blue = 0;
		for(int i=0;i<myStudent.getCurrentCourses().length;i++) {
			blue += myStudent.getCurrentCourses()[i].getCourseCost();	
		}
		blue = blue/4;
		return blue;	
	}

	public static double averageCourseCostTESTTHREE(Student myStudent) {
		double blue = 0;
		int red = 0;
		for(int i=0;i<myStudent.getCurrentCourses().length;i++) {
			if(myStudent.getCurrentCourses()[i]!=null) {
				blue += myStudent.getCurrentCourses()[i].getCourseCost();	
				red++;
			}
		}
		blue = blue/red;
		return blue;	
	}



}
