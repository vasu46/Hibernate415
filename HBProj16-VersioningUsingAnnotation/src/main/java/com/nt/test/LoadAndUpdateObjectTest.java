package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.util.HibernateUtil;

public class LoadAndUpdateObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   //get session factory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session
		Session ses=HibernateUtil.getSession();
	//Transaction 
		Transaction tx=null;
  try(factory;ses){
	  
	 //get the object 
	  CallerTune tune=ses.get(CallerTune.class,161);
	  if(tune==null) {
		  System.out.println("Record is not found");
		  return;
		  
	  }//if
	  else {
		  tx=ses.beginTransaction();
		  tune.setMovieName("PUSHPA");
		 tune.setTuneName("OO ANTAVA MAVA");
		 ses.update(tune);
		 tx.commit();
		 System.out.println("ObjectUpadted time::"+tune.getUpdationCount());
	  }//else
  }//try
  catch(HibernateException he) {
	  if(tx!=null || tx.getClass()!=null || tx.getRollbackOnly()) {
		  tx.rollback();
		 System.out.println("Record is not Upadted");
	  }
	  he.printStackTrace();
  }
	}

}
