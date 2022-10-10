package lab2.model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgeCriteriaTest {

    private static Employee firstEmployee;
    private static Employee secondEmployee;
    private static AgeCriteria ageCriteria;

    @BeforeClass
    public static void setup() {
        firstEmployee = new Employee();
        secondEmployee = new Employee();
        ageCriteria = new AgeCriteria();
    }

    @Test
    public void givenFirstEmployeeHasCnpWithOlderBirthDate_whenCompare_thenResultIsGreaterThanZero() {
        firstEmployee.setCnp("1930312000000");
        secondEmployee.setCnp("2930112000000");
        int result = ageCriteria.compare(firstEmployee, secondEmployee);

        assertTrue(result < 0);
    }

    @Test
    public void givenSecondEmployeeHasCnpWithOlderBirthDate_whenCompare_thenResultIsLessThanZero() {
        firstEmployee.setCnp("1930312000000");
        secondEmployee.setCnp("2930512000000");
        int result = ageCriteria.compare(firstEmployee, secondEmployee);

        assertTrue(result > 0);
    }

    @Test
    public void givenEmployeesWithSameCnpBirthDate_whenCompare_thenResultIsZero() {
        firstEmployee.setCnp("1931111000000");
        secondEmployee.setCnp("2931111000000");
        int result = ageCriteria.compare(firstEmployee, secondEmployee);

        assertEquals(0, result);
    }
}