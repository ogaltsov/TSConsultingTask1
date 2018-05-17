package com.tsconsulting.employee.transfer;

import java.io.*;
import java.util.List;

public class FileManager {
    public static BufferedReader readFile(String fileName) {
        return new BufferedReader(new InputStreamReader(FileManager.class.getResourceAsStream(fileName)));
    }

    public static void writeFile(String fileName, List<String> listOfLines) throws IOException{

        BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(FileManager.class.getResource(fileName).getPath())));

        listOfLines.forEach(line -> {
                        try {
                             bufWriter.write(line);
                        } catch (IOException e) {
                            System.out.println("Ошибка чтения файла");
                    }
                });

        bufWriter.flush();
    }
}
