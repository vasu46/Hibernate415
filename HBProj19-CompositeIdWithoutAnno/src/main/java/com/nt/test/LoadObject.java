package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.ProgrammerProjectId;
import com.nt.entity.ProgrammerProjectInfo;

public class LoadObject {

	public static void main(String[] args) {
		 Configuration cfg=new Configuration();
		   cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		   SessionFactory factory=cfg.buildSessionFactory();
		   Session ses=factory.openSession();
		   Transaction tx=null;
		   try(factory;ses){
			   tx=ses.beginTransaction();
			  ProgrammerProjectId id1=new ProgrammerProjectId(101,1001);
			  ProgrammerProjectInfo info=ses.get(ProgrammerProjectInfo.class, id1);
			  if(info!=null) {
				  System.out.println("Record is found"+info);
				  
			  }
	}//try
		   catch(Exception e) {
			   if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				   tx.rollback();
				   System.out.println("Record is not Found");
			   }
			   e.printStackTrace();
			   
		   }//if
	}//catch
}
