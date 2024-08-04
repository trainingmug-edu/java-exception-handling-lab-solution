package com.trainingmug.employee.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeeTest {

    @Test
    @Order(1)
    @DisplayName("Test Employee class should be present in com.trainingmug.employee package")
    void testEmployeeClassShouldBePresent() {
        assertDoesNotThrow(() -> {
            Class.forName("com.trainingmug.employee.domain.Employee");
            }, "Employee class should be present");
    }


    @Test
    @Order(2)
    @DisplayName("Should create the fields in Employee class with the appropriate Type")
    void testVariablesInEmployeeShouldBePresent() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.employee.domain.Employee");
            assertFieldIsPrivate(employeeClass, "empId", long.class);
            assertFieldIsPrivate(employeeClass, "name", String.class);
            assertFieldIsPrivate(employeeClass, "designation", String.class);
            assertFieldIsPrivate(employeeClass, "grossSalary", float.class);
            assertFieldIsPrivate(employeeClass, "travellingAllowances", float.class);
            assertFieldIsPrivate(employeeClass, "federalTax", float.class);
            assertFieldIsPrivate(employeeClass, "stateTax", float.class);
            assertFieldIsPrivate(employeeClass, "incrementPercentage", float.class);
            assertFieldIsPrivate(employeeClass, "bankAccountNo",String.class);

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        }
    }

    private void assertFieldIsPrivate(Class<?> clazz, String fieldName, Class<?> fieldType) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            assertEquals(fieldType, field.getType(), "Field " + fieldName + " should be of type " + fieldType.getSimpleName());
            assertTrue(Modifier.isPrivate(field.getModifiers()), "Field " + fieldName + " should be public");
        } catch (NoSuchFieldException e) {
            fail("Field " + fieldName + " should be present in the class " + clazz.getSimpleName());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Should have Employee() no-arg constructor")
    public void testEmployeeConstructor() {

        try {
            Class<?> clazz = Class.forName("com.trainingmug.employee.domain.Employee");
            Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();
            assertNotNull(noArgConstructor, "Employee() No-arg constructor should be present");
            assertTrue(Modifier.isPublic(noArgConstructor.getModifiers()), "No-arg constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + "com.trainingmug.employee.d.Employee" + " does not exist");
        } catch (NoSuchMethodException e) {
            fail("Employee() No-arg constructor not found in class " + "com.trainingmug.employee.d.Employee");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test Employee constructor initialization")
    void testEmployeeConstructorInitialization() {
        // Arrange
        long empId = 1234;
        String name = "John Doe";
        String designation = "Software Engineer";
        float grossSalary = 5000.0F;
        float travellingAllowances = 200.0F;
        float federalTax = 300.0F;
        float stateTax = 100.0F;
        float incrementPercentage = 5.0F;
        String bankAccountNo = "1234567890";

        int initialEmployeeCount = Employee.getEmployeeCount();

        // Act
        Employee employee = new Employee(empId, name, designation, grossSalary, travellingAllowances,
                federalTax, stateTax, incrementPercentage, bankAccountNo);

        // Assert
        assertAll("Employee Constructor",
                () -> assertEquals(empId, employee.getEmpId(), "Employee ID should match"),
                () -> assertEquals(name, employee.getName(), "Name should match"),
                () -> assertEquals(designation, employee.getDesignation(), "Designation should match"),
                () -> assertEquals(grossSalary, employee.getGrossSalary(), "Gross Salary should match"),
                () -> assertEquals(travellingAllowances, employee.getTravellingAllowances(), "Travelling Allowances should match"),
                () -> assertEquals(federalTax, employee.getFederalTax(), "Federal Tax should match"),
                () -> assertEquals(stateTax, employee.getStateTax(), "State Tax should match"),
                () -> assertEquals(incrementPercentage, employee.getIncrementPercentage(), "Increment Percentage should match"),
                () -> assertEquals(bankAccountNo, employee.getBankAccountNo(), "Bank Account No should match")
        );

        // Check if employeeCount is incremented
        assertEquals(initialEmployeeCount + 1, Employee.getEmployeeCount(), "Employee count should be incremented");
    }

    @Test
    @Order(5)
    @DisplayName("Test if Getter and Setter is Generated in Employee Class")
    void testGettersAndSetters() {
        Employee employee = new Employee();

        employee.setEmpId(12345L);
        assertEquals(12345L, employee.getEmpId(), "The employee ID should be correctly set and retrieved.");

        employee.setName("John Doe");
        assertEquals("John Doe", employee.getName(), "The employee name should be correctly set and retrieved.");

        employee.setDesignation("Developer");
        assertEquals("Developer", employee.getDesignation(), "The employee designation should be correctly set and retrieved.");

        employee.setGrossSalary(75000.0f);
        assertEquals(75000.0f, employee.getGrossSalary(), "The employee gross salary should be correctly set and retrieved.");

        employee.setTravellingAllowances(5000.0f);
        assertEquals(5000.0f, employee.getTravellingAllowances(), "The employee travelling allowances should be correctly set and retrieved.");

        employee.setFederalTax(1500.0f);
        assertEquals(1500.0f, employee.getFederalTax(), "The employee federal tax should be correctly set and retrieved.");

        employee.setStateTax(750.0f);
        assertEquals(750.0f, employee.getStateTax(), "The employee state tax should be correctly set and retrieved.");

        employee.setIncrementPercentage(5.0f);
        assertEquals(5.0f, employee.getIncrementPercentage(), "The employee increment percentage should be correctly set and retrieved.");

        employee.setBankAccountNo("123456789");
        assertEquals("123456789", employee.getBankAccountNo(), "The employee bank account number should be correctly set and retrieved.");

        Employee.setCompanyName("ABC Corp");
        assertEquals("ABC Corp", Employee.getCompanyName(), "The company name should be correctly set and retrieved.");

        Employee.setCompanyContactNo("123-456-7890");
        assertEquals("123-456-7890", Employee.getCompanyContactNo(), "The company contact number should be correctly set and retrieved.");

        Employee.setEmployeeCount(100);
        assertEquals(100, Employee.getEmployeeCount(), "The employee count should be correctly set and retrieved.");
    }

}
