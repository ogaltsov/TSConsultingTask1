package com.tsconsulting.employee.transfer;

import java.math.BigDecimal;

public class EemployeeParser{

    public Employee getObject(String employeeStringLine) {
        try {
            String[] tokens = employeeStringLine.split(",\\s{0,10}");
            return new Employee(tokens[0], tokens[1], new BigDecimal(tokens[3]), tokens[2]);

        } catch (ArrayIndexOutOfBoundsException e){
            throw new IllegalLineFormatException();
        }
    }
}
