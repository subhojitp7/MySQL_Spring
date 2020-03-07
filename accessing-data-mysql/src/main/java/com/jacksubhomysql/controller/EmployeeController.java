package com.jacksubhomysql.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacksubhomysql.employee.Employee;
import com.jacksubhomysql.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empServe;
	
	@RequestMapping("/employee")
	public List<Employee> getAllEmployee(){
		return empServe.getAllEmployee();
	}
	
	@RequestMapping("/employee/{empId}")
	public Optional<Employee> getEmployee(@PathVariable Integer empId) {
		return empServe.getEmployee(empId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employee")
	public @ResponseBody Employee addEmployee(@RequestBody Employee employee) {
		return empServe.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employee/{empId}")
	public @ResponseBody Employee updateEmployee(@PathVariable Integer empId, @RequestBody Map<String,String> body) {
		return empServe.updateEmployee(empId,body);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employee/{empId}")
	public void deleteEmployee(@PathVariable Integer empId) {
		empServe.deleteEmployee(empId);
	}

}
