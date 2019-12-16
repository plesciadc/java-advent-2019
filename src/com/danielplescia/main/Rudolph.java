package com.danielplescia.main;

import com.danielplescia.projects.dayone.DayOneLogic;
import com.danielplescia.projects.daytwo.DayTwoLogic;
import com.danielplescia.projects.daythree.DayThreeLogic;
import com.danielplescia.projects.dayfour.DayFourLogic;
import com.danielplescia.projects.daysix.DaySixLogic;

import java.io.IOException;

public class Rudolph {

    static DayOneLogic dayOne = new DayOneLogic();
    static DayTwoLogic dayTwo = new DayTwoLogic();
    static DayThreeLogic dayThree = new DayThreeLogic();
    static DayFourLogic dayFour = new DayFourLogic();
    static DaySixLogic daySix = new DaySixLogic();

    public static void main(String[] args) throws IOException {
	    // Get answer for day 1, answer 1
        System.out.println("/--------- DAY 1, ANSWER 1 ----------/");
        System.out.println(dayOne.getFuelRequirements());
        // Get answer for day 1, answer 2
        System.out.println("/--------- DAY 1, ANSWER 2 ----------/");
        System.out.println(dayOne.getRecursiveFuelRequirements());

        // Get answer for day 2, answer 1
        System.out.println("/--------- DAY 2, ANSWER 1 ----------/");
        System.out.println(dayTwo.getCode());
        // Get answer for day 2, answer 2
        System.out.println("/--------- DAY 2, ANSWER 2 ----------/");
        System.out.println(dayTwo.getCodeTwo());

        // Get answer for day 3, answer 1
//        System.out.println("/--------- DAY 3, ANSWER 1 ----------/");
//        System.out.println(dayThree.getDistance());
        // Get answer for day 3, answer 2
//        System.out.println("/--------- DAY 3, ANSWER 2 ----------/");
//        System.out.println(dayThree.getLeastSteps());

        // Get answer for day 4, answer 1
        System.out.println("/--------- DAY 4, ANSWER 1 ----------/");
        System.out.println(dayFour.getTotalPasswords());
        // Get answer for day 4, answer 2
        System.out.println("/--------- DAY 4, ANSWER 2 ----------/");
        System.out.println(dayFour.getTotalPasswordsStrict());

        // Get answer for day 6, answer 1
//        System.out.println("/--------- DAY 6, ANSWER 1 ----------/");
//        System.out.println(daySix.getTotalOrbits());
        // Get answer for day 6, answer 2
        System.out.println("/--------- DAY 6, ANSWER 2 ----------/");
        System.out.println(daySix.getYouToSan());

    }
}
