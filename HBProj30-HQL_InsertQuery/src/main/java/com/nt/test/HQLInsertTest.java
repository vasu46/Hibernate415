package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses) {
			//begin Transaction
			tx=ses.beginTransaction();
			Query query=ses.createQuery("INSERT INTO SpecialProduct(pid,pname,price,qty)SELECT p.pid,p.pname,p.price,p.qty from Product as p where p.price>=:min");
			query.setParameter("min",700);
			int count=query.executeUpdate();
			tx.commit();
			System.out.println("No of Recors That are Effected"+count);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in HQL INSRT QUERY EXCEPTION");
				
			}//IF
			
		}//CATCH

	}//main

}//calss
