package com.employee.management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/ems")
public class EmployeeController {

	static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;

	// displaying list of all employees
	@ApiOperation(value = "displaying list of all Employees", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of Employees") })
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	// displaying employee by id
	@GetMapping("/employees/{id}")
	@ApiOperation(value = "displaying Employee by Employee Id", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee details by Employee Id") })
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

	// inserting employee
	@PostMapping("/employees")
	@ApiOperation(value = "Create Employee in EMS", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	public void addEmployees(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	// updating employee by id
	@PutMapping("/employees/{id}")
	@ApiOperation(value = "Update Employee in EMS", httpMethod = "PUT")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	public void updateEmployee(@RequestBody Employee e, @PathVariable int id) {
		employeeService.updateEmployee(e, id);
	}

	// deleting all employees
	@DeleteMapping("/employees")
	@ApiOperation(value = "Delete All Employees", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	public void deleteAllEmployees() {
		employeeService.deleteAllEmployees();
	}

	// deleting employee by id
	@DeleteMapping("employees/{id}")
	@ApiOperation(value = "Delete Employee By Id", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	public void deleteEmployeeByID(@PathVariable int id) {
		employeeService.deleteEmployeeByID(id);
	}

}
