package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class HQLSelectTestUsingOrdinalParameters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session ses = HibernateUtil.getSession();
		try {
			//JPA ordinal positional Parameters
			/*
			 * Query query=ses.createQuery("from Product where pid>=?1 and pid<=?2");
			 * query.setParameter(1,20); query.setParameter(2, 25); //execute the Hql Quer
			 * List<Product> list=query.list(); list.forEach(prod->{
			 * System.out.println(prod); });
			 * 
			 *jpa named  parameters
			 * Query query=ses.
			 * createQuery("from Product where pname in(:prod1,:prod2,:prod3) order by pname asc"
			 * ); query.setParameter("prod1","SOFA"); query.setParameter("prod2","CHAIR");
			 * query.setParameter("prod3","Table"); List<Product> list=query.list();
			 * list.forEach(prod->{ System.out.println(prod); });
			 */
			/*
			 * //using Both NAMED parameters,and Ordianal positional Params Query query=ses.
			 * createQuery("from Product where pname in(?1,:prod1,?2)order by pname asc");
			 * //set values query.setParameter(1,"SOFA");
			 * query.setParameter("prod1","CHAIR"); query.setParameter(2,"Table");
			 * List<Product>list=query.list(); list.forEach(prod->{
			 * System.out.println(prod); });
			 */
			//executing Hql Scalr Select Query(retriving specific multiple clo values"
			Query query=ses.createQuery("select pid,pname,price from Product where price>=:min and price<=:max");
			query.setParameter("min",900.00);
			query.setParameter("max",4000.00);
			List<Object[]>list=query.list();
			list.forEach(row->{
				for(Object val:row) {
					System.out.println(val+" ");
				}
				System.out.println();
				});
		//executing Hql Scalar select query single col value)
			Query query1=ses.createQuery("select pname from Product where qty>=:min and qty<=:max");
			query1.setParameter("min",1);
			query1.setParameter("max",2);
			List<Object> list1=query1.list();
			list1.forEach(name->{
				System.out.println(name);
			});
			//executin Hql Entity select Query giving single record
			Query query2=ses.createQuery("from Product where pid=:id");
			query2.setParameter("id",22);
			Product prod=(Product)query2.getSingleResult();
			if(prod==null)
				System.out.println("recod not foud");
			else {
				System.out.println("Record is found");
				System.out.println(prod);
				
			}
		//executing Hql scalar select query single recod mulitple cols values
			Query query3=ses.createQuery("select pid,pname,price from Product where pid=:id");
		   query3.setParameter("id",22);
			Object result=query3.getSingleResult();
			Object values[]=(Object[])result;
			System.out.println(values[0]+" "+values[1]);
			
			//executing Hql scalar select query single recod single values
			Query query4=ses.createQuery("select pname from Product where pid=:id");
		   query4.setParameter("id",22);
			String name=(String) query4.getSingleResult();
			System.out.println("22 pid pane::"+name);
			
		//EXECUTING Hql Scalr select Query giving Single record single col valuw
			Query query5=ses.createQuery("select count(*) from Product");
			Long count=(Long) query5.getSingleResult();
			System.out.println("Record count is::"+count);
			
	//Excecute Multiple Aggrate Functions
			Query qur6=ses.createQuery("select min(price),max(price),avg(price) from Product");
		Object results[]=(Object[])qur6.getSingleResult();
		System.out.println("min price::"+results[0]);
		System.out.println("max prtice::"+results[1]);
		System.out.println("avg price::"+results[2]);
		
		//Excecuting Subqury on named parameters
		Query query7=ses.createQuery("from Product where price=(select max(price) from Product)");
		List<Product>list7=query7.getResultList();
		list7.forEach(prod7->{
			System.out.println(prod7);
		});
		
		
				
			
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
