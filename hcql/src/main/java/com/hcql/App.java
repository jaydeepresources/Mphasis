package com.hcql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		SessionFactory factory = config.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

//		 Sales s1 = new Sales(0, "pencil", 10.0f);
//		 Sales s2 = new Sales(0, "pen", 15.5f);
//		 Sales s3 = new Sales(0, "eraser", 2.0f);
//		 Sales s4 = new Sales(0, "notebook", 33.0f);
//		 Sales s5 = new Sales(0, "file", 50.0f);
//		 Sales s6 = new Sales(0, "folder", 125.0f);
//		 Sales s7 = new Sales(0, "sharpener", 5.0f);
//		 Sales s8 = new Sales(0, "sticker", 8.0f);
//		 Sales s9 = new Sales(0, "ruler", 12.0f);
//		 Sales s10 = new Sales(0, "compass", 40.0f);
//		
//		 session.persist(s1);
//		 session.persist(s2);
//		 session.persist(s3);
//		 session.persist(s4);
//		 session.persist(s5);
//		 session.persist(s6);
//		 session.persist(s7);
//		 session.persist(s8);
//		 session.persist(s9);
//		 session.persist(s10);
//		
//		 System.out.println("Saved");

		Criteria c = null;
		List<Sales> sales = null;

		c = session.createCriteria(Sales.class);
		c.setFirstResult(0);
		c.setMaxResults(4);
		sales = c.list();

		System.out.println(sales);

		c = session.createCriteria(Sales.class);
		c.add(Restrictions.gt("price", 25.0f));
		sales = c.list();

		System.out.println(sales);
		
		c = session.createCriteria(Sales.class);
		c.add(Restrictions.eq("productName", "file"));
		sales = c.list();

		System.out.println(sales);
		
		c = session.createCriteria(Sales.class);
		c.add(Restrictions.like("productName", "pen%"));
		sales = c.list();

		System.out.println(sales);
		
		c = session.createCriteria(Sales.class);
		c.addOrder(Order.asc("price"));
		sales = c.list();

		System.out.println(sales);

		transaction.commit();
		session.close();

	}
}
