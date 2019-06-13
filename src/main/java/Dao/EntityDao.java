package Dao;

import model.ReaderEntity;
import model.SubscriptionEntity;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

public class EntityDao {
  
  //Add subscription
  SubscriptionEntity subOne = new SubscriptionEntity();
  SubscriptionEntity subTwo = new SubscriptionEntity();
  Set<SubscriptionEntity> subs = new HashSet<SubscriptionEntity>();
  
  
  //Add readers
  ReaderEntity readerOne = new ReaderEntity();
  ReaderEntity readerTwo = new ReaderEntity();
  Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
  
  
  
  public void writeEntity() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
	subOne.setSubscriptionName("Entertainment");
	subTwo.setSubscriptionName("Horror");
	
	subs.add(subOne);
	subs.add(subTwo);
	
	readerOne.setEmail("demo-user1@mail.com");
	readerOne.setFirstName("demo");
	readerOne.setLastName("user");
	
	readerTwo.setEmail("demo-user2@mail.com");
	readerTwo.setFirstName("demo");
	readerTwo.setLastName("user");
	
	
	readers.add(readerOne);
	readers.add(readerTwo);
	
	readerOne.setSubscriptions(subs);
	readerTwo.setSubscriptions(subs);
	
	session.save(readerOne);
	session.save(readerTwo);
	
	session.getTransaction().commit();
	HibernateUtil.shutdown();
	
	
  }
  
  
}
