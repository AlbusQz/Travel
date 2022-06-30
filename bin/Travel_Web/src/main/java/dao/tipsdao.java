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

import entity.Tip;
import tool.tool;

/**
 * Session Bean implementation class Tipdao
 */
@Stateless
@LocalBean
public class tipsdao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
	EntityManager em;
    public tipsdao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    	em=emf.createEntityManager();
    }

    public List<Tip> getTipList()
    {
    	Query q = em.createQuery("select c from Tips c");
    	q.setFirstResult(1);
    	int page=1;
    	q.setMaxResults(1+page);
    	List<Tip> out = new ArrayList<Tip>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Tip)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Tip> getTipList(int page)
    {
    	Query q = em.createQuery("select c from Tips c");
    	q.setFirstResult(12);
    	q.setMaxResults(1+page);
    	List<Tip> out = new ArrayList<Tip>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Tip)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Tip> getTipList(int start,int page)
    {
    	Query q = em.createQuery("select c from Tips c");
    	q.setFirstResult(start);
    	q.setMaxResults(start+page);
    	List<Tip> out = new ArrayList<Tip>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Tip)q.getResultList().get(i));
    	}
    	return out;
    }
    
    public List<Tip> getSearchTipList(String str)
    {
    	String column="concat(T_CITY,CONCAT(C_ID,TEXT))";
    	String temp=tool.getQuery(str,column);
    	Query q = em.createQuery("select c from Tip c where "+temp);
    	q.setFirstResult(0);
    	int page=1;
     	List<Tip> out = new ArrayList<Tip>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Tip)q.getResultList().get(i));
    	}
    	return out;
    }
    
    public long getCount() 
    {
    	Query q=em.createQuery("select COUNT(*) from Tips");
    	long count=(long) q.getSingleResult();
    	return count;
    }

}
