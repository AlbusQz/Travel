package dao;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import entity.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
/**
 * Session Bean implementation class historydao
 */
@Stateless
@LocalBean
public class historydao {

	@PersistenceUnit(unitName="Travel_Web")
	private EntityManagerFactory emf;
	@Resource
	EntityTransaction ut;
    public historydao() {
    	emf = Persistence.createEntityManagerFactory("Travel_Web");
    }
    public Date getDate()
    {
    	java.util.Date uDate=new java.util.Date();
    	return new java.sql.Date(uDate.getTime());
    }
    
    public void addHis(History his)
    {
    	his.setCtime(new java.util.Date());
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		em.joinTransaction();
    		em.persist(his);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void buyHotel(Hotel hotel,Customer customer)
    {
    	History his = new History();
    	his.setCtime(new java.util.Date());
    	his.setCustomer(customer);
    	his.setPId(hotel.getId());
    	his.setPrice(hotel.getRooms().get(0).getPrice());
    	his.setType("Hotel");
    	his.setState("已支付未发货");
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		em.joinTransaction();
    		em.persist(his);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void buyTicket(Ticket ticket,Customer customer)
    {
    	History his = new History();
    	his.setCtime(new java.util.Date());
    	his.setCustomer(customer);
    	his.setPId(ticket.getId());
    	his.setPrice(ticket.getPrice());
    	his.setType("Ticket");
    	his.setState("已支付未发货");
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		em.joinTransaction();
    		em.persist(his);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void buyLine(Line line,Customer customer)
    {
    	History his = new History();
    	his.setCtime(new java.util.Date());
    	his.setCustomer(customer);
    	his.setPId(line.getId());
    	his.setPrice(line.getPrice());
    	his.setType("Line");
    	his.setState("已支付未发货");
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		em.joinTransaction();
    		em.persist(his);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void buyScenic(Scenic scenic,Customer customer)
    {
    	History his = new History();
    	his.setCtime(new java.util.Date());
    	his.setCustomer(customer);
    	his.setPId(scenic.getId());
    	his.setPrice(scenic.getPrice());
    	his.setType("Scenic");
    	his.setState("已支付未发货");
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		em.joinTransaction();
    		em.persist(his);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void buyInsurance(Insurance i,Customer customer)
    {
    	History his = new History();
    	his.setCtime(new java.util.Date());
    	his.setCustomer(customer);
    	his.setPId(i.getId());
    	
    	his.setType("Insurance");
    	his.setPrice(i.getPrice());
    	his.setState("已支付未发货");
    	EntityManager em=emf.createEntityManager();
    	ut=em.getTransaction();
    	try {
    		ut.begin();
    		em.joinTransaction();
    		em.persist(his);
    		ut.commit();
    		em.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public List<History> findHistorybyid (long id)
    {
    	EntityManager em=emf.createEntityManager();
    	Query q = em.createQuery("select c from History c where C_ID= "+id);
    	List<History> his=q.getResultList();
    	em.close();
    	
    	return his;
    }
}
