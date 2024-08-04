package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.InvalidBankAccountException;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollImplTest {

    @Test
    @Order(1)
    @DisplayName("Test Display Profile Should Be Present")
    void testDisplayProfileShouldBePresent(){
        try{
            Class<?> payrollImpl = Class.forName("com.trainingmug.employee.service.PayrollImpl");
            payrollImpl.getDeclaredMethod("displayProfile", Employee.class);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test if displayProfile prints message when null is passed")
    void testDisplayProfileHandlesNullPointerException() {
        PayrollImpl payrollImpl = new PayrollImpl();
        Employee employee = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            payrollImpl.displayProfile(employee);

            String output = outputStream.toString().trim();
            assertEquals("Employee object shouldn't be null", output);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @Order(3)
    @DisplayName("Test ProcessSalary Method Should Be Presence")
    void testProcessSalaryMethodPresence() {
        try {
            Class<?> payrollImplClass = Class.forName("com.trainingmug.employee.service.PayrollImpl");

            Method processSalaryMethod = payrollImplClass.getMethod("processSalary", Employee.class);

            assertNotNull(processSalaryMethod, "The 'processSalary' method should be present in PayrollImpl.");
            assertEquals(boolean.class, processSalaryMethod.getReturnType(), "The return type should be boolean.");
            Class<?>[] parameterTypes = processSalaryMethod.getParameterTypes();
            assertEquals(1, parameterTypes.length, "The 'processSalary' method should have exactly one parameter.");
            assertEquals(Employee.class, parameterTypes[0], "The parameter type should be Employee.");

        } catch (ClassNotFoundException e) {
            fail("PayrollImpl class not found. Ensure the class is correctly defined.");
        } catch (NoSuchMethodException e) {
            fail("The 'processSalary' method is missing from PayrollImpl. Ensure the method is overridden as specified.");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test ProcessSalary Method Should return true for valid employee")
    void testProcessSalaryImplementation() {
        try {
            PayrollImpl payrollImpl = new PayrollImpl();
            Employee validEmployee = new Employee();
            validEmployee.setName("John Doe");
            validEmployee.setBankAccountNo("12345678901");
            validEmployee.setGrossSalary(5000);
            validEmployee.setTravellingAllowances(200);
            validEmployee.setFederalTax(500);
            validEmployee.setStateTax(200);

            boolean result = payrollImpl.processSalary(validEmployee);

            assertTrue(result, "The processSalary method should return true for a valid employee.");

        } catch (Exception e) {
            fail("Exception thrown during valid employee processing: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @DisplayName("Test ProcessSalary if InvalidBankAccount number is passed should throw exception")
    void testProcessSalaryThrowsException() {
        try {
            PayrollImpl payrollImpl = new PayrollImpl();
            Employee invalidEmployee = new Employee();
            invalidEmployee.setName("Jane Doe");
            invalidEmployee.setBankAccountNo("1234567890");

            InvalidBankAccountException thrown = assertThrows(InvalidBankAccountException.class, () -> {
                payrollImpl.processSalary(invalidEmployee);
            });

            assertEquals("Hey Jane Doe, Invalid Bank Account, Please provide the proper Bank Account Number to process your salary..",
                    thrown.getMessage(), "The exception message should match for an invalid bank account.");

        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}
