package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil_mysql;
import com.nt.util.HibernateUtil_oracle;

public class TransferProductTest {

	public static void main(String[] args) {
	  SessionFactory mysqlFactory=HibernateUtil_mysql.getFactory();
	  SessionFactory oracleFactory=HibernateUtil_oracle.getFactory();
	  Session mysqlSes=HibernateUtil_mysql.getSession();
	 Session oracleSes=HibernateUtil_oracle.getSession();
      Transaction oracleTx=null;
      try(mysqlFactory;oracleFactory;mysqlSes;oracleSes){
    	  Product prod=mysqlSes.get(Product.class, 102);
    	  System.out.println(prod);
    	  //transaction begin
    	 oracleTx=oracleSes.beginTransaction();
    	  int idval=(int) oracleSes.save(prod);
    	  oracleTx.commit();
      }
      catch(Exception se) {
    	  if(oracleTx!=null && oracleTx.getStatus()!=null && oracleTx.getRollbackOnly()) {
    		  oracleTx.rollback();
    		  System.out.println("Problem in transfferin record");
    	  }//if
    	  se.printStackTrace();
      }

	}

}
