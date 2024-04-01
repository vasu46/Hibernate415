package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.util.HibernateUtil;

public class TPCCSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses) {
			Query query1=ses.createQuery("from Employee");
			List<Employee> list=query1.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println("==================");
			Query query2=ses.createQuery("from Customer");
			List<Customer> list1=query2.getResultList();
			list1.forEach(cust->{
				System.out.println(cust);
			});
			System.out.println("==================");
			Query query3=ses.createQuery("from Person");
			List<Person> list2=query3.getResultList();
			list2.forEach(per->{
				System.out.println(per);
			});
			System.out.println("==================");
			System.out.println("Objects are Retrived");
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
