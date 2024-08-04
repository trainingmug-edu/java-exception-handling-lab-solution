package com.trainingmug.employee.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class DeveloperTest {

    @Test
    @Order(1)
    @DisplayName("Test Developer Constructor Presence and Super Constructor Invocation")
    public void testDeveloperConstructor() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.employee.domain.Developer");

            Constructor<?> constructor = developerClass.getConstructor(
                    long.class, String.class, String.class, float.class, float.class,
                    float.class, float.class, float.class,String.class, int.class
            );

            assertNotNull(constructor, "Constructor should be present in Developer class");

            Developer developer = (Developer) constructor.newInstance(
                    1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f,
                    150.0f, 100.0f, 10.0f, "1234567890", 5
            );

            assertEquals(1234L, developer.getEmpId(), "Employee ID should be set correctly");
            assertEquals("Jane Doe", developer.getName(), "Name should be set correctly");
            assertEquals("Senior Developer", developer.getDesignation(), "Designation should be set correctly");
            assertEquals(5000.0f, developer.getGrossSalary(), "Gross Salary should be set correctly");
            assertEquals(300.0f, developer.getTravellingAllowances(), "Travelling Allowances should be set correctly");
            assertEquals(150.0f, developer.getFederalTax(), "Federal Tax should be set correctly");
            assertEquals(100.0f, developer.getStateTax(), "State Tax should be set correctly");
            assertEquals(10.0f, developer.getIncrementPercentage(), "Increment Percentage should be set correctly");
            assertEquals("1234567890", developer.getBankAccountNo(), "BankAccountNo should be set correctly");
            assertEquals(5, developer.getNoOfProjects(), "No of Projects should be set correctly");

        } catch (Exception e) {
            fail("Exception occurred during constructor testing: " + e.getMessage());
        }
    }


}
