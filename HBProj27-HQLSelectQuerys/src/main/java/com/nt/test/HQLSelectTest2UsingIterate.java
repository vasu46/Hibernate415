package com.nt.test;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest2UsingIterate {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtil.getFactory();
		Session ses=HibernateUtil.getSession();
	try {
	      Query query= ses.createQuery("from Product");
	      Iterator<Product> it=query.iterate();
	      while(it.hasNext()) {
	    	  Product prod=it.next();
	    	  System.out.println(prod);  
	    	  
	      }
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
