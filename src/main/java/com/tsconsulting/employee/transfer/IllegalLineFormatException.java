package com.tsconsulting.employee.transfer;

/**
 * This class expand class RuntimeException
 * Uses in situations, when line in file has wrong format
 */

public class IllegalLineFormatException extends RuntimeException{

    public IllegalLineFormatException(String s) {
        super("[ERROR] Ошибка формата записи в строке: \""+s+"\"");
    }

    public IllegalLineFormatException(){}
}