package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class DeleteObjectUsingDeleteMethod {

	public static void main(String[] args) {
	  Configuration cfg=new Configuration();
	  cfg.configure("com/nt/cfg/production.cfg.xml");
	  //build Session Facrtory
	  SessionFactory factory=cfg.buildSessionFactory();
	  //build Session
	  Session ses=factory.openSession();
	 Transaction tx=null;
	 try(factory;ses){
		 tx=ses.beginTransaction();
		 Product prod=new Product();
		 prod.setPid(1002);
		 ses.delete(prod);
		 tx.commit();
		 System.out.println("Object is Delete");
		 
		 }
	 catch(Exception e) {
		 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
			 tx.rollback();
			 System.out.println("Object is not Delete");
		 }
		 e.printStackTrace();
		 }//catch
	 }//main
	  
	}//class


