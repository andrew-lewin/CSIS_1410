package a01;

public class Student {
	
	private String firstName;
	private String lastName;
	private int sNumber;
	private String major;
	private double gpa;
	private static int count;
	
	public Student(){
		this.sNumber = 1000000 + count++;
	}
	
	public Student(String fName, String lName, String maj, double gpa){
		this.firstName = fName;
		this.lastName = lName;
		this.sNumber = 1000000 + count++;
		this.major = maj;
		this.gpa = gpa;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSNumber() {
		return sNumber;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String toString(){
		return "S" + sNumber + " " + firstName + " " + lastName + " (" + major + ") GPA:" + gpa;
	}
	

}
