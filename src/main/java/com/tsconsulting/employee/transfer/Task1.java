package com.tsconsulting.employee.transfer;


public class Task1 {
    public static void main(String[] args) {

        Manager manager = Manager.getInstance();
        manager.transferring("Employee.txt", "Transfer.txt");
    }
}
