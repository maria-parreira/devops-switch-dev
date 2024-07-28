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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */

// To work with this application, you need to pre-load it with some data, as follows:

@Component // <1>

public class DatabaseLoader implements CommandLineRunner { // <2>

	private final EmployeeRepository repository;

	@Autowired // <3>
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	//estou no servidor(codigo java) a guardar dados
	//o cliente vai fazer uma requisição e buscar ao servidor a informação que esta na base de dados.
	@Override
	public void run(String... strings) throws Exception { // <4>
		this.repository.save(new Employee("Frodo", "Baggins", "ring bearer",5,"123@gmail.com"));
		this.repository.save(new Employee("Bilbo", "Baggins", "burglar",3,"abc@gmail.com"));
		this.repository.save(new Employee("Maria", "Parreira", "student",1,"maria@gmail.com"));
	}
}

/*
This class is marked with Spring’s @Component annotation so that it is automatically picked up by @SpringBootApplication.
It implements Spring Boot’s CommandLineRunner so that it gets run after all the beans are created and registered.
It uses constructor injection and autowiring to get Spring Data’s automatically created EmployeeRepository.
The run() method is invoked with command line arguments, loading up your data.
 */




