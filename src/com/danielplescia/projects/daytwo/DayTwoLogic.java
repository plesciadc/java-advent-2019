package com.danielplescia.projects.daytwo;

import com.danielplescia.helpers.fileio.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DayTwoLogic {

    FileReader fileReader = new FileReader();

    public int getCode() throws IOException {
        int finalAnswer = 0;
        ArrayList<String> fileArray = fileReader.getFile("dayTwo.txt");
        // We know there is only 1 line
        String list[] = fileArray.get(0).split(",");
        ArrayList<Integer> numList = new ArrayList<Integer>();
        // Convert to array of ints
        for (int i = 0; i < list.length; i++) {
            numList.add(Integer.parseInt(list[i]));
        }

        finalAnswer = runCodeLogic(numList);

        return finalAnswer;
    }

    public ArrayList<Integer> getCodeTwo() throws IOException {
        ArrayList<String> fileArray = fileReader.getFile("dayTwo.txt");
        // We know there is only 1 line
        String list[] = fileArray.get(0).split(",");

        int finalAnswer = 0;
        int firstNum = 0;
        int secondNum = 0;
        ArrayList<Integer> finalAnswers = new ArrayList<>();
        for (firstNum = 0; firstNum <= 99; firstNum++) {
            for (secondNum = 0; secondNum <= 99; secondNum++) {
                ArrayList<Integer> numList = new ArrayList<Integer>();
                // Convert to array of ints
                for (int i = 0; i < list.length; i++) {
                    numList.add(Integer.parseInt(list[i]));
                }
                numList.set(1, firstNum);
                numList.set(2, secondNum);
                finalAnswer = runCodeLogic(numList);
                if (finalAnswer == 19690720) {
                    finalAnswers.add(firstNum);
                    finalAnswers.add(secondNum);
                }

            }
        }

        return finalAnswers;

    }

    private int runCodeLogic(ArrayList<Integer> list) {
        int finalAnswer = 0;

        for (int i = 0; i < list.size(); i += 4) {
            int currentNum = list.get(i);
            if (currentNum == 99) {
                break;
            } else {
                int firstIndex = list.get(i+1);
                int secondIndex = list.get(i+2);
                int thirdIndex = list.get(i+3);
                if (currentNum == 1) {
                    // Read next 2 indexes, add them together, and replace 3rd index
                    list.set(thirdIndex, list.get(firstIndex) + list.get(secondIndex));
                } else if (currentNum == 2) {
                    // Read next 2 indexes, multiply them, and replace 3rd index
                    list.set(thirdIndex, list.get(firstIndex) * list.get(secondIndex));
                }
            }
        }

        finalAnswer = list.get(0);

        return finalAnswer;
    }

}