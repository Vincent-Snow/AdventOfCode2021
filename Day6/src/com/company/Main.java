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

        String arrFishes[] = Input.input.split(",");
        HashMap<Integer,Long> fishDays = new HashMap<Integer, Long>();
        for (int i = 0; i < 9; i++) {
            fishDays.put(i, 0L);
        }
        for (String fish : arrFishes) {
            Integer intFish = Integer.parseInt(fish);
            fishDays.put(intFish, fishDays.get(intFish) + 1);

        }
        int i = 0;
        while (i < 256) {

            int size = fishDays.size();
            HashMap<Integer,Long> fishOfTheDay = new HashMap<Integer,Long>();
            for (int d = size-1; d >= 0; d--) {
                Long daily = fishDays.get(d);
                if (d != 0) {
                    fishOfTheDay.put(d-1,daily);
                }  if (d == 0) {
                    fishOfTheDay.put(6,fishOfTheDay.get(6) + daily);
                    fishOfTheDay.put(8,daily);
                }
            }
            fishDays = fishOfTheDay;
            i++;
        }
        Long c = 0L;
        for (Long fishCount: fishDays.values()) {
            c+=fishCount;
        }
        System.out.println(c);
    }
}
