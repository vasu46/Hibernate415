package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.CallerTune;

public class LoadAndUpdateObjectTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			CallerTune tune=ses.get(CallerTune.class, 162);
			if(tune==null) {
				System.out.println("record is not found");
				return;
			}
			else {
				tx=ses.beginTransaction();
				tune.setTuneName("NatuNatu");
				tune.setMovieName("RRR");
				  ses.update(tune);
				tx.commit();
				 System.out.println("record will be saved/inserted");
				   System.out.println("rcord insertion time::"+tune.getLaunchTime());
				   System.out.println("record how may times upadated::"+tune.getUpdationCount());
				   System.out.println("record last upadation time::"+tune.getLastUpdationTime());
			}//else
			
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Record is not upadted");
			}//if
			e.printStackTrace();
		}//catch

	}//main

}//class
