package dao;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import entity.Customer;
import entity.Person;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class persondao
 */
@Stateless
@LocalBean
public class persondao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
    public persondao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    }
    
   
    
    public Person findPerson(String id)
    {
    	Person person = null;
    	
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	ut.begin();
    	person=em.find(Person.class, id);
    	em.close();
    	return person;
    }
    
    public void addPerson(Person person)
    {
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		//em.joinTransaction();
    		em.persist(person);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    
    public void removePerson(Person person)
    {
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    	//	em.joinTransaction();
    		//Person = em.merge(Person);
    		em.remove(em.merge(person));
    	//	em.remove(Person);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

}
