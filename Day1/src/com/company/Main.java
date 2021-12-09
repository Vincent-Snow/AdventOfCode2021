package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }
    static void ptOne() {

        Scanner sc = new Scanner(Input.input);
        int prev = 199;
        int counter = 0;
        while (sc.hasNext()) {
            String strtoken = sc.next();
            int token = Integer.parseInt(strtoken);
            if (token > prev) {
                counter++;
            }
            prev = token;
        }
        sc.close();
        System.out.println(counter);
    }
    static void ptTwo() {

        Scanner sc = new Scanner(Input.input);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (sc.hasNext()) {
            String strtoken = sc.next();
            int token = Integer.parseInt(strtoken);
            arr.add(token);
        }
        sc.close();
        int prev = 607;
        int temp = 0;
        int counter = 0;
        for (int i = 0; i < arr.size()-2; i++) {
            temp = arr.get(i) + arr.get(i+1) + arr.get(i+2);
            if (temp > prev) {
                counter++;
            }
            prev = temp;
        }
        System.out.println(counter);
    }

}