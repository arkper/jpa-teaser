package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;


@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    
    @Column(name="date_hired")
    private Date hiredOn;

    @Column(name="salary")
    private float salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

	public Date getHiredOn() {
		return hiredOn;
	}

	public void setHiredOn(Date hiredOn) {
		this.hiredOn = hiredOn;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
    
	
	public String toString() {
		return "{'id':" + id + 
				",'lastName':" + lastName + 
				",'firstName':" + firstName +
				",'hiredOn':" +  getHiredOn() +
				",'salary':" +  salary +
				"}";
	}
    
}