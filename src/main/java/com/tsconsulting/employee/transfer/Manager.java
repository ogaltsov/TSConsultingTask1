package com.tsconsulting.employee.transfer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class Manager {
    private static Manager manager;

    private Manager() {
    }

    public static synchronized Manager getInstance(){
        if(manager==null){
            manager = new Manager();
            return manager;
        }
        else return manager;
    }

    public void transferring(String employeeListFileName, String totalTransferFileName) {
        try {
            EemployeeParser parser = new EemployeeParser();

            Map<String, Department> departmentMap = fileToMapOfDep(parser, FileManager.readFile(employeeListFileName));

            List<String> totalTransferLines = DepartmentManager.transferringBetweenDep(new ArrayList<>(departmentMap.values()));

            FileManager.writeFile(totalTransferFileName, totalTransferLines);
        } catch (IOException e){
            System.out.println("Ошибка чтения файла");
        }
    }

    public Map<String, Department> fileToMapOfDep(EemployeeParser parser, BufferedReader reader){

        Map<String,Department> departmentMap = reader.lines()
                .map(parser::getObject)
                .collect(Collectors.groupingBy(Employee::getDepName,Collector.of(
                        Department::new,
                        Department::addEmp,
                        Department::mergeTwoDepartments)));
        return departmentMap;
    }


}
