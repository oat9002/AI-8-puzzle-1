//package com.ai;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long start;

        Puzzle_8 puzzle_8;
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Do you want to type your own value? y/n: ");
        char choice = inputScanner.next().charAt(0);
        if (choice == 'y') {
            System.out.println("Please enter the number.");
            int[][] input = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    input[i][j] = inputScanner.nextInt();
                }
            }
            puzzle_8 = new Puzzle_8(input);
        } else {
            puzzle_8 = new Puzzle_8();
            puzzle_8.shuffleTable(100);
        }
        start = Calendar.getInstance().getTimeInMillis();
        puzzle_8.printTable();
        Node rootNode = new Node(puzzle_8);
        A_Star_Search aStarSearch = new A_Star_Search();
        System.out.println(aStarSearch.aStarSearch(rootNode));
      
//         IDS_Search idsSearch = new IDS_Search();
//         Node answer = idsSearch.search(rootNode, 40);
//         if (answer != null) {
//             System.out.println("MISSION COMPLETE");
//             Node temp = answer;
//             int times = 0;
//             System.out.println("MOVE: " + times);
//             temp.getData().printTable();

//             while (temp.getNextNode() != null) {
//                 times++;
//                 System.out.println("MOVE: " + times);
//                 temp.getNextNode().getData().printTable();
//                 temp = temp.getNextNode();
//             }
//         } else {
//             System.out.println("DEFEAT!!");
//         }
        System.out.println("Time elapse: " + (Calendar.getInstance().getTimeInMillis() - start) + " ms");
    }
}
