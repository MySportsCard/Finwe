package com.sports.arena;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StandardScreen {
	
	private static Log logger = LogFactory.getLog(StandardScreen.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String doResponse()
	{
		logger.info("Entering into home page");
		//return new ModelAndView("student", "command", new Student());
		return "student";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, ModelMap model) 
	{
	      model.addAttribute("name", student.getName());
	      model.addAttribute("age", student.getAge());
	      model.addAttribute("id", student.getId());
		
	      return "result";
    } 
	
	@ModelAttribute("student")
	public Student construct()
	{
		return new Student();
	}
}