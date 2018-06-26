package com.schooler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.schooler.model.School;
import com.schooler.service.SchoolService;

@Controller
@RequestMapping(value="/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addschoolPage() {
		ModelAndView modelAndView = new ModelAndView("add-school-form");
		modelAndView.addObject("school", new School());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingschool(@ModelAttribute School school) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		schoolService.addSchool(school);
		
		String message = "school was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfschools() {
		ModelAndView modelAndView = new ModelAndView("list-of-schools");
		
		List<School> schools = schoolService.getSchools();
		modelAndView.addObject("schools", schools);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editschoolPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-school-form");
		School school = schoolService.getSchool(id);
		modelAndView.addObject("school",school);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingschool(@ModelAttribute School school, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		schoolService.updateSchool(school);
		
		String message = "school was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteschool(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		schoolService.deleteSchool(id);
		String message = "school was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
