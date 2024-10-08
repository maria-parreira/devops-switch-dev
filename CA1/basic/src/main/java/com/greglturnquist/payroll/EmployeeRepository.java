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

import org.springframework.data.repository.CrudRepository;

/**
 * @author Greg Turnquist
 */

//Another key piece of a Spring Data REST application is a corresponding repository definition, as follows:

public interface EmployeeRepository extends CrudRepository<Employee, Long> { // <1>

}

/*
The repository extends Spring Data Commons' CrudRepository and plugs in the type of the domain object and its primary key
That is all that is needed! In fact, you need not even annotate interface if it is top-level and visible.
If you use your IDE and open up CrudRepository, you will find a collection of pre-defined methods.
 */



