package com.ai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Puzzle_8 puzzle_8;
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Do you want to type your own value? y/n: ");
        char choice = inputScanner.next().charAt(0);
        if(choice == 'y') {
            System.out.println("Please enter the number.");
            int[][] input = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    input[i][j] = inputScanner.nextInt();
                }
            }
            puzzle_8 = new Puzzle_8(input);
        }
        else {
            puzzle_8 = new Puzzle_8();
            puzzle_8.shuffleTable(50);
        }
        puzzle_8.printTable();
    }
}
