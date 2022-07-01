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

import entity.Line;
import entity.Line;
import entity.Ticket;
import tool.tool;

/**
 * Session Bean implementation class Linedao
 */
@Stateless
@LocalBean
public class linedao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
	EntityManager em;
    public linedao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    	em=emf.createEntityManager();
    }
    public Line findLine (long id)
    {
    	Line customer = null;
    	
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	ut.begin();
    	customer=em.find(Line.class, id);
    	em.close();
    	return customer;
    }

    public List<Line> getLineList()
    {
    	Query q = em.createQuery("select c from Line c");
    	q.setFirstResult(1);
    	int page=1;
    	q.setMaxResults(1+page);
    	List<Line> out = new ArrayList<Line>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Line)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Line> getLineList(int page)
    {
    	Query q = em.createQuery("select c from Line c");
    	q.setFirstResult(12);
    	q.setMaxResults(1+page);
    	List<Line> out = new ArrayList<Line>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Line)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Line> getLineList(int start,int page)
    {
    	Query q = em.createQuery("select c from Line c");
    	q.setFirstResult(start);
    	q.setMaxResults(start+page);
    	List<Line> out = new ArrayList<Line>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Line)q.getResultList().get(i));
    	}
    	return out;
    }
    
    public List<Line> getSearchLineList(String str)
    {
    	String column="concat(T_CITY,CONCAT(INTRO,R_CITY))";
    	String temp=tool.getQuery(str,column);
    	Query q = em.createQuery("select c from Line c where "+temp);
    	System.out.print("select c from Hotel c where "+temp);
    	q.setFirstResult(0);
    	int page=1;
    //	q.setMaxResults(1+10);
    	List<Line> out = new ArrayList<Line>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Line)q.getResultList().get(i));
    	}
    	return out;
    }
    
    public long getCount() 
    {
    	Query q=em.createQuery("select COUNT(*) from Line");
    	long count=(long) q.getSingleResult();
    	return count;
    }

}
