package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.ProgrammerProjectId;
import com.nt.entity.ProgrammerProjectInfo;

public class SaveObjectTest {

	public static void main(String[] args) {
	   Configuration cfg=new Configuration();
	   cfg.configure("com/nt/cfg/hibernate.cfg.xml");
	   SessionFactory factory=cfg.buildSessionFactory();
	   Session ses=factory.openSession();
	   Transaction tx=null;
	   try(factory;ses){
		   tx=ses.beginTransaction();
		   
		   ProgrammerProjectId id1=new  ProgrammerProjectId(101,1001);
		  
		   ProgrammerProjectInfo info=new ProgrammerProjectInfo(id1,"vasu","Amex",90000.00,3000000.00);
		  
		   ProgrammerProjectId idVal= (ProgrammerProjectId) ses.save(info);
		 
		   tx.commit();
		 
		   System.out.println("Record will be insert and store in db");
		   System.out.println("Object idVal::"+idVal);
		  
	   }//try
	   catch(Exception e) {
		   if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
			   tx.rollback();
			   
			 }//if
		   e.printStackTrace();
		   
	   }//catch
	   
	   

	}//main

}//class
