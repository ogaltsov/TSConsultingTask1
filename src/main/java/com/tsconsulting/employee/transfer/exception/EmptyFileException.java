package com.tsconsulting.employee.transfer.exception;

public class EmptyFileException extends RuntimeException {

    public EmptyFileException(){
        super("File is empty");
    }

    public EmptyFileException(String fileName){
        super("File is empty: "+fileName);
    }
}
