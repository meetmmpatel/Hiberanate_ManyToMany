package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity(name = "SubscriptionEntity")
@Table(name = "Subscription",
		
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "subscription_Id")})
public class Subscription implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscription_Id", unique = true, nullable = false)
  private long subscriptionId;
  
  @Column(name = "sub_Name", unique = true, nullable = false, length = 255)
  private String subscriptionName;
  
  @Column(name = "sub_Date", nullable = false)
  private Date subscriptionDate;
  
  @ManyToMany(mappedBy = "Subscription")
  private Set<Reader> readerSet;
  
  public Subscription() {
  }
  
  public Subscription(String subscriptionName, Date subscriptionDate, Set<Reader> readerSet) {
	this.subscriptionName = subscriptionName;
	this.subscriptionDate = subscriptionDate;
	this.readerSet = readerSet;
  }
  
  public long getSubscriptionId() {
	return subscriptionId;
  }
  
  public void setSubscriptionId(long subscriptionId) {
	this.subscriptionId = subscriptionId;
  }
  
  public String getSubscriptionName() {
	return subscriptionName;
  }
  
  public void setSubscriptionName(String subscriptionName) {
	this.subscriptionName = subscriptionName;
  }
  
  public Date getSubscriptionDate() {
	return subscriptionDate;
  }
  
  public void setSubscriptionDate(Date subscriptionDate) {
	this.subscriptionDate = subscriptionDate;
  }
  
  public Set<Reader> getReaderSet() {
	return readerSet;
  }
  
  public void setReaderSet(Set<Reader> readerSet) {
	this.readerSet = readerSet;
  }
  
  @Override
  public String toString() {
	return "Subscription{" +
			"subscriptionId=" + subscriptionId +
			", subscriptionName='" + subscriptionName + '\'' +
			", subscriptionDate=" + subscriptionDate +
			", readerSet=" + readerSet +
			'}';
  }
}
