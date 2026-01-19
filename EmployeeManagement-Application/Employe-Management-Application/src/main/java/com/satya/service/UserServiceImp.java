package com.satya.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.satya.dto.EmployeeDto;
import com.satya.entity.UserEntity;
import com.satya.exception.ResourceNotFoundException;
import com.satya.mapper.EmployeeMapper;
import com.satya.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		UserEntity employee = EmployeeMapper.mapToEmployee(employeeDto);
		UserEntity savedEmployee=userRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		UserEntity employee = userRepository.findById(employeeId)
				.orElseThrow(()->
				new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<UserEntity> employees=userRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		UserEntity employee =userRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		UserEntity updatedEmployeeObj = userRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		UserEntity employee = userRepository.findById(employeeId)
				.orElseThrow(()->
				new ResourceNotFoundException("Employee is not exist with given id :" + employeeId)
				);
		userRepository.deleteById(employeeId);
		
	}

}
