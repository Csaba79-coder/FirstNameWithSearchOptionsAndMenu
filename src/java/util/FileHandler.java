package util;

import controller.FirstNameController;
import model.FirstName;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileHandler {



    private static final String RELATIVE_PATH = "src/resources/nevek.txt";
    private static final String RELATIVE_PATH_TEST_FILE = "src/resources/test_file.txt";


    public void read() throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of(RELATIVE_PATH_TEST_FILE), StandardCharsets.UTF_8);

        for (String line; (line = bufferedReader.readLine()) != null; ) {
            FirstName currentFirstName = new FirstName(line.split(",", 4));
            FirstNameController.firstNamesMap.putIfAbsent(currentFirstName.getGender(), new ArrayList<>());
            FirstNameController.firstNamesMap.get(currentFirstName.getGender()).add(currentFirstName);
        }
    }
}