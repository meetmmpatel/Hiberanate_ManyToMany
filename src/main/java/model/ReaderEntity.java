package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * The type Reader entity.
 */
@Entity(name = "ReaderEntity")
@Table(name = "READER", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "EMAIL")})

public class ReaderEntity implements Serializable {
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  private Integer readerId;
  
  @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
  private String email;
  
  @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
  private String firstName;
  
  @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
  private String lastName;
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "READER_SUBSCRIPTIONS", joinColumns = {@JoinColumn(referencedColumnName = "ID")}
		  , inverseJoinColumns = {@JoinColumn(referencedColumnName = "ID")})
  private Set<SubscriptionEntity> subscriptions;
  
  
  /**
   * Gets reader id.
   *
   * @return the reader id
   */
  public Integer getReaderId() {
	return readerId;
  }
  
  /**
   * Sets reader id.
   *
   * @param readerId the reader id
   */
  public void setReaderId(Integer readerId) {
	this.readerId = readerId;
  }
  
  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
	return email;
  }
  
  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
	this.email = email;
  }
  
  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
	return firstName;
  }
  
  /**
   * Sets first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }
  
  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
	return lastName;
  }
  
  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) {
	this.lastName = lastName;
  }
  
  /**
   * Gets subscriptions.
   *
   * @return the subscriptions
   */
  public Set<SubscriptionEntity> getSubscriptions() {
	return subscriptions;
  }
  
  /**
   * Sets subscriptions.
   *
   * @param subscriptions the subscriptions
   */
  public void setSubscriptions(Set<SubscriptionEntity> subscriptions) {
	this.subscriptions = subscriptions;
  }
  
  @Override
  public String toString() {
	return "ReaderEntity{" +
			"readerId=" + readerId +
			", email='" + email + '\'' +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", subscriptions=" + subscriptions +
			'}';
  }
}
