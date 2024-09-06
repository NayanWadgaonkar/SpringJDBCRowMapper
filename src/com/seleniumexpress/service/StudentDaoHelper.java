package com.seleniumexpress.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAO;

@Service("studentDaoHelper")
public class StudentDaoHelper {

	@Autowired
	private StudentDAO studentDAOImpl;

	public void setUpStudentTable() {

		Student student1 = new Student();
		student1.setRollNo(2);
		student1.setName("Aniket");
		student1.setAddress("Pak");

		Student student2 = new Student();
		student2.setRollNo(10);
		student2.setName("Nayan");
		student2.setAddress("Prague");

		Student student3 = new Student();
		student3.setRollNo(3);
		student3.setName("neha");
		student3.setAddress("pune");

		ArrayList<Student> studentList = new ArrayList<>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);

		studentDAOImpl.change(studentList);
	}
	public void printStudents(List<Student>students) {
		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

}
