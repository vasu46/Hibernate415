package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.CallerTune;

public class SaveObjectTest {

	public static void main(String[] args) {
	   Configuration cfg=new Configuration();
	   cfg.configure("com/nt/cfg/hibernate.cfg.xml");
	   SessionFactory factory=cfg.buildSessionFactory();
	   Session ses=factory.openSession();
	   Transaction tx=null;
	   try(factory;ses){
		   tx=ses.beginTransaction();
		   CallerTune tune=new CallerTune();
		   tune.setTuneName("srivalli");
		   tune.setMovieName("PUSHPA");
		   int idVal=(Integer) ses.save(tune);
		   tx.commit();
		   System.out.println("Object idVal::"+idVal);
		   System.out.println("record will be saved/inserted");
		   System.out.println("rcord insertion time::"+tune.getLaunchTime());
		   System.out.println("record how may times upadated::"+tune.getUpdationCount());
		   System.out.println("record last upadation time::"+tune.getLastUpdationTime());
	   }
	   

	}

}
