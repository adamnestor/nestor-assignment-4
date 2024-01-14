package com.coderscampus;

import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		FileService fileService = new FileService();
		Student[] students;
		students = fileService.getStudentsFromFile();
		Arrays.sort(students);

		try (BufferedWriter writerCourse1 = new BufferedWriter(new FileWriter("course1.csv"));
				BufferedWriter writerCourse2 = new BufferedWriter(new FileWriter("course2.csv"));
				BufferedWriter writerCourse3 = new BufferedWriter(new FileWriter("course3.csv"));) {

			// write header line into each file
			writerCourse1.write("Student ID,Student Name,Course,Grade \n");
			writerCourse2.write("Student ID,Student Name,Course,Grade \n");
			writerCourse3.write("Student ID,Student Name,Course,Grade \n");

			// write students sorted by course
			for (Student student : students) {
				if (student.getCourse().contains("COMPSCI")) {
					writerCourse1.write(student.toCSVString());
					writerCourse1.newLine();
				} else if (student.getCourse().contains("APMTH")) {
					writerCourse2.write(student.toCSVString());
					writerCourse2.newLine();
				} else if (student.getCourse().contains("STAT")) {
					writerCourse3.write(student.toCSVString());
					writerCourse3.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
