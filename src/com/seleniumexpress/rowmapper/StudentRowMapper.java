package com.seleniumexpress.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seleniumexpress.api.Student;

public class StudentRowMapper implements RowMapper <Student>{

	@Override
	public Student mapRow(ResultSet res, int rowNum) throws SQLException {

		Student newStudent =new Student();
		newStudent.setRollNo(res.getInt("ROLL_NO"));
		newStudent.setName(res.getString("NAME"));
		newStudent.setAddress(res.getString("ADDRESS"));

	//	System.out.println("mapRow() called.....");

		return newStudent;
	}

}
