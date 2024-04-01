package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class DeleteObjectUsingLoadAndDeleteMethod {

	public static void main(String[] args) {
	  Configuration cfg=new Configuration();
	  cfg.configure("com/nt/cfg/production.cfg.xml");
	  //build Session Facrtory
	  SessionFactory factory=cfg.buildSessionFactory();
	  //build Session
	  Session ses=factory.openSession();
	 Transaction tx=null;
	 try(factory;ses){
		 //Load Object
		 Product prod=ses.get(Product.class, 1002);
		 if(prod==null) {
			 System.out.println("Record is not found");
			 return;
		 }
			 else {
				 //egin transaction
				 tx=ses.beginTransaction();
				 ses.delete(prod);
				 System.out.println("Record will be delete");
				 
			 }
		 
		 
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


