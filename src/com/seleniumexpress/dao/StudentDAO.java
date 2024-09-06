package com.seleniumexpress.dao;

import java.util.List;

import com.seleniumexpress.api.Student;

public interface StudentDAO {

	void insert(Student student);
	void change(List<Student> students); // update
	boolean deleteRecordByRollNo(int rollNo);
	int deleteRecordByStudentNameAndStudentAddress (String studentname, String studentaddress);
	List<Student> getAllStudents(); //select for all students
	
	Student findStudentByRollNo(int rollNo);
}
