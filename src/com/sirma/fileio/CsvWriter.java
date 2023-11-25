package com.sirma.fileio;

import java.io.*;
import java.util.List;


public class CsvWriter implements DataFileWriter {

    @Override
    public void writeDataFile(List<String[]> list, File file) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (String[] data : list) {
                writer.println(String.join("," , data));
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


}
