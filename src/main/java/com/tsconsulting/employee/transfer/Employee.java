package com.tsconsulting.employee.transfer;

import java.math.BigDecimal;

public class Employee {
    private String firstName, secondName;
    private BigDecimal salary;
    private String depName;

    public Employee(String firstName, String secondName, BigDecimal salary, String depName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
        this.depName = depName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDepName() { return depName; }
}
