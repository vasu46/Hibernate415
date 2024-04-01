package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.util.HibernateUtil;

public class TPSPInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses) {
			tx=ses.beginTransaction();
			Person per=new Person();
			per.setPname("VASU");
			per.setCompany("HCL");
			
			Employee emp=new Employee();
			emp.setPname("ANJANA");
			emp.setCompany("JPMORGAN");
			emp.setDesg("DEVELOPER");
			emp.setSal(90000.0);
			emp.setDept(1001);
			
			Customer cust=new Customer();
			cust.setPname("PRIYA");
			cust.setCompany("INFOSYS");
			cust.setBillAmt(9000.0);
			cust.setBillNo(1212);
			
			ses.save(per);
			ses.save(emp);
			ses.save(cust);
			tx.commit();
			System.out.println("Objects are Saved");
			
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Exception is save Object");
		    }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
