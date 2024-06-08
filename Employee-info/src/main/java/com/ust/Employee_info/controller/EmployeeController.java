package com.ust.Employee_info.controller;

import com.ust.Employee_info.model.EmployeeClass;
import com.ust.Employee_info.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    private EmployeeClass addEmployee(@RequestBody EmployeeClass employeeClass){
        return employeeService.addEmployee(employeeClass);
    }

    @PostMapping("/addemployees")
    private List<EmployeeClass> addEmployees(@RequestBody List<EmployeeClass> employeeClass){
        return employeeService.addEmployees(employeeClass);
    }

    @GetMapping("/getemployee/{id}")
    public EmployeeClass getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/deleteemployeeg/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateemployee/{id}")
    public EmployeeClass updateEmployee(@PathVariable int id,@RequestBody EmployeeClass employeeClass){
        return employeeService.updateEmployee(id, employeeClass);
    }
}