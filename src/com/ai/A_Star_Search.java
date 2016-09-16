import java.util.Arrays;

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

  private int computeCost(Node node) {
    int cost = 0;
    for(int i = 0; i < 9; i++) {                                                                                                                                                                                                                   
      cost += getDistToGoal(node, i);
    }
    return cost;
  }
  
//   private void expandNode(Node currentNode) {
//         if (currentNode.getData().canSlide('u')) {
//             Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
//             newTable.slide('u');
//             if (!hashSet.contains(newTable.getSequence())) {
//                 Node newNode = new Node(newTable);
//                 currentNode.setSlideUp(newNode);
//             }
//         }
//         if (currentNode.getData().canSlide('d')) {
//             Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
//             newTable.slide('d');
//             if (!hashSet.contains(newTable.getSequence())) {
//                 Node newNode = new Node(newTable);
//                 currentNode.setSlideDown(newNode);
//             }
//         }
//         if (currentNode.getData().canSlide('l')) {
//             Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
//             newTable.slide('l');
//             if (!hashSet.contains(newTable.getSequence())) {
//                 Node newNode = new Node(newTable);
//                 currentNode.setSlideLeft(newNode);
//             }
//         }
//         if (currentNode.getData().canSlide('r')) {
//             Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
//             newTable.slide('r');
//             if (!hashSet.contains(newTable.getSequence())) {
//                 Node newNode = new Node(newTable);
//                 currentNode.setSlideRight(newNode);
//             }
//         }
//    }
}