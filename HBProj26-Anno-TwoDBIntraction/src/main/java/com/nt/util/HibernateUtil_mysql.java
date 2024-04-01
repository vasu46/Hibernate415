package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_mysql {
	private static SessionFactory factory;
	static {
		System.out.println("Static block of HibernateUtil_mysql");
		//Create Configuration Object
		Configuration cfg=new Configuration();
		//mapping cfg file
		cfg.configure("com/nt/cfg/hibernate-mysql.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) {
			ses=factory.openSession();
		}//if
		return ses;
	}

}
