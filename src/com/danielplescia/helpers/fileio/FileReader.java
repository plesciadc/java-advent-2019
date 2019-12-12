package com.danielplescia.helpers.fileio;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    /*
     Takes a filename as an input and returns the file contents as an array
     */
    public ArrayList<String> getFile(String filename) throws IOException {
        ArrayList fileContents = new ArrayList<String>();
        // Read file
        Path filePath = Paths.get("resources/" + filename);
        BufferedReader reader = Files.newBufferedReader(filePath);

        // Get all lines from file and load into an array
        String lineFromFile = reader.readLine();
        while (lineFromFile != null) {
            fileContents.add(lineFromFile);
            lineFromFile = reader.readLine();
        }

        return fileContents;
    }
}
