package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentSelectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		
		try{
			Query query1=ses.createQuery("from Person");
			List<Person> list=query1.getResultList();
			list.forEach(per->{
				System.out.println("Person details::"+per.getPid()+" "+per.getPname()+" "+per.getPaddrs());
				JobDetails details=per.getDetails();
				System.out.println("JobDetails::"+details.getDesg()+" "+details.getCompany()+" "+details.getSalary());
			});
			
		}
		catch(HibernateException he) {
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
