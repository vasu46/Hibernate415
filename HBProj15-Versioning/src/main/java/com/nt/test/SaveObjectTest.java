package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.util.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			tx=ses.beginTransaction();
			CallerTune tune=new CallerTune();
			tune.setTuneName("srivalli");
			tune.setMovieName("Pushpa");
			ses.save(tune);
			tx.commit();
			System.out.println("Object is save and Record is saved");
		}//try
   catch(HibernateException he) {
	   if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
		   tx.rollback();
		   System.out.println("Record is not saveed");
	   }//if
	   he.printStackTrace();
     }//catchh
	}//main		

}//calss
