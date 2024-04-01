package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {
	public static void main(String[] args) {
		//Bootstrap/Activate the hibernate
		Configuration cfg=new Configuration();
		//specify the hibernate cfg file name and location
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build SessionFactory having all services specified in cfg file and mapping file
		SessionFactory factory=cfg.buildSessionFactory();
		//create session obj
		Session ses=factory.openSession();
		Transaction tx=null;
		try {
			//begin Transaction
			tx=ses.beginTransaction();
			//prepare entity objext
			Product prod=new Product();
			//prod.setPid(1005);
			prod.setPname("table");prod.setPrice(5008.5f);prod.setQty(3.0f);
			//save object
			//ses.save(prod);
		Integer idVal=(Integer)ses.save(prod);
			tx.commit();
			System.out.println("Object is saved(Record is inserted"+idVal);	
				
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved(Record is not inserted");
		}
		//close session obj
		ses.close();
		//close Session Factory obj
		factory.close();
	}//main

}//class
