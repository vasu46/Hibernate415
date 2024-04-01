package com.nit.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory factory;
	static {
		System.out.println("Hibernateutil.staticblock");
		//create configuration object
		Configuration cfg=new Configuration();
		//load and read configuratio  file
		cfg.configure("com/nit/cfgs/production.cfg.xml");
		//build session factory
	    factory=cfg.buildSessionFactory();
	   }
	//staic factory method for SessionFactory object
	public static SessionFactory getSessionFactory() {
		return factory;
	   }
	//static factory method for session obj
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}


}
