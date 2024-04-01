package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class HQLNonSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses) {
			//begin Transaction
			tx=ses.beginTransaction();
			/*
			 * //Prepare Query for update
			 *  Query query=ses. createQuery("update Product set price=price-:discount where price>=:min and price<=:max" ); 
			 *  //set parameters
			 *   query.setParameter("discount",300);
			 * query.setParameter("min",1000); 
			 * query.setParameter("max",5000); 
			 * //execute query
			 *  int count=query.executeUpdate(); tx.commit();
			 * System.out.println("No of Records THat are Effected::"+count);
			 */
			
	//PREPare query for delete query
			Query query=ses.createQuery("delete from Product where qty=:val");
			//Set parameters
			query.setParameter("val",2);
			int count=query.executeUpdate();
			System.out.println("No of recirds that are effected"+count);
			
				
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				 tx.rollback();
				 System.out.println("Problem in executing query");
			}//if
		}//catch

	}//main

}//calss
