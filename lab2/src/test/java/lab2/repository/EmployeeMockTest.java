package lab2.repository;

import lab2.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lab2.controller.DidacticFunction.ASISTENT;
import static lab2.controller.DidacticFunction.CONFERENTIAR;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {

    private EmployeeMock employees;
    private int initialNumberOfEmployees;

    @BeforeEach
    public void setup() {
        employees = new EmployeeMock();
        initialNumberOfEmployees = employees.getEmployeeList().size();
    }

    @Test
    void givenInvalidEmployeeWithIdZero_whenAddEmployee_thenReturnFalseAndDoNotAddEmployee() {
        Employee employee = new Employee("Stefan", "Bertici", "1234567891234", ASISTENT, 500d);
        employee.setId(0);
        boolean added = employees.addEmployee(employee);

        assertFalse(added);
        assertEquals(initialNumberOfEmployees, employees.getEmployeeList().size());
    }

    @Test
    void givenValidEmployeeWithIdOneAndSalaryOne_whenAddEmployee_thenReturnTrueAndAddEmployee() {
        Employee employee = new Employee("Stefan", "Bertici", "1234567891234", ASISTENT, 1d);
        employee.setId(1);
        boolean added = employees.addEmployee(employee);

        assertTrue(added);
        assertEquals(initialNumberOfEmployees + 1, employees.getEmployeeList().size());
    }

    @Test
    void givenValidEmployeeWithIdTwoAndSalaryTwo_whenAddEmployee_thenReturnTrueAndAddEmployee() {
        Employee employee = new Employee("Miclaus", "Jackson", "2345678912345", CONFERENTIAR, 2d);
        employee.setId(2);
        boolean added = employees.addEmployee(employee);

        assertTrue(added);
        assertEquals(initialNumberOfEmployees + 1, employees.getEmployeeList().size());
    }

    @Test
    void givenInvalidEmployeeWithIdOneAndSalaryZero_whenAddEmployee_thenReturnFalseAndDoNotAddEmployee() {
        Employee employee = new Employee("Stefan", "Bertici", "1234567891234", ASISTENT, 0d);
        employee.setId(1);
        boolean added = employees.addEmployee(employee);

        assertFalse(added);
        assertEquals(initialNumberOfEmployees, employees.getEmployeeList().size());
    }
}