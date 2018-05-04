package Testing;

public class Course {

	private String courseName;
	private int courseNumber;
	private int courseCredits;
	private double courseCost;
	private int cRN;
	private String instructor;
	private int lengthInMinutes;
	private String courseLocation;
	private double courseRating;
	
	
	//Default constructor
	public Course() {

	}
	
	//Constructors
	public Course(String courseName, int courseNumber, int courseCredits, double courseCost, int cRN, String instructor, int lengthInMinutes, String courseLocation, double courseRating) {
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.courseCredits = courseCredits;
		this.courseCost = courseCost;
		this.cRN = cRN;
		this.instructor = instructor;
		this.lengthInMinutes = lengthInMinutes;
		this.courseLocation = courseLocation;
		this.courseRating = courseRating;
	}
	

	public Course(String courseName, int courseNumber, int courseCredits, int cRN, String instructor) {
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.courseCredits = courseCredits;
		this.cRN = cRN;
		this.instructor = instructor;
	}
	
	
	public void printCourseInfo() {
		System.out.println("The course name is: "+this.courseName);
		System.out.println("The course number is: "+this.courseNumber);
		System.out.println("The course instructor is: "+this.instructor);
	}
	
	
	
	public String getCourseName() {
		return courseName;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public int getCourseCredits() {
		return courseCredits;
	}

	public double getCourseCost() {
		return courseCost;
	}
	public int getcRN() {
		return cRN;
	}

	public String getInstructor() {
		return instructor;
	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public double getCourseRating() {
		return courseRating;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public void setCourseCredits(int courseCredits) {
		this.courseCredits = courseCredits;
	}
	
	public void setCourseCost(double courseCost) {
		this.courseCost = courseCost;
	}

	public void setcRN(int cRN) {
		this.cRN = cRN;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public void setLengthInMinutes(int lengthInMinutes) {
		this.lengthInMinutes = lengthInMinutes;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}

	public void setCourseRating(double courseRating) {
		this.courseRating = courseRating;
	}
	
}
