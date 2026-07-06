package com.hbn.learning;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.hbn.configuration.HibernateConfig;
import com.hbn.entity.Address;
import com.hbn.entity.Employee;

public class Main {
	
	
	public static void saveRecord(Session session) {
		Transaction tx = session.beginTransaction();
		Address add1 =  new Address();
		add1.setCity("Netherfield");
		add1.setState("London");
		
	   Employee e1 = new Employee();
	   e1.setName("Lizzy");
	   e1.setGender("female");
	   e1.setSalary(52000);
       e1.setAddress(add1);
      
      add1.setEmployee(e1);
       
     session.persist(add1);	  
 	 session.persist(e1);
 	 
 	 
 	 tx.commit();
 	  
	
	}

	public static void main(String[] args) {
		
		
		
	 Session session = HibernateConfig.getSessionFactory().openSession(); 
	 saveRecord(session);
	

	 
Address address = session.find(Address.class, 2);
	 System.out.println(address);
	 System.out.println(address.getEmployee());
	
	 session.close();

}

}

