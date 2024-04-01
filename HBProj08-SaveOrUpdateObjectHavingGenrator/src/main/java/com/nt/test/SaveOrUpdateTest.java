package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveOrUpdateTest {

	public static void main(String[] args) {
	  Configuration cfg=new Configuration();
	  cfg.configure("com/nt/cfg/production.cfg.xml");
	  //build Session Facrtory
	  SessionFactory factory=cfg.buildSessionFactory();
	  //build Session
	  Session ses=factory.openSession();
	 Transaction tx=null;
	 try(factory;ses){
	//begin Tranction
		 tx=ses.beginTransaction();
		 //create object ofentity class
		 Product prod=new Product();
		 prod.setPid(3001);
		 prod.setPname("chair1");
		 prod.setPrice(250.0f);
		 prod.setQty(2.0f);
		 ses.saveOrUpdate(prod);
		 tx.commit();
		 System.out.println("Record is the Update or save");
		 
		 }
	 catch(Exception e) {
		 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
			 tx.rollback();
			 System.out.println("record is not save or update");
		 }
		 e.printStackTrace();
		 }//catch
	 }//main
	  
	}//class


