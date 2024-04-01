package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utility.HibernateUtility;

public class Approch2MergeObjectUsingTestSolution {
public static void main(String[] args) {
	//get SessionFactory object
	SessionFactory factory=HibernateUtility.getSessionFactory();
	//get session objevt
	Session ses=HibernateUtility.getSession();
	Transaction tx=null;
	boolean flag=false;
	
	try{
		//begin Transaction
		tx=ses.beginTransaction();
		Product prod=ses.get(Product.class,3001);
		if(prod!=null)
			System.out.println(prod);
		//upadte object
		Product prod1=new Product();
		//prod.setPid(3001);
		prod.setPid(4001);
		prod.setPrice(250.0f);
		prod.setPname("SSpoon4");
		prod.setQty(5.0f);
	    Product prod2=(Product)ses.merge(prod1);
	    System.out.println(prod2);
	    System.out.println("Object is Updtaed");
	    flag=true;
		//.commit();
		System.out.println("Given object data"+prod+"hashcode::"+prod.hashCode());
		System.out.println("Recived object data"+prod1+"hashcode::"+prod1.hashCode());
		
	}//try
	catch(HibernateException he) {
		flag=false;
		he.printStackTrace();
		}//catch
	finally {
		if(flag)
			tx.commit();
		else
			tx.rollback();
		//close objs
		ses.close();
		factory.close();
		
	}
	
  }//main

}//class
