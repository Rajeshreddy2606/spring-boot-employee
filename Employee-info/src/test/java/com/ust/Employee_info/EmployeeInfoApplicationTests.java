package com.ust.Employee_info;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeInfoApplicationTests {
@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository repo;

	@Test
	void addEmployeeTest() {
		EmployeeClass user = new EmployeeClass();
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, employeeService.addEmployee(user));
	}

	@Test
	void addEmployeesTest() {
		List<EmployeeClass> employees = Stream.of(new EmployeeClass(1234, "John Smith", "50000.00", "A"),
				new EmployeeClass(5678, "Jane Doe", "45000.00", "B"),
				new EmployeeClass(9101, "Alice Johnson", "47000.00", "A"),
				new EmployeeClass(1121, "Bob Brown", "48000.00", "C")).toList();
		when(repo.saveAll(employees)).thenReturn(employees);
		assertEquals(employees, employeeService.addEmployees(employees));
	}

	@Test
	public void getEmployeeByIdTest() {
		int id = 1234;
		EmployeeClass employee = new EmployeeClass(376, "Danile", "31", "USA");
		when(repo.findById(id))
				.thenReturn(Optional.of(employee));
		assertEquals(employee, employeeService.getEmployee(id));
	}

	@Test
	public void deleteEmployeeTest() {
		EmployeeClass employee = new EmployeeClass(999, "Pranya", "33", "Pune");
		when(repo.existsById(employee.getEmpid())).thenReturn(true);
		employeeService.deleteEmployee(employee.getEmpid());
		verify(repo, times(1)).deleteById(employee.getEmpid());
	}


}
