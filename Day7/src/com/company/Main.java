package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }

    static void ptOne() {
        String locstr[] = Input.testInput.split(",");
        int loc[] = new int[locstr.length];
        for (int i = 0; i<loc.length;i++) {
            loc[i] = Integer.parseInt(locstr[i]);
        }
        System.out.println(Arrays.stream(loc).sum());
        System.out.println(Arrays.stream(loc).average().orElse(Double.NaN));
        Arrays.sort(loc);
        double median;
        if (loc.length % 2 == 0)
            median = ((double)loc[loc.length/2] + (double)loc[loc.length/2 - 1])/2;
        else
            median = (double) loc[loc.length/2];


        int intmedian = (int)median;
        System.out.println(intmedian);
        int fuelCost = 0;
        for (int i = 0; i < loc.length; i++) {
            if (loc[i] >= intmedian) {
                fuelCost+=loc[i]-intmedian;
            } else {
                fuelCost+=intmedian-loc[i];
            }
        }
        System.out.println(fuelCost);
    }

    static void ptTwo() {

    }
}
