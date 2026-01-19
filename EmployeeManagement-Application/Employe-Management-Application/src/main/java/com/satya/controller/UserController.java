package com.satya.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.dto.EmployeeDto;
import com.satya.service.UserService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//Add Employee REST API
	@PostMapping()
	public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = userService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	//Get Employee By Id REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = userService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employeeDto,HttpStatus.OK);
	}
	
	// Get All Employees API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployees(){
		List<EmployeeDto> employees = userService.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
// Update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id")Long employeeId,@RequestBody EmployeeDto updateEmployee){
		EmployeeDto employeeDto = userService.updateEmployee(employeeId, updateEmployee);
		return new ResponseEntity<>(employeeDto,HttpStatus.OK);
	}
	
	// Delete Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long employeeId){
	      userService.deleteEmployee(employeeId);
		return  ResponseEntity.ok("Employee deleted successfully !");
	}
	

}
