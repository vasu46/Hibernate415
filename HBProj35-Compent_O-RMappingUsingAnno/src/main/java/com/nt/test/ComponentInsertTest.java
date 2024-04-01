package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentInsertTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		
		try{
			tx=ses.beginTransaction();
			JobDetails details=new JobDetails();
			details.setDesg("HR");
			details.setCompany("JPMORGAN");
			details.setSalary(100000.00);
			Person per=new Person();
			per.setDetails(details);
			per.setPname("PRIYA");
			per.setPaddrs("GUNTUR");
			int idVal=(int) ses.save(per);
			System.out.println("Person Details are Intersted::"+idVal);
			tx.commit();	
		}
		catch(HibernateException he) {
			 if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				 tx.rollback();
			 }
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ses!=null)
                     ses.close();
				}
				catch(HibernateException he) {
					he.printStackTrace();
				}
			try {
			if(factory!=null)
				factory.close();
			}
			catch(HibernateException he) {
				he.printStackTrace();
			}
		}

	}

}
