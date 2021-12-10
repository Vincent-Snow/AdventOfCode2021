package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    ptOne();
        ptTwo();
    }

    static void ptOne() {
        String boards[] = Input.input.split("\\r?\\n\n");
        String called[] = boards[0].split(",");
        String boards3d[][][] = new String[boards.length-1][5][5];

        for (int i = 1; i < boards.length; i++) {
            String lines[] = boards[i].split("\\r?\\n");
            for (int j = 0; j < lines.length; j++) {
                String nums[] = lines[j].trim().split("\\s+");
                for (int k = 0; k < nums.length; k++) {
                    boards3d[i-1][j][k] = nums[k];
                }

            }
        }

        cLoop: for ( int c = 0; c < called.length;c++) {
            for (int i = 0; i < boards3d.length; i++) {
                for (int y = 0; y < boards3d[i].length; y++) {
                    for (int x = 0; x < boards3d[i][y].length; x++) {
                        if (called[c].equals(boards3d[i][y][x])) {
                            boards3d[i][y][x] = "xx";
                            int n = 0;
                            w: while (n < 5) {
                                if (!boards3d[i][y][n].equals("xx")) {
                                    break w;
                                }
                                if (n == 4) {
                                    int winner = Integer.parseInt(called[c]);
                                    System.out.println(called[c]);
                                    int sum = 0;
                                    for (int x1 = 0; x1 < 5; x1++) {
                                        for (int y1 = 0; y1 < 5; y1++) {
                                            if (!boards3d[i][y1][x1].equals("xx")) {
                                                sum+= Integer.parseInt(boards3d[i][y1][x1]);
                                            }
                                        }
                                    }
                                    System.out.println(sum*winner);
                                    break cLoop;
                                }

                                n++;
                            }
                            n = 0;
                            w: while (n < 5) {
                                if (!boards3d[i][n][x].equals("xx")) {
                                    break w;
                                }
                                if (n == 4) {
                                    int winner = Integer.parseInt(called[c]);
                                    System.out.println(called[c]);
                                    int sum = 0;
                                    for (int x1 = 0; x1 < 5; x1++) {
                                        for (int y1 = 0; y1 < 5; y1++) {
                                            if (!boards3d[i][y1][x1].equals("xx")) {
                                                sum+= Integer.parseInt(boards3d[i][y1][x1]);
                                            }
                                        }
                                    }
                                    System.out.println(sum*winner);
                                    break cLoop;
                                }
                                n++;
                            }
                        }
                    }
                }
            }
        }
    }

    static void ptTwo() {

        String boards[] = Input.input.split("\\r?\\n\n");
        String called[] = boards[0].split(",");
        String boards3d[][][] = new String[boards.length-1][5][5];

        for (int i = 1; i < boards.length; i++) {
            String lines[] = boards[i].split("\\r?\\n");

            for (int j = 0; j < lines.length; j++) {
                String nums[] = lines[j].trim().split("\\s+");
                for (int k = 0; k < nums.length; k++) {
                    boards3d[i-1][j][k] = nums[k];
                }

            }
        }

        int sum = 0;
        int winner = 0;

        HashMap<Integer,Boolean> solved = new HashMap<Integer,Boolean>();
        cLoop: for ( int c = 0; c < called.length;c++) {
            iLoop: for (int i = 0; i < boards3d.length; i++) {

                if (solved.containsKey(i)) {
                    continue iLoop;
                }
                for (int y = 0; y < boards3d[i].length; y++) {
                    for (int x = 0; x < boards3d[i][y].length; x++) {
                        if (called[c].equals(boards3d[i][y][x])) {
                            boards3d[i][y][x] = "xx";
                            int n = 0;
                            w: while (n < 5) {
                                if (boards3d[i][y][n].equals("xx") == false) {
                                    break w;
                                }
                                if (n == 4) {
                                    winner = Integer.parseInt(called[c]);

                                    sum = 0;
                                    for (int x1 = 0; x1 < 5; x1++) {
                                        for (int y1 = 0; y1 < 5; y1++) {
                                            if (boards3d[i][y1][x1].equals("xx") == false) {
                                                sum+= Integer.parseInt(boards3d[i][y1][x1]);

                                            }
                                        }
                                    }
                                    solved.put(i,true);
                                    continue iLoop;
                                }

                                n++;
                            }
                            n = 0;
                            w: while (n < 5) {
                                if (boards3d[i][n][x].equals("xx") == false) {
                                    break w;
                                }
                                if (n == 4) {
                                    winner = Integer.parseInt(called[c]);

                                    sum = 0;
                                    for (int x1 = 0; x1 < 5; x1++) {
                                        for (int y1 = 0; y1 < 5; y1++) {
                                            if (boards3d[i][y1][x1].equals("xx") == false) {
                                                sum+= Integer.parseInt(boards3d[i][y1][x1]);

                                            }
                                        }
                                    }
                                    solved.put(i,true);
                                    continue iLoop;
                                }
                                n++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sum*winner);
    }
}
