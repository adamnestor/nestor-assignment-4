package com.coderscampus;

public class Student implements Comparable<Student> {
	private String studentID;
	private String studentName;
	private String course;
	private String grade;

	public Student(String studentID, String studentName, String course, String grade) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.course = course;
		this.grade = grade;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	// this should compare and sort by grade unless the grades are the same in which
	// case they'll be sorted alphabetically
	@Override
	public int compareTo(Student that) {
		if (this.grade.compareTo(that.course) == 0) {
			return that.studentName.compareTo(this.studentName);
		} else {
			return that.grade.compareTo(this.grade);
		}

	}

	// BufferedWriter wants a String instead of Student type
	public String toCSVString() {
		return getStudentID() + "," + getStudentName() + "," + getCourse() + "," + getGrade();
	}
}
