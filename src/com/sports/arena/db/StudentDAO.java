package com.sports.arena.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sports.arena.Student;

public class StudentDAO {
	
	public static void main(String args[])
	{
		StudentDAO sd = new StudentDAO();
		sd.DBtest();
	}
	
	public void DBtest()
	{
		  //creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	      
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	          
        Student s = new Student();
        s.setAge(22);
        s.setId(642);
        s.setName("FFFFFFf");
	      
	    session.persist(s);//persisting the object  
	      
	    t.commit();//transaction is committed  
	    session.close();  
	      
	    System.out.println("successfully saved");
	}

}
