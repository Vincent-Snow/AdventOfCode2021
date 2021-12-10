package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }

    static void ptOne() {
        Scanner sc = new Scanner(Input.input);
        ArrayList<String> arr = new ArrayList<String>();
        String gammaBin = "";
        int gammaDec;
        String epsBin = "";
        int epsDec;
        while (sc.hasNext()) {
            String token = sc.next();
            arr.add(token);
        }

        jLoop: for (int j = 0; j < arr.get(0).length(); j++) {
            int zeroC = 0;
            int oneC = 0;
            iLoop: for (int i = 0; i < arr.size(); i++) {
                String binNum = arr.get((i));
                if (binNum.charAt(j) == '1') {
                    oneC++;
                } else {
                    zeroC++;
                }
                if (oneC > arr.size()/2) {
                    gammaBin = gammaBin + "1";
                    continue jLoop;
                } else if (zeroC > arr.size()/2) {
                    gammaBin = gammaBin + "0";
                    continue jLoop;
                }
            }

        }
        for (int i = 0; i < gammaBin.length(); i++) {
            if (gammaBin.charAt(i) == '1') {
                epsBin = epsBin + '0';
            } else {
                epsBin = epsBin + '1';
            }
        }
        gammaDec = Integer.parseInt(gammaBin,2);
        epsDec = Integer.parseInt(epsBin,2);
        System.out.println(epsDec*gammaDec);
    }

    static void ptTwo() {
        Scanner sc = new Scanner(Input.input);
        ArrayList<String> arrConst = new ArrayList<String>();
        while (sc.hasNext()) {
            String token = sc.next();
            arrConst.add(token);
        }
        ArrayList<String> arr = arrConst;

        jLoop: for (int j = 0; j < arrConst.get(0).length(); j++) {
            ArrayList<String> moreOnesArr = new ArrayList<String>();
            ArrayList<String> moreZerosArr = new ArrayList<String>();
            iLoop: for (int i = 0; i < arr.size(); i++) {
                String binNum = arr.get((i));
                if (binNum.charAt(j) == '1') {
                    moreOnesArr.add(arr.get(i));
                } else {
                    moreZerosArr.add(arr.get(i));
                }
            }
            if (moreOnesArr.size() >= moreZerosArr.size()) {
                arr = moreOnesArr;
            } else {
                arr = moreZerosArr;
            }
            if (arr.size() == 1) {
                break jLoop;
            }
        }
        int o2dec = Integer.parseInt(arr.get(0),2);
        arr = arrConst;

        jLoop: for (int j = 0; j < arrConst.get(0).length(); j++) {
            ArrayList<String> fewerOnesArr = new ArrayList<String>();
            ArrayList<String> fewerZerosArr = new ArrayList<String>();
            iLoop: for (int i = 0; i < arr.size(); i++) {
                String binNum = arr.get((i));
                if (binNum.charAt(j) == '1') {
                    fewerOnesArr.add(arr.get(i));
                } else {
                    fewerZerosArr.add(arr.get(i));
                }
            }

            if (fewerOnesArr.size() < fewerZerosArr.size()) {
                arr = fewerOnesArr;
            } else {
                arr = fewerZerosArr;
            }
            if (arr.size() == 1) {
                break jLoop;
            }
        }
        int co2dec = Integer.parseInt(arr.get(0),2);
        System.out.println(o2dec*co2dec);
    }
}
