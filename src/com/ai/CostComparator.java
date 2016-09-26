package com.ai;

import java.util.Comparator;

public class CostComparator implements Comparator<Node> {
  
   @Override
   public int compare(Node t1, Node t2) {
      return (t1.getCostToGoal() + t1.getDepth()) - (t2.getCostToGoal() + t2.getDepth());
   }
}