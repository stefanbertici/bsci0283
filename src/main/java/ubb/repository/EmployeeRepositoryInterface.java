package ubb.repository;

import java.util.List;

import ubb.controller.DidacticFunction;
import ubb.model.Employee;

public interface EmployeeRepositoryInterface {
	
	boolean addEmployee(Employee employee);
	void modifyEmployeeFunction(Employee employee, DidacticFunction newFunction);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria();
	Employee findEmployeeById(int idOldEmployee);

}
