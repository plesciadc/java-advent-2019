package com.danielplescia.projects.dayfour;

import java.util.ArrayList;

public class DayFourLogic {

    public int getTotalPasswords() {
        int totalPasswords = 0;
        ArrayList<Integer> passwordMatches = new ArrayList<>();

        // Iterate through the passwords to find any that match
        for (int password = 128392; password < 643281; password++) {
            if (checkAdjacentDigits(password) && checkDecreasingDigits(password)) {
                passwordMatches.add(password);
            }
        }

        totalPasswords = passwordMatches.size();

        return totalPasswords;
    }

    private boolean checkAdjacentDigits(int number) {
        boolean numberMatches = false;

        return numberMatches;
    }

    private boolean checkDecreasingDigits(int number) {
        boolean numberMatches = false;

        return numberMatches;
    }

}
