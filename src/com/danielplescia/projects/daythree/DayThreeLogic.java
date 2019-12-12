package com.danielplescia.projects.daythree;

import com.danielplescia.helpers.fileio.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayThreeLogic {

    FileReader fileReader = new FileReader();

    public int getDistance() throws IOException {
        ArrayList<String> fileArray = fileReader.getFile("dayThree.txt");

        // Setup 2 arrays for each situation
        String[] lineOne = fileArray.get(0).split(",");
        String[] lineTwo = fileArray.get(1).split(",");

        // Setup coordinates that each array passes through
        ArrayList<String> lineOneCoordinates = setupCoordinates(lineOne);
        ArrayList<String> lineTwoCoordinates = setupCoordinates(lineTwo);

        // Compare ArrayLists for any matches
        List<String> lineOneSource = new ArrayList<>(lineOneCoordinates);
        List<String> lineTwoSource = new ArrayList<>(lineTwoCoordinates);

        lineOneSource.removeAll(lineTwoCoordinates);
        lineTwoSource.removeAll(lineOneCoordinates);

        lineOneCoordinates.removeAll(lineOneSource); // Remove all of the non-matches to get any final matches
        ArrayList<String> finalCoordinates = lineOneCoordinates;
        System.out.println(finalCoordinates);

        // Loop through final coordinates to find the lowest 'Final' number
        int finalDistance = 0;
        for (String coordinate : finalCoordinates) {
            String[] coordinates = coordinate.split(",");
            int numOne = Math.abs(Integer.parseInt(coordinates[0]));
            int numTwo = Math.abs(Integer.parseInt(coordinates[1]));
            int total = numOne + numTwo;
            if (finalDistance != 0) {
                if (total <= finalDistance) {
                    finalDistance = total;
                }
            } else {
                finalDistance = total;
            }
        }

        return finalDistance;
    }

    private ArrayList<String> setupCoordinates(String[] line) {
        ArrayList<String> coordinates = new ArrayList<>();
        coordinates.add("0,0");
        // Loop through line and add coordinates as we go
        for (String coordinate : line) {
            char firstChar = coordinate.charAt(0);
            String[] lastCoordinate = coordinates.get(coordinates.size() - 1).split(",");
            int lastX = Integer.parseInt(lastCoordinate[0]);
            int lastY = Integer.parseInt(lastCoordinate[1]);
            int numMoves = Integer.parseInt(coordinate.substring(1));

            // Which direction are we headed
            switch(firstChar) {
                case 'R':
                    // Iterate up on the X coordinate
                    numMoves += lastX;
                    for (int i = lastX; i < numMoves; i++) {
                        // Generate coordinate to add
                        lastX++;
                        String newCoordinate = lastX + "," + lastY;
                        coordinates.add(newCoordinate);
                    }
                    break;
                case 'L':
                    // Iterate down on the X coordinate
                    numMoves += lastX;
                    for (int i = lastX; i < numMoves; i++) {
                        // Generate coordinate to add
                        lastX--;
                        String newCoordinate = lastX + "," + lastY;
                        coordinates.add(newCoordinate);
                    }
                    break;
                case 'U':
                    // Iterate up on the Y coordinate
                    numMoves += lastY;
                    for (int i = lastY; i < numMoves; i++) {
                        // Generate coordinate to add
                        lastY++;
                        String newCoordinate = lastX + "," + lastY;
                        coordinates.add(newCoordinate);
                    }
                    break;
                case 'D':
                    // Iterate down on the Y coordinate
                    numMoves += lastY;
                    for (int i = lastY; i < numMoves; i++) {
                        // Generate coordinate to add
                        lastY--;
                        String newCoordinate = lastX + "," + lastY;
                        coordinates.add(newCoordinate);
                    }
                    break;
            }
        }

        return coordinates;

    }

    public int getLeastSteps() throws IOException {
        ArrayList<String> fileArray = fileReader.getFile("dayThree.txt");

        // Setup 2 arrays for each situation
        String[] lineOne = fileArray.get(0).split(",");
        String[] lineTwo = fileArray.get(1).split(",");

        // Setup coordinates that each array passes through
        ArrayList<String> lineOneCoordinates = setupCoordinates(lineOne);
        ArrayList<String> lineTwoCoordinates = setupCoordinates(lineTwo);

        // Compare ArrayLists for any matches
        List<String> lineOneSource = new ArrayList<>(lineOneCoordinates);
        List<String> lineTwoSource = new ArrayList<>(lineTwoCoordinates);

        lineOneSource.removeAll(lineTwoCoordinates);
        lineTwoSource.removeAll(lineOneCoordinates);

        ArrayList<String> finalCoordinates = new ArrayList<>(lineOneCoordinates);
        finalCoordinates.removeAll(lineOneSource); // Remove all of the non-matches to get any final matches

        // Loop through final coordinates to find the lowest total steps required
        int totalSteps = 0;
        for (String coordinate : finalCoordinates) {
            int numOne = lineOneCoordinates.indexOf(coordinate);
            int numTwo = lineTwoCoordinates.indexOf(coordinate);
            int total = numOne + numTwo;
            if (totalSteps != 0) {
                if (total <= totalSteps) {
                    totalSteps = total;
                }
            } else {
                totalSteps = total;
            }
        }
        return totalSteps;
    }

}
