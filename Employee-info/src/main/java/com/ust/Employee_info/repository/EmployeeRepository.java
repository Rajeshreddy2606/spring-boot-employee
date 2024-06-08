package com.ust.Employee_info.repository;

import com.ust.Employee_info.model.EmployeeClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeClass,Integer> {


}
