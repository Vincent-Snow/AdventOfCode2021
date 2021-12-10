package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }

    static void ptOne() {
        int x = 0;
        int y = 0;
        Scanner sc = new Scanner(Input.input);
        ArrayList<String> arr = new ArrayList<String>();
        while (sc.hasNext()) {
            String token = sc.next();
            arr.add(token);
        }

        for (int i = 0; i < arr.size(); i+=2) {
            switch (arr.get(i)) {
                case "forward":
                    x = x + Integer.parseInt(arr.get(i+1));
                    break;
                case "down":
                    y = y - Integer.parseInt(arr.get(i+1));
                    break;
                case "up":
                    y = y + Integer.parseInt(arr.get(i+1));
                    break;
                default:
                    break;
            }
        }
        if (y < 0) {
            System.out.println(x * y * -1);
        } else {
            System.out.println(x * y);
        }

    }

    static void ptTwo() {

        int x = 0;
        int y = 0;
        int z = 0;
        Scanner sc = new Scanner(Input.input);
        ArrayList<String> arr = new ArrayList<String>();
        while (sc.hasNext()) {
            String token = sc.next();
            arr.add(token);
        }

        for (int i = 0; i < arr.size(); i+=2) {
            switch (arr.get(i)) {
                case "forward":
                    x = x + Integer.parseInt(arr.get(i+1));
                    y = y + (z * Integer.parseInt(arr.get(i+1)));
                    break;
                case "down":
                    z = z + Integer.parseInt(arr.get(i+1));
                    break;
                case "up":
                    z = z - Integer.parseInt(arr.get(i+1));
                    break;
                default:
                    break;
            }
        }
        System.out.println(x*y);
    }
}
