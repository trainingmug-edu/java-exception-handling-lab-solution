package com.trainingmug.employee.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class DesignerTest {

    @Test
    @Order(1)
    @DisplayName("Test Designer Constructor Presence and Super Constructor Invocation")
    public void testDesignerConstructor() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.domain.Designer");

            Constructor<?> constructor = designerClass.getConstructor(
                    long.class, String.class, String.class, float.class, float.class,
                    float.class, float.class, float.class, String.class, int.class
            );

            assertNotNull(constructor, "Constructor should be present in Designer class");

            Designer designer = (Designer) constructor.newInstance(
                    1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f,
                    150.0f, 100.0f, 10.0f,"1234567890", 5
            );

            assertEquals(1234L, designer.getEmpId(), "Employee ID should be set correctly");
            assertEquals("Jane Doe", designer.getName(), "Name should be set correctly");
            assertEquals("Senior Developer", designer.getDesignation(), "Designation should be set correctly");
            assertEquals(5000.0f, designer.getGrossSalary(), "Gross Salary should be set correctly");
            assertEquals(300.0f, designer.getTravellingAllowances(), "Travelling Allowances should be set correctly");
            assertEquals(150.0f, designer.getFederalTax(), "Federal Tax should be set correctly");
            assertEquals(100.0f, designer.getStateTax(), "State Tax should be set correctly");
            assertEquals(10.0f, designer.getIncrementPercentage(), "Increment Percentage should be set correctly");
            assertEquals("1234567890", designer.getBankAccountNo(), "BankAccountNo should be set correctly");
            assertEquals(5, designer.getNoOfWebsites(), "No of Websites should be set correctly");

        } catch (Exception e) {
            fail("Exception occurred during constructor testing: " + e.getMessage());
        }
    }

}
