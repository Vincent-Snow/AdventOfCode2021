package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }

    static void ptOne() {
        String locstr[] = Input.input.split(",");
        int loc[] = new int[locstr.length];
        for (int i = 0; i<loc.length;i++) {
            loc[i] = Integer.parseInt(locstr[i]);
        }
        Arrays.sort(loc);
        double median;
        if (loc.length % 2 == 0)
            median = ((double)loc[loc.length/2] + (double)loc[loc.length/2 - 1])/2;
        else
            median = (double) loc[loc.length/2];

        int intmedian = (int)median;
        int fuelCost = 0;

        for (int i = 0; i < loc.length; i++) {
            if (loc[i] >= intmedian) {
                fuelCost += loc[i] - intmedian;
            } else {
                fuelCost += intmedian - loc[i];
            }
        }
        System.out.println(fuelCost);


    }

    static void ptTwo() {
        String locstr[] = Input.input.split(",");
        int loc[] = new int[locstr.length];
        for (int i = 0; i<loc.length;i++) {
            loc[i] = Integer.parseInt(locstr[i]);
        }

        int avg = (int)Arrays.stream(loc).average().orElse(Double.NaN);
        for (int j = avg-1; j <= avg+1; j++) {
            int fuelCost = 0;
            System.out.println(j);
            for (int i = 0; i < loc.length; i++) {
                if (loc[i] >= j) {
                    fuelCost += sum(loc[i] - j);
                } else {
                    fuelCost += sum(j - loc[i]);
                }
            }
            System.out.println(fuelCost);
        }

    }
    static int sum( int x) {
        int n = 1;
        int c = 0;
        while (n <= x) {
            c+=n;
            n++;
        }
        return c;
    }
}
