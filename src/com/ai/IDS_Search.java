import java.util.Arrays;

public class IDS_Search {
  private int[][] goal = new int[][]{{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 0}};
  
  public IDS_Search() {}
  
  public IDS_Search(int[][] goal) {
    this.goal = goal;
  }
  
   
  public Node search(Node rootNode, int maxDepth) {
    Node goal;
    for(int depth = 0; depth < maxDepth; depth++) {
      goal = depthLimitSearch(rootNode, depth, 0);
      if(goal != null) {    
        //succeed
        return goal;
      }
      System.out.println("depth: " + depth);
    }
    //failure
    return null;
  }
  
  private Node depthLimitSearch(Node currentNode, int maxDepth, int currentDepth) {
    
    if(currentNode != null){     
      currentNode.getData().printTable();
      if(isGoal(currentNode)) {
        return currentNode;
      }
      else if(maxDepth == currentDepth) {                                                                                                               
        return null;
      }
      else {
        expandNode(currentNode);
        if(depthLimitSearch(currentNode.getSlideUp(), maxDepth, currentDepth + 1)!=null){
           return currentNode.getSlideUp();
        }
        if(depthLimitSearch(currentNode.getSlideDown(), maxDepth, currentDepth + 1)!=null){
           return currentNode.getSlideDown();
        }
        if(depthLimitSearch(currentNode.getSlideLeft(), maxDepth, currentDepth + 1)!=null){
           return currentNode.getSlideLeft();
        }
        if(depthLimitSearch(currentNode.getSlideRight(), maxDepth, currentDepth + 1)!=null){
           return currentNode.getSlideRight();
        }
        currentNode.freeAllChild();
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