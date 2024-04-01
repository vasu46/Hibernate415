package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Shop;
import com.nt.util.HibernateUtil;

public class TicketBookingOperation implements Runnable {

	@Override
	public void run() {
		//get Session 
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			 Shop shop= new Shop();
			 shop.setShopName("Vasushop");
			 shop.setQty(1.0f);
			 shop.setPrice(50000.00f);
			 int idVal=(Integer) ses.save(shop);
			 System.out.println("Generate Id Val::"+idVal);
			 tx.commit();
			 System.out.println("Object is saved");
		}//try
		catch(HibernateException he) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
			tx.rollback();
			System.out.println("Object is not saved(Record is not inserted");
			}
			he.printStackTrace();
		
		}	 
			 
			
		}
	
   
	
	}


