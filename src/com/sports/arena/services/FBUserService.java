package com.sports.arena.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sports.arena.Model.FbUserObject;
import com.sports.arena.dao.FBUserDAO;

@Service()
public class FBUserService {
	
	private FBUserDAO userdao;

	@Transactional
	public void saveUser(FbUserObject user)
	{
		try
		{
			userdao.persist(user);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
