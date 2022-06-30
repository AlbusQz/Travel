package dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import entity.Customer;
import entity.Person;
import java.sql.Date;
/**
 * Session Bean implementation class customerdao
 */
@Stateless
@LocalBean
public class customerdao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
    public customerdao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    }
    
    public java.sql.Date getDate()
    {
    	java.util.Date uDate=new java.util.Date();
    	return new java.sql.Date(uDate.getTime());
    }
    
    public Customer findCustomer (long id)
    {
    	Customer customer = null;
    	
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	ut.begin();
    	customer=em.find(Customer.class, id);
    	em.close();
    	return customer;
    }
    public Customer findCustomerbytel (long id)
    {
    	Customer customer = null;
    	
    	EntityManager em=emf.createEntityManager();
    	Query q = em.createQuery("select c from Customer c where TEL= "+id);
    	if(q.getResultList().size()>0)
    	{
    		customer=(Customer) q.getResultList().get(0);
    	}
    	em.close();
    	
    	return customer;
    }
    
    public void addCustomer(Customer customer)
    {
    	Calendar c = Calendar.getInstance(Locale.CHINA);
    	customer.setCtime(c); 
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		em.joinTransaction();
    		em.persist(customer);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    
    public void addPerson(Customer customer,Person person)
    {
    	customer.setPerson(person);
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		//em.joinTransaction();
    		//em.persist(customer);
    		em.merge(customer);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

}
