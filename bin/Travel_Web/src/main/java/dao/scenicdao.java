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

import entity.Hotel;
import entity.Scenic;
import tool.tool;

/**
 * Session Bean implementation class scenicdao
 */
@Stateless
@LocalBean
public class scenicdao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
	EntityManager em;
    public scenicdao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    	em=emf.createEntityManager();
    }

    public List<Scenic> getScenicList()
    {
    	Query q = em.createQuery("select c from Scenic c");
    	q.setFirstResult(1);
    	int page=1;
    	q.setMaxResults(1+page);
    	List<Scenic> out = new ArrayList<Scenic>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Scenic)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Scenic> getScenicList(int page)
    {
    	Query q = em.createQuery("select c from Scenic c");
    	q.setFirstResult(12);
    	q.setMaxResults(1+page);
    	List<Scenic> out = new ArrayList<Scenic>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Scenic)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Scenic> getScenicList(int start,int page)
    {
    	Query q = em.createQuery("select c from Scenic c");
    	q.setFirstResult(start);
    	q.setMaxResults(start+page);
    	List<Scenic> out = new ArrayList<Scenic>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Scenic)q.getResultList().get(i));
    	}
    	return out;
    }
    public long getCount() 
    {
    	Query q=em.createQuery("select COUNT(*) from Scenic");
    	long count=(long) q.getSingleResult();
    	return count;
    }
    
    public List<Scenic> getSearchScenicList(String str)
    {
    	String column="CONCAT(INTRO,CITY)";
    	String temp=tool.getQuery(str,column);
    	Query q = em.createQuery("select c from Scenic c where "+temp);
    	System.out.print("select c from Hotel c where "+temp);
    	q.setFirstResult(0);
    	int page=1;
    	q.setMaxResults(1+10);
    	List<Scenic> out = new ArrayList<Scenic>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Scenic)q.getResultList().get(i));
    	}
    	return out;
    }

}
