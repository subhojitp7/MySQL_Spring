package com.jacksubhomysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.jacksubhomysql.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
