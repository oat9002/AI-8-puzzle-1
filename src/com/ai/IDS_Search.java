import java.util.Arrays;

public class IDS_Search {
  private int[][] goal = new int[][]{{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 0}};
  
  public IDS_Search(int[][] table) {
    
    
  }
   
  public Node search(Node currentNode, int maxDepth) {
    
    for(int depth = 0; depth < maxDepth; depth++) {
      if(!isGoal(currentNode)) {    
        //failure
      } else {

        //succeed
      }         
    }
    return null;
  }
  
  private Node depthLimitSearch(Node currentNode, int maxDepth, int currentDepth) {
    
    if(currentNode != null){        
      if(isGoal(currentNode)) {
        return currentNode;
      }
      else if(maxDepth == currentDepth) {                                                                                                               
        return null;
      }
      else {
        expandNode(currentNode);
        depthLimitSearch(currentNode.getSlideUp(), maxDepth, currentDepth + 1);
        depthLimitSearch(currentNode.getSlideDown(), maxDepth, currentDepth + 1);
        depthLimitSearch(currentNode.getSlideLeft(), maxDepth, currentDepth + 1);
        depthLimitSearch(currentNode.getSlideRight(), maxDepth, currentDepth + 1);
      }   
    }
    return null;
  }
  
  private void expandNode(Node currentNode) {
    if(currentNode.getData().canSlide('u')) {
      Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
      newTable.slide('u');
      Node newNode = new Node(newTable);
      newNode.setPreviousNode(currentNode);
      currentNode.setSlideUp(newNode);
    }
    if(currentNode.getData().canSlide('d')) {
      Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
      newTable.slide('d');
      Node newNode = new Node(newTable);
      newNode.setPreviousNode(currentNode);
      currentNode.setSlideUp(newNode);
    }
    if(currentNode.getData().canSlide('l')) {
      Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
      newTable.slide('l');
      Node newNode = new Node(newTable);
      newNode.setPreviousNode(currentNode);
      currentNode.setSlideUp(newNode);
    }
    if(currentNode.getData().canSlide('r')) {
      Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
      newTable.slide('r');
      Node newNode = new Node(newTable);
      newNode.setPreviousNode(currentNode);
      currentNode.setSlideUp(newNode);
    }
  }
  
  private boolean isGoal(Node currentNode) {
    if(Arrays.equals(currentNode.getData().getTable(), goal)) {
      return true;
    }
    else {
      return false;
    }
  }
  
}