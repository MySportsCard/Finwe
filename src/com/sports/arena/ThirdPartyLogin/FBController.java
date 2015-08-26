package com.sports.arena.ThirdPartyLogin;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sports.arena.Model.FbUserObject;
import com.sports.arena.services.FBUserService;


@Controller
public class FBController {
	private static ObjectMapper objectmapper = new ObjectMapper(){
		{
			configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		}
	};
	
	@Autowired
	private FBUserService fbservice;

	@RequestMapping(value="/loginfb", method=RequestMethod.POST)
	public  @ResponseBody String confirmLogin(@RequestBody String userjson)
	{
		FbUserObject userobject = null;
		try 
		{
			userobject = objectmapper.readValue(userjson, FbUserObject.class);
			fbservice.saveUser(userobject);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Successfully Saved into DB "+userobject.getFirst_name();
	}
}
