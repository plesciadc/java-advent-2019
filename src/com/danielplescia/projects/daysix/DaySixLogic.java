package com.danielplescia.projects.daysix;

import com.danielplescia.helpers.fileio.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class DaySixLogic {

    FileReader fileReader = new FileReader();

    public int getTotalOrbits() throws IOException {
        int totalOrbits = 0;

        // Get list from reader
        ArrayList<String> orbitArray = fileReader.getFile("daySix.txt");

        // Loop through orbits and get all of the "direct and indirect" orbits
        for (String orbit : orbitArray) {
            // Always add 1 since each item is automatically an orbit
            totalOrbits++;
            // Get all indirect orbits
            String currentOrbit = orbit.substring(0, 3);
            totalOrbits += getIndirectOrbits(orbitArray, currentOrbit);
        }

        return totalOrbits;
    }

    private int getIndirectOrbits(ArrayList<String> orbitArray, String currentLeftOrbit) {
        int totalOrbits = 0;
        boolean foundOrbit = true;

        while(foundOrbit) {
            foundOrbit = false;
            for (String orbit : orbitArray) {
                String currentRightOrbit = orbit.substring(4);
                // If we find a match, add to totalOrbits and break out of the loop
                if (currentLeftOrbit.compareTo(currentRightOrbit) == 0) {
                    totalOrbits++;
                    currentLeftOrbit = orbit.substring(0, 3);
                    foundOrbit = true;
                    break;
                }
            }
        }

        return totalOrbits;
    }

    public int getYouToSan() throws IOException {
        ArrayList<String> orbitArray = fileReader.getFile("daySix.txt");

        int totalTransfers = 0;
        boolean foundOrbit = true;
        String youLeftOrbit = "B5H"; // Set to left side of "YOU"
        String santaLeftOrbit = "8HB"; // Set to left side of "SAN"
        ArrayList<String> santaArray = getIndirectOrbitsList(orbitArray, youLeftOrbit);
        ArrayList<String> youArray = getIndirectOrbitsList(orbitArray, santaLeftOrbit);
        ArrayList<String> newSanta = new ArrayList<>(santaArray);
        ArrayList<String> newYou = new ArrayList<>(youArray);
        newSanta.removeAll(youArray);
        newYou.removeAll(santaArray);

        totalTransfers = newSanta.size() + newYou.size();

        return totalTransfers;
    }

    private ArrayList<String> getIndirectOrbitsList(ArrayList<String> orbitArray, String currentLeftOrbit) {
        ArrayList<String> orbitList = new ArrayList<>();
        boolean foundOrbit = true;

        while(foundOrbit) {
            foundOrbit = false;
            for (String orbit : orbitArray) {
                String currentRightOrbit = orbit.substring(4);
                // If we find a match, add to totalOrbits and break out of the loop
                if (currentLeftOrbit.compareTo(currentRightOrbit) == 0) {
                    orbitList.add(currentRightOrbit);
                    currentLeftOrbit = orbit.substring(0, 3);
                    foundOrbit = true;
                    break;
                }
            }
        }

        return orbitList;
    }

}
