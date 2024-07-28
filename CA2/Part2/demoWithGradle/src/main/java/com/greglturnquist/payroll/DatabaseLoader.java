
package com.greglturnquist.payroll.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component

public class DatabaseLoader implements CommandLineRunner { // <2>

	private final EmployeeRepository repository;

	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception { // <4>
		this.repository.save(new Employee("Frodo", "Baggins", "ring bearer",5,"123@gmail.com"));
		this.repository.save(new Employee("Bilbo", "Baggins", "burglar",3,"abc@gmail.com"));
		this.repository.save(new Employee("Maria", "Parreira", "student",1,"maria@gmail.com"));
	}
}





