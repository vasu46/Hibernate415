package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Shop;
import com.nt.util.HibernateUtil;

public class SaveObjectTestInCulsterEnv {
	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//begin Transaction
			tx=ses.beginTransaction();
			//prepare entity objext
			Shop shop=new Shop();
			shop.setShopId(101);
			shop.setShopName("JANERAL");
			shop.setPrice(10000.00f);
			shop.setQty(1f);
			//save object
			int idVal=(Integer)ses.save(shop);
			 System.out.println("Generate idVal::"+idVal);
			 try {
				 Thread.sleep(50000);
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			tx.commit();
			System.out.println("Object is saved(Record is inserted");	
		}//try
		catch(HibernateException he) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
			tx.rollback();
			System.out.println("Object is not saved(Record is not inserted");
			}
			he.printStackTrace();
		}
	
	}//main

}//class
