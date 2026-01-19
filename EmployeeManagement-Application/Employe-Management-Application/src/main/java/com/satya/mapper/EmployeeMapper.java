package com.satya.mapper;

import com.satya.dto.EmployeeDto;
import com.satya.entity.UserEntity;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(UserEntity userEntity) {
		return new EmployeeDto(
				userEntity.getId(),
				userEntity.getFirstName(),
				userEntity.getLastName(),
				userEntity.getEmail()
				);
	}
	
	public static UserEntity mapToEmployee(EmployeeDto employeeDto) {
		return new UserEntity(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
	}

}
