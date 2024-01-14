package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public Student[] getStudentsFromFile() throws IOException {

		// Code to figure out how many lines are in a file first
		BufferedReader fileReader = new BufferedReader(new FileReader("student-master-list.csv"));
		int count = 0;

		while (fileReader.readLine() != null) {
			count++;
		}
		fileReader.close();

		// Get Users
		try {
			int i = 0;
			String line = null;
			Student[] students = new Student[count];
			fileReader = new BufferedReader(new FileReader("student-master-list.csv"));

			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");
				Student student = new Student(lineData[0], lineData[1], lineData[2], lineData[3]);
				students[i] = student;
				i++;
			}
			return students;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
