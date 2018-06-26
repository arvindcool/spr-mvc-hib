package com.schooler.service;

import java.util.List;

import com.schooler.model.School;

public interface SchoolService {
	
	public void addSchool(School school);
	public void updateSchool(School school);
	public School getSchool(int id);
	public void deleteSchool(int id);
	public List<School> getSchools();

}
