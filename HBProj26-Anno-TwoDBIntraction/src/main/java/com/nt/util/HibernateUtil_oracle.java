package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_oracle {
	private static SessionFactory factory;
	static {
		System.out.println("HibernateUtil_oracle::staic block");
		//Create Configuration Object to activate hibernate
		Configuration cfg=new Configuration();
		//mapping cfg file
		cfg.configure("com/nt/cfg/hibernate-oracle.cfg.xml");
		//open Build session
		factory=cfg.buildSessionFactory();	
	  }
	public static SessionFactory getFactory() {
		return factory;
		
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
		
	}

}
