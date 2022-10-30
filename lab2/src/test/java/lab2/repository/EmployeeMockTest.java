package lab2.repository;

import lab2.controller.DidacticFunction;
import lab2.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void givenNullEmployee_whenModifyEmployeeFunction_thenExitWithoutChanges() {
        employees.modifyEmployeeFunction(null, DidacticFunction.CONFERENTIAR);

        assertEquals(DidacticFunction.ASISTENT, employees.getEmployeeList().get(0).getFunction());
        assertEquals(DidacticFunction.LECTURER, employees.getEmployeeList().get(1).getFunction());
    }

    @Test
    void givenEmployeeWithIdExistingInListButNotOnIndexZero_whenModifyEmployeeFunction_thenChangeTheFunctionOfTheCorrectEmployee() {
        Employee customEmployeeWithId = new Employee();
        customEmployeeWithId.setId(1);

        employees.modifyEmployeeFunction(customEmployeeWithId, DidacticFunction.CONFERENTIAR);

        assertEquals(DidacticFunction.ASISTENT, employees.getEmployeeList().get(0).getFunction());
        assertEquals(DidacticFunction.CONFERENTIAR, employees.getEmployeeList().get(1).getFunction());
    }

    @Test
    void givenInvalidEmployeeWithIdZero_whenAddEmployee_thenReturnFalseAndDoNotAddEmployee() {
        Employee employee = new Employee("Stefan", "Bertici", "1234567891234", DidacticFunction.ASISTENT, 500d);
        employee.setId(0);
        boolean added = employees.addEmployee(employee);

        assertFalse(added);
        assertEquals(initialNumberOfEmployees, employees.getEmployeeList().size());
    }

    @Test
    void givenValidEmployeeWithIdOneAndSalaryOne_whenAddEmployee_thenReturnTrueAndAddEmployee() {
        Employee employee = new Employee("Stefan", "Bertici", "1234567891234", DidacticFunction.ASISTENT, 1d);
        employee.setId(1);
        boolean added = employees.addEmployee(employee);

        assertTrue(added);
        assertEquals(initialNumberOfEmployees + 1, employees.getEmployeeList().size());
    }

    @Test
    void givenValidEmployeeWithIdTwoAndSalaryTwo_whenAddEmployee_thenReturnTrueAndAddEmployee() {
        Employee employee = new Employee("Miclaus", "Jackson", "2345678912345", DidacticFunction.CONFERENTIAR, 2d);
        employee.setId(2);
        boolean added = employees.addEmployee(employee);

        assertTrue(added);
        assertEquals(initialNumberOfEmployees + 1, employees.getEmployeeList().size());
    }

    @Test
    void givenInvalidEmployeeWithIdOneAndSalaryZero_whenAddEmployee_thenReturnFalseAndDoNotAddEmployee() {
        Employee employee = new Employee("Stefan", "Bertici", "1234567891234", DidacticFunction.ASISTENT, 0d);
        employee.setId(1);
        boolean added = employees.addEmployee(employee);

        assertFalse(added);
        assertEquals(initialNumberOfEmployees, employees.getEmployeeList().size());
    }
}