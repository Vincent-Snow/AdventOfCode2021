package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }

    static void ptOne() {
        String lines[] = Input.input.split("\\r?\\n");
        String twoDlines[][] = new String[lines.length][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            String line[] = lines[i].split("");
            for (int j = 0; j < lines[i].length(); j++) {
                twoDlines[i][j] = line[j];
            }
        }
        ArrayList<Integer> lows = new ArrayList<Integer>();
        for (int i = 0; i < twoDlines.length; i++) {
            for (int j = 0; j < twoDlines[i].length; j++) {
                int c = 0;
                Integer cur = Integer.parseInt(twoDlines[i][j]);
                Integer com = 0;
                if (i != 0) {
                    com = Integer.parseInt(twoDlines[i-1][j]);
                    if (cur < com) {
                        c++;
                    }
                } else {
                    c++;
                }
                if (i != twoDlines.length-1) {
                    com = Integer.parseInt(twoDlines[i+1][j]);
                    if (cur < com) {
                        c++;
                    }
                } else {
                    c++;
                }
                if (j != 0) {
                    com = Integer.parseInt(twoDlines[i][j-1]);
                    if (cur < com) {
                        c++;
                    }
                } else {
                    c++;
                }
                if (j != twoDlines[i].length-1) {
                    com = Integer.parseInt(twoDlines[i][j+1]);
                    if (cur < com) {
                        c++;
                    }
                } else {
                    c++;
                }
                if (c == 4) {
                    lows.add(cur+1);
                }
            }
        }
        int sum = 0;
        for (int low: lows) {
            sum+=low;
        }
        System.out.println(sum);
    }

    static void ptTwo() {

    }
}
