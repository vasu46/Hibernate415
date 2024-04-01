package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

		private static SessionFactory factory;
		static {
			System.out.println("HibernateUtil.static block:: start()");
			//create Configuration object
			Configuration cfg=new Configuration();
			//hibernate framework started
			cfg.configure("com/nt/cfg/hibernate.cfg.xml");
			//build session factory
			factory=cfg.buildSessionFactory();
		}
		public static  SessionFactory getSessionFactory() {
			return factory;
		}
		public static Session getSession() {
			Session ses=null;
			if(factory!=null) 
				ses=factory.openSession();
				return ses;
			
			}
		
				
		
			
		
			
			
		



}
