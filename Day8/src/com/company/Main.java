package com.company;

import java.util.Arrays;
import java.util.Comparator;


public class Main {

    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }

    static void ptOne() {
        String lines[] = Input.input.split("\n");
        int c = 0;
        for (int j = 0; j < lines.length; j++) {
            String digits[] = lines[j].split("\\|");
            String outputDigits[] = digits[1].trim().split(" ");

            for (int i = 0; i < outputDigits.length; i++) {

                switch (outputDigits[i].length()) {
                    case 4:
                    case 3:
                    case 2:
                    case 7:
                        //System.out.println(outputDigits[i]);
                        c++;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(c);
    }

    public static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }

    static void ptTwo() {

        //String lines[] = introInput.split("\n");
        String lines[] = Input.input.split("\n");
        int c = 0;
        for (int j = 0; j < lines.length; j++) {
            String digits[] = lines[j].split("\\|");
            String signalPatterns[] = digits[0].trim().split(" ");
            Arrays.sort(signalPatterns, Comparator.comparingInt(String::length));
            String positions[] = new String[7];
            Integer iterators[] = {0,1,2,6,7,8,3,4,5,3,4,5};
            for (int it = 0; it < iterators.length; it++) {
                int i = iterators[it];
                String s = signalPatterns[i];

                if (i == 0) {
                    // number 1
                    positions[2] = s;
                    positions[5] = s;
                }
                String r1 = String.valueOf(signalPatterns[0].charAt(0));
                String r2 = String.valueOf(signalPatterns[0].charAt(1));
                String r = s.replace(r1,"");
                r = r.replace(r2,"");
                if (i == 1) {
                    // number 7
                    positions[0] = r;
                }
                if (i == 2) {
                    // number 4
                    positions[1] = r;
                    positions[3] = r;
                }
                if (s.length() == 6) {
                    String r3 = String.valueOf(positions[1].charAt(0));
                    String r4 = String.valueOf(positions[1].charAt(1));
                    String r5 = positions[0];

                    if (s.contains(r1) && s.contains(r2) && s.contains(r3) && s.contains(r4) && s.contains(r5)) {
                        // number 9
                        r = r.replace(r3,"");
                        r = r.replace(r4,"");
                        r = r.replace(r5,"");
                        positions[6] = r;
                        String s8 = signalPatterns[9];
                        s8 = s8.replace(r1,"");
                        s8 = s8.replace(r2,"");
                        s8 = s8.replace(r3,"");
                        s8 = s8.replace(r4,"");
                        s8 = s8.replace(r5,"");
                        s8 = s8.replace(positions[6], "");
                        positions[4] = s8;
                    }
                }
                if (s.length() == 5) {
                    if (s.contains(r1) && s.contains(r2) && positions[3].length() != 1) {
                        // number 3
                        r = r.replace(positions[0], "");
                        r = r.replace(positions[6], "");
                        positions[3] = r;
                        positions[1] = positions[1].replace(r, "");
                    }
                    if (s.contains(positions[1]) && positions[1].length() == 1) {
                        // number 5
                        String f = s.replace(positions[0], "");
                        f = f.replace(positions[1], "");
                        f = f.replace(positions[3], "");
                        f = f.replace(positions[6], "");
                        positions[5] = f;
                        positions[2] = positions[2].replace(f, "");

                    }
                }
            }
            String p[] = positions;
            String two = sortString(p[0]+p[2]+p[3]+p[4]+p[6]);
            String three = sortString(p[0]+p[2]+p[3]+p[5]+p[6]);
            String five = sortString(p[0]+p[1]+p[3]+p[5]+p[6]);
            String six = sortString(p[0]+p[1]+p[3]+p[4]+p[5]+p[6]);
            String zero = sortString(p[0]+p[1]+p[2]+p[4]+p[5]+p[6]);
            String nine = sortString(p[0]+p[1]+p[2]+p[3]+p[5]+p[6]);

            String outputDigits[] = digits[1].trim().split(" ");
            String strNum = "";
            for (int dig = 0; dig < outputDigits.length; dig++) {
                String str = sortString(outputDigits[dig]);
                if (str.compareTo(zero) == 0) {
                    strNum+="0";
                } else if (str.length() == 2) {
                    strNum+="1";
                } else if (str.compareTo(two) == 0) {
                    strNum+="2";
                } else if (str.compareTo(three) == 0) {
                    strNum+="3";
                } else if (str.length() == 4) {
                    strNum+="4";
                } else if (str.compareTo(five) == 0) {
                    strNum+="5";
                } else if (str.compareTo(six) == 0) {
                    strNum+="6";
                } else if (str.length() == 3) {
                    strNum+="7";
                } else if (str.length() == 7) {
                    strNum+="8";
                } else if (str.compareTo(nine) == 0) {
                    strNum+="9";
                }
            }
            c+=Integer.parseInt(strNum);
        }
        System.out.println(c);
    }
}
