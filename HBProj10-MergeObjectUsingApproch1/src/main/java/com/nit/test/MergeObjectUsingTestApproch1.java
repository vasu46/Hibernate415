package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utility.HibernateUtility;

public class MergeObjectUsingTestApproch1 {
public static void main(String[] args) {
	//get SessionFactory object
	SessionFactory factory=HibernateUtility.getSessionFactory();
	//get session objevt
	Session ses=HibernateUtility.getSession();
	Transaction tx=null;
	try(factory;ses){
		//begin Transaction
		tx=ses.beginTransaction();
		Product prod=new Product();
		//prod.setPid(3001);
		prod.setPid(4001);
		prod.setPrice(250000.0f);
		prod.setPname("bulldoger");
		prod.setQty(5.0f);
		Product prod1=(Product)ses.merge(prod);
		tx.commit();
		System.out.println("Given object data"+prod+"hashcode::"+prod.hashCode());
		System.out.println("Recived object data"+prod1+"hashcode::"+prod1.hashCode());
		
	}//try
	catch(HibernateException he) {
		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
			tx.rollback();
			System.out.println("Object is not Saved or not updated");
		}
		he.printStackTrace();
	}
	
  }//main

}//class
