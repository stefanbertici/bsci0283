package lab2.repository;

import java.util.List;

import lab2.controller.DidacticFunction;
import lab2.model.Employee;

public interface EmployeeRepositoryInterface {
	
	boolean addEmployee(Employee employee);
	void modifyEmployeeFunction(Employee employee, DidacticFunction newFunction);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria();
	Employee findEmployeeById(int idOldEmployee);

}
