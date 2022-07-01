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

import entity.Ticket;
import entity.Hotel;
import entity.Ticket;
import tool.tool;

/**
 * Session Bean implementation class ticketdao
 */
@Stateless
@LocalBean
public class ticketdao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
	EntityManager em;
    public ticketdao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    	em=emf.createEntityManager();
    }
    public Ticket findTicket (long id)
    {
    	Ticket customer = null;
    	
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	ut.begin();
    	customer=em.find(Ticket.class, id);
    	em.close();
    	return customer;
    }
    public List<Ticket> getTicketList()
    {
    	Query q = em.createQuery("select c from Ticket c");
    	q.setFirstResult(1);
    	int page=1;
    	q.setMaxResults(1+page);
    	List<Ticket> out = new ArrayList<Ticket>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Ticket)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Ticket> getTicketList(int page)
    {
    	Query q = em.createQuery("select c from Ticket c");
    	q.setFirstResult(12);
    	q.setMaxResults(1+page);
    	List<Ticket> out = new ArrayList<Ticket>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Ticket)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Ticket> getTicketList(int start,int page)
    {
    	Query q = em.createQuery("select c from Ticket c");
    	q.setFirstResult(start);
    	q.setMaxResults(start+page);
    	List<Ticket> out = new ArrayList<Ticket>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Ticket)q.getResultList().get(i));
    	}
    	return out;
    }
    public List<Ticket> getSearchTicketList(String str)
    {
    	String column="concat(T_CITY,CONCAT(TYPE,R_CITY))";
    	String temp=tool.getQuery(str,column);
    	Query q = em.createQuery("select c from Ticket c where "+temp);
    	System.out.print("select c from Hotel c where "+temp);
    	q.setFirstResult(0);
    	int page=1;
    //	q.setMaxResults(1+10);
    	List<Ticket> out = new ArrayList<Ticket>();
    	q.getResultList();
    	for(int i=0;i<q.getResultList().size();i++)
    	{
    		out.add((Ticket)q.getResultList().get(i));
    	}
    	return out;
    }
    public long getCount() 
    {
    	Query q=em.createQuery("select COUNT(*) from Ticket");
    	long count=(long) q.getSingleResult();
    	return count;
    }

}
