package com.tsconsulting.employee.transfer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Department {
    private String depName;
    private ArrayList<Employee> empList = new ArrayList<>();
    private BigDecimal sum = new BigDecimal(0);


    public Department() {

    }

    public String getDepName() {
        return depName;
    }


    public static Department mergeTwoDepartments(Department d1,Department d2){
        return d1;
    }

    public void addEmp(Employee employee) {
        if(depName==null)
            depName= employee.getDepName();
        empList.add(employee);
        sum = employee.getSalary().add(sum);
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public BigDecimal getAverageSalary() {
        BigDecimal averageSalary = sum.divide(new BigDecimal(empList.size()), 2, RoundingMode.HALF_UP);
        return averageSalary;
    }

    public BigDecimal getAddAvgSalaryFew(Employee[] e) {
        BigDecimal temp = new BigDecimal(0) ;
        for(Employee ee : e)
            temp = ee.getSalary().add(temp);
        return ((sum.add(temp)).divide(new BigDecimal(empList.size()+e.length), 2, RoundingMode.HALF_UP));
    }

    public BigDecimal getRemAvgSalaryFew(Employee[] e) {
        BigDecimal temp = new BigDecimal(0);
        for(Employee ee : e)
            temp = ee.getSalary().add(temp);
        return ((sum.subtract(temp)).divide(new BigDecimal(empList.size()-e.length), 2, RoundingMode.HALF_UP));
    }

}
