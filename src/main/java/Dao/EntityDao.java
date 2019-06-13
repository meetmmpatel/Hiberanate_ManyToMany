package Dao;

import model.ReaderEntity;
import model.SubscriptionEntity;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

public class EntityDao {
  
  //Add subscription
  Set<SubscriptionEntity> subs = new HashSet<>();
  SubscriptionEntity subOne = new SubscriptionEntity();
  SubscriptionEntity subTwo = new SubscriptionEntity();
  
  
  //Add readers
  Set<ReaderEntity> readers = new HashSet<>();
  ReaderEntity readerOne = new ReaderEntity();
  ReaderEntity readerTwo = new ReaderEntity();
  
  
  public void writeEntity() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
	//Added Reader and Subs One
	subOne.setSubscriptionName("Entertainment");
	subs.add(subOne);
	
	readerOne.setEmail("demo-user1@mail.com");
	readerOne.setFirstName("demo");
	readerOne.setLastName("user");
	readers.add(readerOne);
	readerOne.setSubscriptions(subs);
	
	//Added Reader and Subs Two
	subTwo.setSubscriptionName("Horror");
	subs.add(subTwo);
	
	readerTwo.setEmail("demo-user2@mail.com");
	readerTwo.setFirstName("demo");
	readerTwo.setLastName("user");
	readers.add(readerTwo);
	readerTwo.setSubscriptions(subs);
	
	
	//Write the into database
	session.save(readerOne);
	session.save(readerTwo);
	
	//commit it
	session.getTransaction().commit();
	HibernateUtil.shutdown();
	
	
  }
  
  
}
