package com.schooler.dao;

import java.util.List;

import com.schooler.model.School;

public interface SchoolDAO {
	
	public void addSchool(School school);
	public void updateSchool(School school);
	public School getSchool(int id);
	public void deleteSchool(int id);
	public List<School> getSchools();

}
