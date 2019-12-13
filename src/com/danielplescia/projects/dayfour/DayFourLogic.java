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

    public int getTotalPasswordsStrict() {
        int totalPasswords = 0;
        ArrayList<Integer> passwordMatches = new ArrayList<>();

        // Iterate through the passwords to find any that match
        for (int password = 128392; password < 643281; password++) {
            if (checkStrictAdjacentDigits(password) && checkDecreasingDigits(password)) {
                passwordMatches.add(password);
            }
        }

        totalPasswords = passwordMatches.size();

        return totalPasswords;
    }

    private boolean checkAdjacentDigits(int number) {
        boolean numberMatches = false;
        String numberString = Integer.toString(number);
        for (int i=0; i < numberString.length()-1; i++) {
            if (numberString.charAt(i) == numberString.charAt(i+1)) {
                numberMatches = true;
            }
        }

        return numberMatches;
    }

    private boolean checkStrictAdjacentDigits(int number) {
        boolean numberMatches = false;
        String numberString = Integer.toString(number);
        for (int i=0; i < numberString.length()-1; i++) {
            if (numberString.charAt(i) == numberString.charAt(i+1)) {
                // Second check for a third matching digit
                if (i < numberString.length()-2 && i > 0) {
                    if (numberString.charAt(i) != numberString.charAt(i+2) && numberString.charAt(i) != numberString.charAt(i-1)) {
                        numberMatches = true;
                    }
                } else if (i == 0) {
                    // We are on the 1st number
                    if (numberString.charAt(i) != numberString.charAt(i+2)) {
                        numberMatches = true;
                    }
                } else {
                    // We are on the 2nd to last number
                    if (numberString.charAt(i) != numberString.charAt(i-1)) {
                        numberMatches = true;
                    }
                }
            }
        }

        return numberMatches;
    }

    private boolean checkDecreasingDigits(int number) {
        boolean numberMatches = true;
        String numberString = Integer.toString(number);
        for (int i=0; i < numberString.length()-1; i++) {
            int numOne = Character.getNumericValue(numberString.charAt(i));
            int numTwo = Character.getNumericValue(numberString.charAt(i+1));

            if (numOne > numTwo) {
                numberMatches = false;
            }
        }

        return numberMatches;
    }

}
