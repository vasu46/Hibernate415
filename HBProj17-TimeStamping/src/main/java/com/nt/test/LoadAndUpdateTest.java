package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Stock;
import com.nt.util.HibernateUtil;

public class LoadAndUpdateTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//load object
			Stock stock=ses.get(Stock.class, 1);
			if(stock==null) {
				System.out.println("Record is not found");
				return;
			}//if
			else {
				tx=ses.beginTransaction();
				stock.setPrice(66.88);
				ses.update(stock);
				tx.commit();
				System.out.println("Object/record is lastly updated at::"+stock.getLastUpdated());		
				
			}//else
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				
			
			tx.rollback();
			System.out.println("Object is not updated");
			}//if
			e.printStackTrace();
			
		}//catch

	}//main

}//calss
