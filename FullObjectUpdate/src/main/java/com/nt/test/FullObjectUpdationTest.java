package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class FullObjectUpdationTest {

	public static void main(String[] args) {
	  //configuration object
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build session factory object
		SessionFactory factory=cfg.buildSessionFactory();
		//build session
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){ //try with resource
			//begin Tx
			tx=ses.beginTransaction();
			//prepare objevt for enetity class
			Product p=new Product();
			p.setPid(1001); //exit value id
			p.setPname("launge1"); //new value
			p.setPrice(20000.00f); //new value
			p.setQty(5.5f); //new value
			//instruction to uoadte object
			ses.update(p);
			//commit the tx
			tx.commit();
		System.out.println("Full object is updated");
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("object is not updated");
			}
			e.printStackTrace();
			
			
		}//catch

	}//main

}//class
