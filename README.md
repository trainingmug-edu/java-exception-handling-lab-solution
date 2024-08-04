## Exception Handling and Custom Exceptions in Java

### Objectives

1. Understand Exceptions in Java.
2. Implement try/catch/finally to handle Exceptions in Java.
3. Understand and implement custom exceptions in Java.

### Problem Statement 1: Exception Handling

#### Task

1. Comment the `displayProfile(String department)` method in both the `Payroll` Interface and its implementation in the `PayrollImpl` class.
2. In `Main.java`, invoke `displayProfile(Employee employee)` by passing `null` as the parameter.
3. Handle the `NullPointerException` using a try/catch block.
4. Handle all possible exceptions in all methods of the `PayrollImpl` class.

### Problem Statement 2: Custom Exceptions

#### Task

1. Create a new package `com.trainingmug.employee.exception`.
2. Under this package, create a new Exception class named `InvalidBankAccountException`.
3. Override the constructor `public InvalidBankAccountException(String message)` with a message.
4. In `Employee.java`:
   - Add the `bankAccountNo` (String) property.
   - Update the argument constructor to include the `bankAccountNo` property.
   - Generate getter and setter methods for this property.
   - Print the `bankAccountNo` in the `displayProfile()` method.
5. In `Developer.java` and `Designer.java`:
   - Add `bankAccountNo` in the constructor and pass it to the superclass constructor.
   - Print the `bankAccountNo` by invoking `getBankAccountNo()` in the `displayProfile()` method.
6. In `Main.java`, pass the `bankAccountNo` values for all `Employee`, `Developer`, and `Designer` objects.
7. In `Payroll.java`, create the following method:
   ```java
   boolean processSalary(Employee employee) throws InvalidBankAccountException;
   ```
8. In `PayrollImpl.java`, implement the above method with the following rules:
   - If the `bankAccountNo` of the Employee is `null` or not 11 characters in length, throw `InvalidBankAccountException` with the appropriate message.
   - If the `bankAccountNo` is valid, display a message "Net Salary : $XXXX is successfully processed to XXXXX" and return `true`.
9. In `Main.java`, invoke the `processSalary()` method by passing existing `Developer` and `Designer` objects.
10. Handle the `InvalidBankAccountException` using a try/catch block and display the exception message in the catch block.
11. Create a `Developer` object with `bankAccountNo` as `null` and invoke the `processSalary()` method.
12. Observe the output: 
   ```
   "Hey XXXXXX, Invalid Bank Account, Please provide the proper Bank Account Number to process your salary."
   ```
13. Create another `Developer` object with `bankAccountNo` as 7 digits and invoke the `processSalary()` method.
14. Observe the output: 
   ```
   "Hey XXXXXX, Invalid Bank Account, Please provide the proper Bank Account Number to process your salary."
   ```

---

This README provides a high-level overview of the tasks and requirements for exception handling and custom exceptions in the Java application.
