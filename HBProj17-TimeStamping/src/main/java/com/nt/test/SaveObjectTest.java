package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Stock;
import com.nt.util.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			tx=ses.beginTransaction();
			//create object
			Stock stack=new Stock("TCS",56.77,"BSE");
			int idval=(Integer) ses.save(stack);
		 tx.commit();
			System.out.println("save object idvalue::"+idval);
			System.out.println("Object/recored saved at::"+stack.getLastUpdated());
			
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("object is not saved");
				
			}//if
		}//catch

	}//main
}//class


