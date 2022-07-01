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

import entity.Insurance;
import entity.Insurance;
import entity.Insurance;
import tool.tool;

/**
 * Session Bean implementation class Insurancedao
 */
@Stateless
@LocalBean
public class insurancedao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
	EntityManager em;
    public insurancedao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    	em=emf.createEntityManager();
    }

    public Insurance findInsurance (long id)
    {
    	Insurance customer = null;
    	
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	ut.begin();
    	customer=em.find(Insurance.class, id);
    	em.close();
    	return customer;
    }
    public List<Insurance> getInsuranceList()
    {
    	Query q = em.createQuery("select c from Insurance c");
    	q.setFirstResult(1);
    	int page=1;
    	q.setMaxResults(1+page);
    	List<Insurance> out = new ArrayList<Insurance>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Insurance)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Insurance> getInsuranceList(int page)
    {
    	Query q = em.createQuery("select c from Insurance c");
    	q.setFirstResult(12);
    	q.setMaxResults(1+page);
    	List<Insurance> out = new ArrayList<Insurance>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Insurance)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Insurance> getInsuranceList(int start,int page)
    {
    	Query q = em.createQuery("select c from Insurance c");
    	q.setFirstResult(start);
    	q.setMaxResults(start+page);
    	List<Insurance> out = new ArrayList<Insurance>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Insurance)q.getResultList().get(i));
    	}
    	return out;
    }
    
    public List<Insurance> getSearchInsuranceList(String str)
    {
    	String column="Concat(name,agency)";
    	String temp=tool.getQuery(str,column);
    	Query q = em.createQuery("select c from Insurance c where "+temp);
    	System.out.print("select c from Insurance c where "+temp);
    	q.setFirstResult(0);
    	int page=1;
    	q.setMaxResults(1+10);
    	List<Insurance> out = new ArrayList<Insurance>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Insurance)q.getResultList().get(i));
    	}
    	return out;
    }
    public long getCount() 
    {
    	Query q=em.createQuery("select COUNT(*) from Insurance");
    	long count=(long) q.getSingleResult();
    	return count;
    }

}
