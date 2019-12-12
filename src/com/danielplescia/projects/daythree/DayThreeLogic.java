package com.danielplescia.projects.daythree;

import com.danielplescia.helpers.fileio.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class DayThreeLogic {

    FileReader fileReader = new FileReader();

    public int getDistance() throws IOException {
        int finalDistance = 0;
        ArrayList<String> fileArray = fileReader.getFile("dayThree.txt");

        // Setup 2 arrays for each situation
        String[] lineOne = fileArray.get(0).split(",");
        String[] lineTwo = fileArray.get(1).split(",");

        // Setup coordinates that each array passes through
        ArrayList<String> lineOneCoordinates = setupCoordinates(lineOne);
        ArrayList<String> lineTwoCoordinates = setupCoordinates(lineTwo);

        return finalDistance;
    }

    private ArrayList<String> setupCoordinates(String[] line) {
        ArrayList<String> coordinates = new ArrayList<>();
        coordinates.add("0,0");
        

        return coordinates;

    }

}
