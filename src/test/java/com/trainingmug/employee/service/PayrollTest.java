package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollTest {

    @Test
    @Order(1)
    @DisplayName("Test if boolean processSalary(Employee employee) created in Payroll Interface")
    void testProcessSalaryMethodPresence() {
        try {
            Class<?> payrollInterface = Class.forName("com.trainingmug.employee.service.Payroll");

            Method processSalaryMethod = payrollInterface.getMethod("processSalary", Employee.class);

            assertNotNull(processSalaryMethod, "The 'processSalary' method should be present in the Payroll interface.");

            assertEquals(boolean.class, processSalaryMethod.getReturnType(), "The return type of 'processSalary' method should be boolean.");

            Class<?>[] parameterTypes = processSalaryMethod.getParameterTypes();
            assertEquals(1, parameterTypes.length, "The 'processSalary' method should have exactly one parameter.");
            assertEquals(Employee.class, parameterTypes[0], "The parameter type of 'processSalary' method should be Employee.");

        } catch (ClassNotFoundException e) {
            fail("Payroll interface not found. Ensure that the interface is properly defined and in the classpath.");
        } catch (NoSuchMethodException e) {
            fail("The 'processSalary' method is missing from the Payroll interface. Ensure the method is defined as specified.");
        }
    }

}
