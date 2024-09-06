package com.seleniumexpress.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAOImpl;
import com.seleniumexpress.service.StudentDaoHelper;

public class Test {

	public static void main(String[]args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("application context load...");

		StudentDaoHelper helper = context.getBean("studentDaoHelper", StudentDaoHelper.class);
		helper.setUpStudentTable();//setting up the table data

		// call the getAllStudents()
		StudentDAOImpl studentDao = context.getBean("studentDao", StudentDAOImpl.class);
		List<Student>studentList =  studentDao.getAllStudents();
		helper.printStudents(studentList);
		
		//Querying for specific object
		System.out.println("Fatching student with roll no 2");
		Student student = studentDao.findStudentByRollNo(2);
		System.out.println(student);
         
		
	}
}
