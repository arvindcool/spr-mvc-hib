package com.schooler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schooler.dao.SchoolDAO;
import com.schooler.model.School;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolDAO SchoolDAO;

	public void addSchool(School School) {
		SchoolDAO.addSchool(School);		
	}

	public void updateSchool(School School) {
		SchoolDAO.updateSchool(School);
	}

	public School getSchool(int id) {
		return SchoolDAO.getSchool(id);
	}

	public void deleteSchool(int id) {
		SchoolDAO.deleteSchool(id);
	}

	public List<School> getSchools() {
		return SchoolDAO.getSchools();
	}

}
