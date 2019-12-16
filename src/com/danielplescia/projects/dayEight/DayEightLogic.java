package com.danielplescia.projects.dayEight;

import com.danielplescia.helpers.fileio.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class DayEightLogic {

    FileReader fileReader = new FileReader();

    public int getImageData() throws IOException {
        int finalImageNumber = 0;

        String imageData = fileReader.getFile("dayEight.txt").get(0); // Get the first line, since there is only one

        ArrayList<String> imageLayers = new ArrayList<>();
        ArrayList<Integer> imageLayerZeros = new ArrayList<>();

        for (int i=0; i < imageData.length(); i+=150) {
            imageLayers.add(imageData.substring(i, i+150));
        }

        for (String layer : imageLayers) {
            int totalZeros = 0;
            // Loop through string to find char
            for (int i=0; i < layer.length(); i++) {
                if (layer.charAt(i) == '0') {
                    // We found a 0
                    totalZeros++;
                }
            }
            imageLayerZeros.add(totalZeros);
        }

        int fewestIndex = 0;
        int lowestZeros = 0;
        for (int i=0; i < imageLayerZeros.size(); i++) {
            if (i == 0) {
                // Initialize
                fewestIndex = i;
                lowestZeros = imageLayerZeros.get(i);
            } else {
                if (imageLayerZeros.get(i) < lowestZeros) {
                    fewestIndex = i;
                    lowestZeros = imageLayerZeros.get(i);
                }
            }
        }

        // Finally multiply the number of 1s by number of 2s
        String correctLayer = imageLayers.get(fewestIndex);
        int oneCount = 0;
        int twoCount = 0;
        for (int i=0; i < correctLayer.length(); i++) {
            if (correctLayer.charAt(i) == '1') {
                // We found a 1
                oneCount++;
            } else if (correctLayer.charAt(i) == '2') {
                twoCount++;
            }
        }

        finalImageNumber = oneCount * twoCount;

        return finalImageNumber;
    }

}
