//package com.ai;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A_Star_Search {
  private int[][] goal = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}};
  
  public A_Star_Search() {
        
  }
  
  public A_Star_Search(int[][] goal) {
        this.goal = goal;
  }

  private boolean isGoal(Node currentNode) {
    return Arrays.deepEquals(currentNode.getData().getTable(), goal);
  }
  
  //h1
  private int countWrongTile(Node currentNode) {
    int count = 0;
    for(int row = 0; row < 3;row++) {
      for(int col = 0; col < 3;col++) {
        if(currentNode.getData().getTable()[row][col] != goal[row][col]) {
          count++;
        } 
      }
    }
    return count;
  }
 

  private int getDistToGoal(Node node, int num) {
    int dist = -1;
    int[] nodeIndex = node.getData().getIndexOf(num);
    int[] goalIndex = {-1, -1};
    for(int row = 0; row < 3; row++) {
      for(int col = 0; col < 3; col++) {
        if(goal[row][col] == num) {
          goalIndex[0] = row;
          goalIndex[1] = col;
         break;
        } 
      }
    }
    dist = Math.abs(goalIndex[0] - nodeIndex[0]) + Math.abs(goalIndex[1] - nodeIndex[1]);
    return dist;
  }

  //h2
  private int computeCost(Node node) {
    int cost = 0;
    for(int i = 0; i < 9; i++) {                                                                                                                                                                                                                   
      cost += getDistToGoal(node, i);
    }
    return cost;
  }
  
  public Node search(Node challenge) {
    return null;
  }
  
  public boolean aStarSearch(Node rootNode) {
    CostComparator comparator = new CostComparator();
    PriorityQueue<Node> queue = new PriorityQueue<Node>(100, comparator);
    queue.add(rootNode);
    while(!queue.isEmpty()){
      Node currentNode =  queue.poll();      
      if (isGoal(currentNode)) {
        return true;
      } 
      else {
        expandNode(currentNode);
        if(currentNode.getSlideUp() != null) {
          queue.add(currentNode.getSlideUp());
        }
        if(currentNode.getSlideDown() != null) {
          queue.add(currentNode.getSlideDown());
        }
        if(currentNode.getSlideLeft() != null) {
          queue.add(currentNode.getSlideLeft());
        }
        if(currentNode.getSlideRight() != null) {
          queue.add(currentNode.getSlideRight());
        }
      }     
    }
    return false;
  }
  
  private void expandNode(Node currentNode) {
        if (currentNode.getData().canSlide('u')) {
            Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
            newTable.slide('u');
            Node newNode = new Node(newTable, currentNode.getDepth() + 1);
            newNode.setCostToGoal(countWrongTile(newNode));
            newNode.setPreviousNode(currentNode);
            currentNode.setSlideUp(newNode);
        }
        if (currentNode.getData().canSlide('d')) {
            Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
            newTable.slide('d');
             Node newNode = new Node(newTable, currentNode.getDepth() + 1);
            newNode.setCostToGoal(countWrongTile(newNode));
            newNode.setPreviousNode(currentNode);
            currentNode.setSlideDown(newNode);
        }
        if (currentNode.getData().canSlide('l')) {
            Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
            newTable.slide('l');
            Node newNode = new Node(newTable, currentNode.getDepth() + 1);
            newNode.setCostToGoal(countWrongTile(newNode));
            newNode.setPreviousNode(currentNode);
            currentNode.setSlideLeft(newNode);
        }
        if (currentNode.getData().canSlide('r')) {
            Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
            newTable.slide('r');
            Node newNode = new Node(newTable, currentNode.getDepth() + 1);
            newNode.setCostToGoal(countWrongTile(newNode));
            newNode.setPreviousNode(currentNode);
            currentNode.setSlideRight(newNode);
        }
   }
}