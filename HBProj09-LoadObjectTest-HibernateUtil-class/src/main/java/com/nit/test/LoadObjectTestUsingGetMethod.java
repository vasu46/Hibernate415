package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nit.entity.Product;
import com.nit.utility.HibernateUtility;

public class LoadObjectTestUsingGetMethod {
public static void main(String[] args) {
	//get SessionFactory object
	SessionFactory factory=HibernateUtility.getSessionFactory();
	//get session objevt
	Session ses=HibernateUtility.getSession();
	try(factory;ses){
		//load obkevt using get(-,-) method
		Product prod=ses.get(Product.class, 3001);
		if(prod==null)
			System.out.println("Product not found");
		else
			System.out.println(prod);
		
	}//try
	catch(HibernateException he) {
		he.printStackTrace();
	}
	
  }//main

}//class
