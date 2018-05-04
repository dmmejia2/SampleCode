public class Student {
	private String name;
	private Course course;
	public Student(){
		
	};
	
	
	public static void main(String[] args){
		Student myStudent = new Student();
		
		myStudent.name = "Daniel";
		myStudent.course.setShoeName("Nike");
		//myStudent.course.myCourse[0] = "CS1";
		//myStudent.course.myCourse[1] = "Calculus";
		//myStudent.course.myCourse[2] = "History";
		
		System.out.println(myStudent.name);
		System.out.println((myStudent.course.getShoeName()));
		//for(int i=0;i<=myStudent.course.myCourse.length;i++){
			//System.out.println(myStudent.course.myCourse[i]);
		//}
		
	}

}
