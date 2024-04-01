package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class LoadObjectTestingUsingGetMethod {

	public static void main(String[] args) {
	  //Configurstion obj
	  Configuration cfg=new Configuration();
	   cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
	   //build sesssion factory
	   SessionFactory factory=cfg.buildSessionFactory();
	   
	  //build Session
	   Session ses=factory.openSession();
	   try(factory;ses){ //try with resource
		   //Load object using get(-,-)method
			/*
			 * // Product prod=ses.get(Product.class ,1006);
			 * 
			 * if(prod==null) System.out.println("Production not found"); else
			 * System.out.println(prod);
			 */
		   Product prod=ses.load(Product.class,1001);
		   System.out.println(prod.getClass()+" "+prod.getClass().getSuperclass());
		     System.out.println("---------------");
		     System.out.println(prod.getPid()+" "+prod.getPname()+" "+prod.getPrice()+" "+prod.getQty());
	   }//try
	   catch(HibernateException he) {
		   he.printStackTrace();
	     }//catch
//			 ses.close(); 
//			  factory.close
	
			 
	   
	   }//main
	  
	}//class


