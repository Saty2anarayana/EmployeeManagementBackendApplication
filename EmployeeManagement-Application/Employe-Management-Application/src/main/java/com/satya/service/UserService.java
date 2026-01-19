package com.satya.service;

import java.util.List;

import com.satya.dto.EmployeeDto;

public interface UserService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
	
	void deleteEmployee(Long employeeId);

}
