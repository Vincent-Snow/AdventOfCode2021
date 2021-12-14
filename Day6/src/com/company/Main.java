package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }
    static void ptOne() {
        String arrFishes[] = Input.input.split(",");
        List<String> fishes = new ArrayList<String>();
        Collections.addAll(fishes,arrFishes);
        int i = 0;
        while (i < 80) {
            int size = fishes.size();
            for (int ind = 0; ind < size; ind++) {
                if (fishes.get(ind).equals(("0"))) {
                    fishes.add("8");
                    fishes.set(ind,"6");
                } else {
                    int fishInt = Integer.parseInt(fishes.get(ind))-1;
                    String fishStr = String.valueOf(fishInt);
                    fishes.set(ind,fishStr);
                }
            }
            i++;
        }
        System.out.println(fishes.size());
    }

    static void ptTwo() {

        String arrFishes[] = Input.testInput2.split(",");
        List<String> fishes = new ArrayList<String>();
        Collections.addAll(fishes,arrFishes);
        int i = 0;
        while (i < 100) {

            int size = fishes.size();
            for (int ind = 0; ind < size; ind++) {
                if (fishes.get(ind).equals(("0"))) {
                    fishes.add("8");
                    fishes.set(ind,"6");
                } else {
                    int fishInt = Integer.parseInt(fishes.get(ind))-1;
                    String fishStr = String.valueOf(fishInt);
                    fishes.set(ind,fishStr);
                }
            }
            i++;
            System.out.println(String.valueOf(fishes.size()) + " " + i);
            //System.out.println(fishes);

        }
        System.out.println(fishes.size());
    }
}
