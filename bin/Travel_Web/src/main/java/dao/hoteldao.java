package dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import tool.*;
import entity.*;
/**
 * Session Bean implementation class hoteldao
 */
@Stateless
@LocalBean
public class hoteldao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
	EntityManager em;
    public hoteldao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    	em=emf.createEntityManager();
    }
    public Hotel findHotel (long id)
    {
    	Hotel customer = null;
    	
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	ut.begin();
    	customer=em.find(Hotel.class, id);
    	em.close();
    	return customer;
    }
    public List<Hotel> getHotelList()
    {
    	Query q = em.createQuery("select c from Hotel c");
    	q.setFirstResult(1);
    	int page=1;
    	q.setMaxResults(1+page);
    	List<Hotel> out = new ArrayList<Hotel>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Hotel)q.getResultList().get(i));
    	}
    	return out;
    }
    
    public List<Hotel> getSearchHotelList(String str)
    {
    	String column="INTRO";
    	String temp=tool.getQuery(str,column);
    	Query q = em.createQuery("select c from Hotel c where "+temp);
    	System.out.print("select c from Hotel c where "+temp);
    	q.setFirstResult(0);
    	int page=1;
    	q.setMaxResults(1+10);
    	List<Hotel> out = new ArrayList<Hotel>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Hotel)q.getResultList().get(i));
    	}
    	return out;
    }
    
    public List<Hotel> getHotelList(int page)
    {
    	Query q = em.createQuery("select c from Hotel c");
    	q.setFirstResult(12);
    	q.setMaxResults(1+page);
    	List<Hotel> out = new ArrayList<Hotel>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Hotel)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Hotel> getHotelList(int start,int page)
    {
    	Query q = em.createQuery("select c from Hotel c");
    	q.setFirstResult(start);
    	q.setMaxResults(start+page);
    	List<Hotel> out = new ArrayList<Hotel>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Hotel)q.getResultList().get(i));
    	}
    	return out;
    }
    public long getCount() 
    {
    	Query q=em.createQuery("select COUNT(*) from Hotel");
    	long count=(long) q.getSingleResult();
    	return count;
    }

}
