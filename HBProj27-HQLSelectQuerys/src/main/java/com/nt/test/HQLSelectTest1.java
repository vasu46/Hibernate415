package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest1 {
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtil.getFactory();
		Session ses=HibernateUtil.getSession();
	try {
	//prepare Query Objvet
			Query query=ses.createQuery("from Product");
			List<Product> list=query.list();		
			//process the Result
			/*
			 list.forEach(prod->{ 
			 System.out.println(prod); 
			 });
			 */
			//list.forEach(System.out::println);	
			for(Product p:list) {
				System.out.println(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
