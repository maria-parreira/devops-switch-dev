/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Greg Turnquist
 */

@Entity // <1>

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

	//Esta função em Java é a implementação do método equals da classe Object.
	//O método equals é usado para comparar dois objetos.
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


	//descrição do objeto numa string
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
// end::code[]
