package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ptOne();
        ptTwo();
    }
    static void ptOne() {
        String boards[] = Input.input.split("\\r?\\n");
        HashMap<String,Integer> points = new HashMap<String,Integer>();
        int c = 0;
        bLoop: for (String i : boards)  {
            String coords[] = i.split(" -> ");
            String one[] = coords[0].split(",");
            String two[] = coords[1].split(",");
            int x1 = Integer.parseInt(one[0]);
            int y1 = Integer.parseInt(one[1]);
            int x2 = Integer.parseInt(two[0]);
            int y2 = Integer.parseInt(two[1]);
            if (((x1 == x2) == false) && ((y1 == y2) == false)) {
                continue bLoop;
            }
            if (x1 == x2) {
                if (y1 > y2) {
                    int temp = y2;
                    y2 = y1;
                    y1 = temp;
                }
                for (int y = y1; y <= y2; y++) {
                    String p = String.valueOf(x1) + "," + String.valueOf(y);
                    if (points.containsKey(p) == true) {
                        points.put(p, points.get(p) + 1);
                    } else {
                        points.put(p,1);
                    }
                }
            }
            if (y1 == y2) {
                if (x1 > x2) {
                    int temp = x2;
                    x2 = x1;
                    x1 = temp;
                }
                for (int x = x1; x <= x2; x++) {
                    String p = String.valueOf(x) + "," + String.valueOf(y1);
                    if (points.containsKey(p) == true) {
                        points.put(p, points.get(p) + 1);
                    } else {
                        points.put(p,1);
                    }
                }
            }
        }

        for (String i : points.keySet()) {
            if (points.get(i) >= 2) {
                c++;
            }
        }
        System.out.println(c);
    }

    static void ptTwo() {
        String boards[] = Input.input.split("\\r?\\n");
        HashMap<String,Integer> points = new HashMap<String,Integer>();
        int c = 0;
        bLoop: for (String i : boards)  {
            String coords[] = i.split(" -> ");
            String one[] = coords[0].split(",");
            String two[] = coords[1].split(",");
            int x1 = Integer.parseInt(one[0]);
            int y1 = Integer.parseInt(one[1]);
            int x2 = Integer.parseInt(two[0]);
            int y2 = Integer.parseInt(two[1]);

            int inc = Math.abs(x1-x2);
            if (x1 == x2) {
                inc = Math.abs(y1-y2);
            } else if (y1==y2) {
                inc = Math.abs(x1-x2);
            }
            for (int x = 0; x <= inc; x++) {
                String p = "";
                String xp = "";
                String yp = "";
                if (x1 == x2) {
                    xp = String.valueOf(x1);
                } else if (x1 > x2) {
                    xp = String.valueOf(x1 -x);
                } else if (x1 < x2) {
                    xp = String.valueOf(x1+x);
                }
                if (y1 == y2) {
                    yp = String.valueOf(y1);
                } else if (y1 > y2) {
                    yp = String.valueOf(y1-x);
                } else if (y1 < y2) {
                    yp = String.valueOf(y1+x);
                }
                p = xp + "," + yp;
                if (points.containsKey(p) == true) {
                    points.put(p, points.get(p) + 1);
                } else {
                    points.put(p,1);
                }
            }

        }

        for (String i : points.keySet())
            if (points.get(i) >= 2) c++;
        System.out.println(c);

    }
}
