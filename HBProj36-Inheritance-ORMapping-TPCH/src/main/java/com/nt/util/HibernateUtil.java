package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();	
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
		
		
		
	}

}
