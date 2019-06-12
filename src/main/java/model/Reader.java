package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "ReaderEntity")
@Table(name = "Reader", uniqueConstraints = {
		@UniqueConstraint(columnNames = "reader_Id"),
		@UniqueConstraint(columnNames = "Email")})

public class Reader implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reader_Id", unique = true, nullable = false)
  private long readId;
  
  @Column(name = "Email", unique = true, nullable = false, length = 50)
  private String email;
  
  @Column(name = "first_name", unique = false, nullable = false, length = 100)
  private String firstName;
  
  @Column(name = "last_name", unique = false, nullable = false, length = 100)
  private String lastName;
  
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "Reader_Subscription", joinColumns =
		  {@JoinColumn(referencedColumnName = "reader_Id")}
		  , inverseJoinColumns =
		  {@JoinColumn(referencedColumnName = "subscription_Id")})
  private Set<Subscription> subscriptions;
  
  public Reader() {
  }
  
  public Reader(String email, String firstName, String lastName, Set<Subscription> subscriptions) {
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.subscriptions = subscriptions;
  }
  
  public long getReadId() {
	return readId;
  }
  
  public void setReadId(long readId) {
	this.readId = readId;
  }
  
  public String getEmail() {
	return email;
  }
  
  public void setEmail(String email) {
	this.email = email;
  }
  
  public String getFirstName() {
	return firstName;
  }
  
  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }
  
  public String getLastName() {
	return lastName;
  }
  
  public void setLastName(String lastName) {
	this.lastName = lastName;
  }
  
  public Set<Subscription> getSubscriptions() {
	return subscriptions;
  }
  
  public void setSubscriptions(Set<Subscription> subscriptions) {
	this.subscriptions = subscriptions;
  }
  
  @Override
  public String toString() {
	return "Reader{" +
			"readId=" + readId +
			", email='" + email + '\'' +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", subscriptions=" + subscriptions +
			'}';
  }
}
