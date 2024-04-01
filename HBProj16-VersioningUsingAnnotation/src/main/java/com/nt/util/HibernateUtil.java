package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		System.out.println("HibernateUtil.static block");
		//create Configuration objcet
		Configuration cfg=new Configuration();
		//load Config file
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		//build Session Factory
		factory=cfg.buildSessionFactory();		
	}
	//satic factory method for SessionFactory object
	public static SessionFactory getSessionFactory() {
		return factory;
		
	}
	//static session obj
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
			
	}

}
