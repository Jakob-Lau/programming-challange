package de.bcxp.challenge.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReader<T> {

    public List<T> readFile(Path path, char separator, Class<T> clazz) throws IOException {
        checkFile(path);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            CsvToBean<T> beans = new CsvToBeanBuilder<T>(br)
                    .withType(clazz)
                    .withSeparator(separator)
                    .withThrowExceptions(false) // don't throw exceptions, but log inconsistent data
                    .build();

            // log exceptions
            beans.getCapturedExceptions().forEach(exception -> {
                System.err.println("Inconsitent data:" + String.join("", exception.getLine()) + exception);
            });

            return beans.parse();
        }
    }

    private void checkFile(Path path) throws IOException {
        File file = path.toFile();
        // you could check the file extension first

        // check if file exists
        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getAbsolutePath() + " not found.");
        }

        // check if file is empty
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        if (line == null) {
            // you could use a custom EmptyFileException
            throw new IllegalArgumentException("File " + file.getAbsolutePath() + " is empty.");
        }

        // here you could check for the headers that are expected
    }
}