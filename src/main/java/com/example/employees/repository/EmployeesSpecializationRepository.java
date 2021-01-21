package com.example.employees.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employees.entity.EmployeesSpecialization;
import com.example.employees.entity.EmployeesSpecializationIdentity;

@Repository
public interface EmployeesSpecializationRepository extends JpaRepository<EmployeesSpecialization, EmployeesSpecializationIdentity> {

	List<EmployeesSpecialization> findByEmployeeId(Long employeeID);
	
	@Transactional    
	@Modifying
	@Query(value="DELETE FROM employees_specialization WHERE employee_id=?1 and specialization=?2", nativeQuery = true)
	void deleteBySpecialization(String employeeId,String specialization);

}
