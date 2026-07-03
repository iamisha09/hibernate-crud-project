package com.hbn.learning;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.hbn.configuration.HibernateConfig;
import com.hbn.entity.Employee;

public class Main {

	public static void main(String[] args) {
		
	Employee e = new Employee("vishi", "Female" , 215000);
	
	Session session = HibernateConfig.getSessionFactory().openSession(); 
	Transaction tx = session.beginTransaction();
	
      
	Query query = session.createNamedQuery("findByID",Employee.class);
	
	  query.setParameter("id" , 2);
	  
	  List list = query.getResultList();
	  
	  System.out.println(list);
	  
	  System.out.println("___________________________________________________________________________________________");
	  
	  Query query2 = session.createNamedQuery("findByGender" , Employee.class);
	  query2.setParameter("gender" , "female");
	  List list2 = query2.getResultList();
	  System.out.println(list2);
	  
	
	
	tx.commit();
	session.close();

}

}

