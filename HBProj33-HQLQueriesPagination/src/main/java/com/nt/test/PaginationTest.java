package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class PaginationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses) {
			//create Hql Query
			Query query=ses.createQuery("from Product");
			query.setFirstResult(9);
			query.setMaxResults(3);
			//execute query
			List<Product>list=query.getResultList();
			//process the result set
			list.forEach(System.out::println);
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in HQL INSRT QUERY EXCEPTION");
				
			}//IF
			
		}//CATCH

	}//main

}//calss
