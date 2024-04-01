package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class UpdateObjectTest {

	public static void main(String[] args) {
		//cretate Configuration class
		Configuration cfg=new Configuration();
		//config cfguration file to start hb f/w
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		//build sessionFactory
		SessionFactory factory=cfg.buildSessionFactory();
		//build session
		Session ses=factory.openSession();
		//cretaTE TRAnsation
		Transaction tx=null;
		try(factory;ses){
			tx=ses.beginTransaction();
			//cretae object for prod class
			Product prod=new Product();
			//set values of produxt table
			prod.setPid(1234);
			prod.setPname("OPPoA5s");
			prod.setPrice(75000.00f);
			prod.setQty(1.0f);
			Integer idVal=(Integer) ses.save(prod);
			System.out.println("the generator idval::"+idVal);
			tx.commit();
			System.out.println("transaction status::"+tx.getStatus());
			System.out.println("Object is saved and record is inserted");
		}//try
		
		catch(Exception he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
			System.out.println("Object is not saved and not record insaterd");
		}
		he.printStackTrace();
		}//catch

	}//main

}//calss
