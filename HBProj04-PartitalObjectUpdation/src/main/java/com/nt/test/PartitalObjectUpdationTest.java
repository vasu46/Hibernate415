package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class PartitalObjectUpdationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/production.cfg.xml");
		//build seessionfactory
		SessionFactory factory=cfg.buildSessionFactory();
		//build session
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			//load object
			Product p=ses.get(Product.class, 1001);
			if(p==null) {
			System.out.println("record not found");
			return;
			}
			else {
				//begin tx
				tx=ses.beginTransaction();
				//modify teh object parrtial
				p.setPrice(67800.0f);
				ses.update(p);
				tx.commit();
				System.out.println("partital object is updated");
			   }//else
		}//try
		catch(Exception e) {
			tx.rollback();
			System.out.println("Object is not updated");
			 e.printStackTrace();
			}//catch
		}//main
		
		

	}//class


