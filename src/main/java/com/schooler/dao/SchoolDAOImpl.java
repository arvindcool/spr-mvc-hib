package com.schooler.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schooler.model.School;

@Repository
public class SchoolDAOImpl implements SchoolDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addSchool(School School) {
		getCurrentSession().save(School);
	}

	public void updateSchool(School School) {
		School SchoolToUpdate = getSchool(School.getId());
		SchoolToUpdate.setName(School.getName());
		SchoolToUpdate.setSchoolId(School.getSchoolId());
		getCurrentSession().update(SchoolToUpdate);
		
	}

	public School getSchool(int id) {
		School School = (School) getCurrentSession().get(School.class, id);
		return School;
	}

	public void deleteSchool(int id) {
		School School = getSchool(id);
		if (School != null)
			getCurrentSession().delete(School);
	}

	@SuppressWarnings("unchecked")
	public List<School> getSchools() {
		return getCurrentSession().createQuery("from School").list();
	}

}
