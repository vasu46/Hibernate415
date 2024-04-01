package com.nit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Movie;
import com.nit.util.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//getSessionFactory obj
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session obj
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
	try{
			//begin tx
			tx=ses.beginTransaction();
			//prepare object
			Movie movie=new Movie();
			movie.setMid(1001);
			movie.setMname("RRR");
			movie.setHero("charan-NTR");
			movie.setBudget(300.0f);
			ses.save(movie);
			tx.commit();
			System.out.println("Object saved");
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null &&tx.getRollbackOnly()) {
				tx.rollback();
			}
			e.printStackTrace();
			}
		}
				

	}


