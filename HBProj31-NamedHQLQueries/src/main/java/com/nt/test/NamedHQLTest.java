package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses) {
			//get Access Named HQL Select Query
			Query query=ses.getNamedQuery("HQL_GET_PRODUCTS_BY_PRICE_RANGE");
			//SET VALUES TO QUERY PARAMS
			query.setParameter("min",1000.0);
			query.setParameter("max",4000.00);
			//execute the query
			List<Product>list=query.getResultList();
			list.forEach(System.out::println);
			//begin Transaction
			tx=ses.beginTransaction();
			//get AccessName Hql Non-seelct qury
			Query query1=ses.getNamedQuery("INCREASE_PRODUCT_PRICE_BY_PRICE_RANGE");
			//set parameters
			query1.setParameter("newValue",20000.00);
			query1.setParameter("range",3000.00);
			int count=query1.executeUpdate();
			System.out.println("no of record that are effected::"+count);
		//commit tx
			tx.commit();
			
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
