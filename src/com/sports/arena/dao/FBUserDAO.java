package com.sports.arena.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sports.arena.Model.BaseObject;

@Repository
public class FBUserDAO {
	
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}



	public void setSession(SessionFactory session) {
		this.session = session;
	}



	public<U extends BaseObject> void persist(U anyEntity)
	{
		try
		{
			session.getCurrentSession().persist(anyEntity);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}