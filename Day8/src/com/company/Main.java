package com.company;

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
                        System.out.println(outputDigits[i]);
                        c++;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(c);
    }

    static void ptTwo() {

    }
}
