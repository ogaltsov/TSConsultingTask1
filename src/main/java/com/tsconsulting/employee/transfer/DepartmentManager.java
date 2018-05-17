package com.tsconsulting.employee.transfer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepartmentManager {
    private static List<String> totalTransferLines = new ArrayList<>();

    public static List<String> transferringBetweenDep(List<Department> listOfDep){

        listOfDep.sort(Comparator.comparing(Department::getAverageSalary).reversed());

        for(int i=0; i<listOfDep.size()- 1; i++){
            for(int j=i+1; j<listOfDep.size(); j++){
                prepToCombine(listOfDep.get(i), listOfDep.get(j));
            }
        }
        return totalTransferLines;
    }

    private static void prepToCombine(Department dep1, Department dep2) {
        for (int i = 1; i < dep1.getEmpList().size() - 1; i++) {

                Employee[] combination = new Employee[i];
                checkCombinations(dep1, dep2, combination, 0, 0);
        }
    }

    private static void checkCombinations(Department dep1, Department dep2, Employee data[], int start, int index)  {

        if (index == data.length && dep1.getEmpList().size()>data.length) {

            String transferLineInfo ="";
            BigDecimal temp = avgFew(data);

                if (temp.compareTo(dep1.getAverageSalary()) < 0 && temp.compareTo(dep2.getAverageSalary()) > 0) {
                    for (Employee e : data){
                        transferLineInfo = transferLineInfo.concat(String.format(("| %s %s [%s \u20BD],\r\n"), e.getFirstName(), e.getSecondName(), e.getSalary()));
                    }
                    transferLineInfo =
                            String.format("________________________________________________________________________\r\n" +
                                    "| *** Перевести сотрудников:%n%30s%n| Из департамента %s[%s \u20BD] в департамент %s[%s \u20BD]%n" +
                                    "| Средня зарплата по отделу после перевода:%n| Департамент %s[%s \u20BD], департамент %s[%s \u20BD]%n|%n|"
                            , transferLineInfo, dep1.getDepName(), dep1.getAverageSalary()
                            , dep2.getDepName(), dep2.getAverageSalary(), dep1.getDepName(), newAvgFew(dep1, data, "REMOVE")
                            , dep2.getDepName(), newAvgFew(dep2, data, "ADD"));
                    totalTransferLines.add(transferLineInfo);
                }
            }
        for (int i = start; i<dep1.getEmpList().size() && index<data.length ; i++) {
            data[index] = dep1.getEmpList().get(i);
            checkCombinations(dep1, dep2,  data, i+1, index+1);
        }
    }


    private static BigDecimal avgFew(Employee[] e) {
        BigDecimal sum = new BigDecimal(0);

        for(Employee m : e){
            sum = m.getSalary().add(sum);
        }

        return sum.divide(new BigDecimal(e.length), 2, RoundingMode.HALF_UP);
    }

    private static BigDecimal newAvgFew(Department d, Employee[] e, String remOrAdd) {
        if(remOrAdd.equals("ADD"))
            return d.getAddAvgSalaryFew(e);
        if(remOrAdd.equals("REMOVE"))
            return d.getRemAvgSalaryFew(e);
        return null;
    }


}
