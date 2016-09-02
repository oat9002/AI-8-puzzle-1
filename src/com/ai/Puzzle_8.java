//package com.ai;

import java.util.Random;

/**
 * Created by oat on 8/29/16.
 */
public class Puzzle_8 {
    private int[][] table;
    private int empTile[];
   
    public Puzzle_8() {
        table = new int[3][3];
        empTile = new int[2];
        initialTable(table);
    }

    public Puzzle_8(int[][] input) {
        table = new int[3][3];
        empTile = new int[2];
        for(int i = 0; i < 3;i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = input[i][j];
            }
        }
        for(int i = 0; i < 3;i++) {
            for (int j = 0; j < 3; j++) {
                if(table[i][j] == 0) {
                    empTile[0] = i;
                    empTile[1] = j;
                    break;
                }
            }
        }
    }

    private void initialTable(int[][] table) {
        int count = 1;
        empTile[0] = 2;
        empTile[1] = 2;
        for(int i = 0; i < 3;i++) {
            for (int j = 0; j < 3; j++) {
                if (count != 9) {
                    table[i][j] = count++;
                } else {
                    table[i][j] = 0;
                }
            }
        }
    }

    public void shuffleTable(int times) {
        Random randomizer = new Random();
        while(times > 0){
            int direction = randomizer.nextInt(4);
            switch (direction){
                case 0:
                    if(slide('u')) times--;
                    break;
                case 1:
                    if(slide('d')) times--;
                    break;
                case 2:
                    if(slide('l')) times--;
                    break;
                case 3:
                    if(slide('r')) times--;
                    break;
                default: System.out.print("ERROR!!!!!! OAT NOOB GG");
            }
        }
    }

  //check if table can slide
    public boolean canSlide(char direction){
        boolean slideable = true;

        switch(direction) {
            case ('u'):
                if(empTile[1]==0) slideable = false;
                break;
            case ('d'):
                if(empTile[1]==2) slideable = false;
                break;
            case ('l'):
                if(empTile[0]==0) slideable = false;
                break;
            case ('r'):
                if(empTile[0]==2) slideable = false;
                break;
            default:
                System.out.println("Command not found");
        }
        return slideable;
    }

    // u d l r
    public void slide(char direction){
        int[] tempTile = new int[2];
        if(canSlide(direction)) {
            switch(direction) {
                case ('u'):
                    tempTile[0] = empTile[0];
                    tempTile[1] = empTile[1]-1;
                    break;
                case ('d'):
                    tempTile[0] = empTile[0];
                    tempTile[1] = empTile[1]+1;
                    break;
                case ('l'):
                    tempTile[0] = empTile[0]-1;
                    tempTile[1] = empTile[1];
                    break;
                case ('r'):
                    tempTile[0] = empTile[0]+1;
                    tempTile[1] = empTile[1];
                    break;
                default:
                    System.out.println("Command not found");
            }
            swap(tempTile);
        }
    }

    private void swap(int[] tile){
        int temp = table[tile[0]][tile[1]];
        table[tile[0]][tile[1]] = 0;
        table[empTile[0]][empTile[1]] = temp;
        empTile[0] = tile[0];
        empTile[1] = tile[1];
    }

    public void printTable(){
        for(int i=0 ;i<3;i++){
            for(int j=0;j<3;j++){
                if(table[i][j]==0)
                {
                    System.out.print("  ");
                }
                else {
                    System.out.print(table[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println("----------");
    }
  
  public int[][] getTable() {
    return table;
  }
}
