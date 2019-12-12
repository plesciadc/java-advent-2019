package com.danielplescia.projects.dayone;

import com.danielplescia.helpers.fileio.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayOneLogic {

    FileReader fileReader = new FileReader();

    public int getFuelRequirements() throws IOException {
        int finalAnswer = 0;
        ArrayList<String> fileArray = fileReader.getFile("dayOne.txt");
        for (String fuel : fileArray) {
            double module = Integer.parseInt(fuel);
            module = (Math.floor(module / 3)) - 2;
            finalAnswer += module;
        }

        return finalAnswer;
    }

    public int getRecursiveFuelRequirements() throws IOException {
        int finalAnswer = 0;
        ArrayList<String> fileArray = fileReader.getFile("dayOne.txt");
        for (String fuel : fileArray) {
            double module = Integer.parseInt(fuel);
            int totalModule = 0;
            while (module >= 0) {
                module = (Math.floor(module / 3)) - 2;
                if (module >= 0) { totalModule += module; }
            }
            finalAnswer += totalModule;
        }

        return finalAnswer;
    }

}
