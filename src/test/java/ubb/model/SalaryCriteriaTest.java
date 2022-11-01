package ubb.model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalaryCriteriaTest {

    private static Employee firstEmployee;
    private static Employee secondEmployee;
    private static SalaryCriteria salaryCriteria;

    @BeforeClass
    public static void setup() {
        firstEmployee = new Employee();
        secondEmployee = new Employee();
        salaryCriteria = new SalaryCriteria();
    }

    @Test
    public void givenFirstEmployeeHasBiggerSalary_whenCompare_thenResultIsGreaterThanZero() {
        firstEmployee.setSalary(2000.0);
        secondEmployee.setSalary(1000.0);
        int result = salaryCriteria.compare(firstEmployee, secondEmployee);

        assertTrue(result < 0);
    }

    @Test
    public void givenSecondEmployeeHasBiggerSalary_whenCompare_thenResultIsLessThanZero() {
        firstEmployee.setSalary(1000.0);
        secondEmployee.setSalary(2000.0);
        int result = salaryCriteria.compare(firstEmployee, secondEmployee);

        assertTrue(result > 0);
    }

    @Test
    public void givenEmployeesWithSameCnpBirthDate_whenCompare_thenResultIsZero() {
        firstEmployee.setSalary(1500.0);
        secondEmployee.setSalary(1500.0);
        int result = salaryCriteria.compare(firstEmployee, secondEmployee);

        assertEquals(0, result);
    }
}