package com.ust.Employee_info.service;

import com.ust.Employee_info.model.EmployeeClass;
import com.ust.Employee_info.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;


    public EmployeeClass addEmployee(EmployeeClass employeeClass) {
        EmployeeClass HashUtil = null;
        int hashedEmpid = HashUtil.hashInteger(employeeClass.getEmpid());
        employeeClass.setEmpid(hashedEmpid);
        return repo.save(employeeClass);

    }

    public List<EmployeeClass> addEmployees(List<EmployeeClass> employeeClass) {
        List<EmployeeClass> employeesWithHashedEmpid = employeeClass.stream()
            .map(employee -> {
                // Hash the empid before saving
                EmployeeClass HashUtil = null;
                int hashedEmpid = HashUtil.hashInteger(employee.getEmpid());
                employee.setEmpid(hashedEmpid);
                return employee;
            })
            .collect(Collectors.toList());

        return repo.saveAll(employeesWithHashedEmpid);
    }

    public EmployeeClass getEmployee(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        repo.deleteById(id);
        return ("Deleted employee with id "+ id);
    }

    public EmployeeClass updateEmployee(int id, EmployeeClass employeeClass) {
        EmployeeClass existingEmployee = repo.findById(id)
                .orElse(null);
        existingEmployee.setName(employeeClass.getName());
        existingEmployee.setBasicSalary(employeeClass.getBasicSalary());
        existingEmployee.setGrade(employeeClass.getGrade());
        return repo.save(existingEmployee);
    }
}
