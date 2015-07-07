package com.sports.arena.ThirdPartyLogin;

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


@Controller
public class FBController {
	private static ObjectMapper objectmapper = new ObjectMapper(){
		{
			configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		}
	};

	@RequestMapping(value="/loginfb", method=RequestMethod.POST)
	public  @ResponseBody String confirmLogin(@RequestBody String userjson)
	{
		FbUserObject requestBody = null;
		try 
		{
			requestBody = objectmapper.readValue(userjson, FbUserObject.class);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Successfully Saved into DB "+requestBody.getFirst_name();
	}
}
