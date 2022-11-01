package ubb.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ubb.model.AgeCriteria;
import ubb.controller.DidacticFunction;
import ubb.model.Employee;
import ubb.validator.EmployeeException;
import ubb.validator.EmployeeValidator;
import ubb.model.SalaryCriteria;

public class EmployeeImpl implements EmployeeRepositoryInterface {

	private static final String ERROR_WHILE_READING_MSG = "Error while reading: ";
	private static final String EMPLOYEE_DB_FILE = "employeeDB/employees.txt";
	private final EmployeeValidator employeeValidator = new EmployeeValidator();
	private List<Employee> employeeList = new ArrayList<>();
	
	public EmployeeImpl() {
		employeeList = loadEmployeesFromFile();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		employee.setId(employeeList.size());
		if (employeeValidator.isValid(employee)) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(EMPLOYEE_DB_FILE, true))) {
				bw.write(employee.toString());
				bw.newLine();
				employeeList.add(employee);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void modifyEmployeeFunction(Employee oldEmployee, DidacticFunction newFunction) {
		oldEmployee.setFunction(newFunction);
	}
	
	private List<Employee> loadEmployeesFromFile() {
		final List<Employee> employees = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(EMPLOYEE_DB_FILE));){
			readEmployees(employees, br);
		} catch (IOException e) {
			System.err.println(ERROR_WHILE_READING_MSG + e);
		} 
		return employees;
	}

	private static void readEmployees(List<Employee> employees, BufferedReader br) throws IOException {
		String line;
		int counter = 0;
		while ((line = br.readLine()) != null) {
			try {
				final Employee employee = Employee.getEmployeeFromString(line, counter);
				employees.add(employee);
				counter++;
			} catch (EmployeeException ex) {
				System.err.println(ERROR_WHILE_READING_MSG + ex.toString());
			}
		}
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByCriteria() {
		List<Employee> employeeSortedList = new ArrayList<>(employeeList);
		Collections.copy(employeeSortedList, employeeList);
		Collections.sort(employeeSortedList, new AgeCriteria());
		Collections.sort(employeeSortedList, new SalaryCriteria());
		return employeeSortedList;
	}

	@Override
	public Employee findEmployeeById(int idOldEmployee) {
		for (Employee employee : employeeList) {
			if (employee.getId() == idOldEmployee) {
				return employee;
			}
		}
		return null;
	}

}
