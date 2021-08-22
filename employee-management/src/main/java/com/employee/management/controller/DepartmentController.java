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

import com.employee.management.model.Department;
import com.employee.management.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/ems")
@Api(value = "Department Resource", description = "Department CRUD Operations")
public class DepartmentController {

	static final Logger logger = LogManager.getLogger(DepartmentController.class.getName());

	@Autowired
	private DepartmentService departmentService;

	// Displaying list of all department
	@ApiOperation(value = "displaying list of all department", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of departments") })
	@GetMapping("/departments")
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartments();
	}

	// Displaying department by id
	@GetMapping("/departments/{id}")
	@ApiOperation(value = "displaying department by department Id", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Department details by department Id") })
	public Department getDepartment(@PathVariable int id) {
		return departmentService.getDepartment(id);
	}

	// Creating Department
	@PostMapping("/departments")
	@ApiOperation(value = "Create Department in EMS", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	public void addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
	}

	// Updating department by id
	@PutMapping("/departments/{id}")
	@ApiOperation(value = "Update Department in EMS", httpMethod = "PUT")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	public void updateDepartment(@RequestBody Department d, @PathVariable int id) {
		departmentService.updateDepartment(d, id);
	}

	// Deleting all department
	@DeleteMapping("/departments")
	@ApiOperation(value = "Delete All Departments", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	public void deleteAllDepartments() {
		departmentService.deleteAllDepartment();
	}

	// Deleting department by id
	@DeleteMapping("departments/{id}")
	@ApiOperation(value = "Delete Department By Id", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	public void deleteDepartmentByID(@RequestBody Department d, @PathVariable int id) {
		departmentService.deleteDepartmentByID(id);
	}

}
