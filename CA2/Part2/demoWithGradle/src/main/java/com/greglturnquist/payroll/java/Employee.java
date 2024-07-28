
package com.greglturnquist.payroll.java;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Employee {

	private @Id @GeneratedValue Long id; // <2>
	private String firstName;
	private String lastName;
	private String description;
	private int jobYears;
	private String email;



	public Employee(String firstName, String lastName, String description, int jobYears, String email) throws InstantiationException{
		if( areConstrutorArgumentsValid(firstName,lastName,description,jobYears) == false ) {
			throw (new InstantiationException("Invalid arguments"));
		}
		if (isValidEmail(email)==false) {
			throw (new InstantiationException("Invalid arguments"));
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.jobYears = jobYears;
		this.email = email;
	}

	public Employee() {}

	private boolean areConstrutorArgumentsValid(String firstName, String lastName, String description, int jobYears){
		if (firstName == null || firstName.isEmpty()){
			return false;
		}
		if(lastName == null || lastName.isEmpty()){
			return false;
		}
		if(description == null || description.isEmpty()){
			return false;
		}
		if(jobYears < 0 || jobYears > 40){
			return false;
		}
		return true;
	}

	  private boolean isValidEmail(String email) {
		  return email != null && email.contains("@");
	  }


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) &&
			Objects.equals(firstName, employee.firstName) &&
			Objects.equals(lastName, employee.lastName) &&
			Objects.equals(description, employee.description) &&
			Objects.equals(jobYears, employee.jobYears) &&
			Objects.equals(email, employee.email);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, firstName, lastName, description, jobYears);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getJobYears() {
		return this.jobYears;
	}

	public void setJobYears(int jobYears) {
		this.jobYears = jobYears;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}


	@Override
	public String toString() {
		return "Employee{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", description='" + description + '\'' +
			", jobYears='" + jobYears + '\'' +
			", email='" + email + '\'' +
			'}';
	}
}

