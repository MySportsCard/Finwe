package com.sports.arena;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StandardScreen {
	
	private static Log logger = LogFactory.getLog(StandardScreen.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String doResponse()
	{
		logger.info("Entering into home page");
		//return new ModelAndView("student", "command", new Student());
		//return "student";
		return "index";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, ModelMap model) 
	{
	      model.addAttribute("name", student.getName());
	      model.addAttribute("age", student.getAge());
	      model.addAttribute("id", student.getId());
		
	      return "result";
    }
	
	@RequestMapping(value="/test", method=RequestMethod.POST, consumes="application/xml")
	public ResponseEntity<String> RequestBodyService(@RequestBody Student stud)
	{
		return new ResponseEntity<String>(
			      "Handled application/xml request. Request body was: " 
			      + stud.getName(), 
			      new HttpHeaders(), 
			      HttpStatus.OK);
	}
	
	@RequestMapping(value="/testw", method=RequestMethod.POST, consumes="application/xml")
	public @ResponseBody String DupRequestBodyService(@RequestBody Student stud)
	{
		return "Successfully returned "+stud.getName();
	}
	
	@RequestMapping(value="/testwq", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody String DuRequestBodyService(@RequestBody String stud)
	{
		logger.info(stud);
		return new JsonResponse("ok", "").toString();
	}
	
	@ModelAttribute("student")
	public Student construct()
	{
		return new Student();
	}
	
	class JsonResponse {
		 
		  private String status = "";
		  private String errorMessage = "";
		 
		  public JsonResponse(String status, String errorMessage) {
		    this.status = status;
		    this.errorMessage = errorMessage;
		  }
	}
}