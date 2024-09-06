package com.seleniumexpress.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.rowmapper.StudentRowMapper;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO STUDENT VALUES (?, ?, ?)";
		Object[]arg= {student.getRollNo(),student.getName(),student.getAddress()};
		int noOfRowInserted = jdbcTemplate.update(sql,arg);
		System.out.println("no of row insertes : "+noOfRowInserted);
	}



	@Override
	public boolean deleteRecordByRollNo(int rollNo) {
		// TODO Auto-generated method stub
          String sql = "DELETE FROM STUDENT WHERE ROLL_NO =?";
		  int noOfRowDeleted = jdbcTemplate.update(sql,rollNo);
		  System.out.println("no of row deleted :  "+noOfRowDeleted);
		return noOfRowDeleted == 1;
	}

	@Override

	public int deleteRecordByStudentNameAndStudentAddress (String studentname, String studentaddress) {
		String sql = "DELETE FROM STUDENT WHERE NAME = ? OR ADDRESS=?";
		Object[]args = {studentname,studentaddress};
		  int noOfRowsDeleted = jdbcTemplate.update(sql,args);
		  System.out.println("no of row deleted :  "+noOfRowsDeleted);
		return noOfRowsDeleted ;


	}

	@Override
	public void change(List<Student> students) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO STUDENT(ROLL_NO,NAME,ADDRESS) VALUES (?, ?, ?)";
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		for(Student tempStudent : students)
		{
			Object[] studentData = {tempStudent.getRollNo(),tempStudent.getName(),tempStudent.getAddress()};
			sqlArgs.add(studentData);
		}
		jdbcTemplate.batchUpdate(sql,sqlArgs);
		System.out.println("Batch udated!!!");

	}


	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub

		String selectSql = "SELECT * FROM STUDENT";
		List<Student> studentList= jdbcTemplate.query(selectSql, new StudentRowMapper());
		return studentList;
	}


	@Override
	public Student findStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
			String selectSql = "SELECT * FROM STUDENT WHERE ROLL_NO=?";
			Student student = jdbcTemplate.queryForObject(selectSql,new StudentRowMapper(),rollNo);
			return student;
		}
		
	}


	




