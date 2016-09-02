import java.util.Arrays;

public class IDS_Search {
  private int[][] goal = new int[][]{{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 0}};
  
  public IDS_Search(int[][] table) {
    
    
  }
   
  public Tree search(Node currentNode, int maxDepth) {
    
    for(int depth = 0; depth < maxDepth; i++) {
      if(!isGoal(currentNode)) {    
        //failure
      } else {

        //succeed
      }         
    }
    return null;
  }
  
  private Tree depthLimitSearch(Tree subTree, int maxDepth, int currentDepth) {
    Node currentNode = subTree.getCurrentNode();
    
    if(currentNode != null){        
      if(isGoal(currentNode)) {
        return Tree;
      }
      else if(maxDepth == currentDepth) {                                                                                                               
        return null;
      }
      else {
        
        depthLimitSearch(limitedTree.getCurrentNode().getSlideUp(), maxDepth, currentDepth + 1);
        depthLimitSearch(limitedTree.getCurrentNode().getSlideDown(), maxDepth, currentDepth + 1);
        depthLimitSearch(limitedTree.getCurrentNode().getSlideLeft(), maxDepth, currentDepth + 1);
        depthLimitSearch(limitedTree.getCurrentNode().getSlideRight(), maxDepth, currentDepth + 1);
      }
      
    }
  }
  
  private void expandTree(Tree subTree) {
    
    if(subTree.canSlide('u')) {
      Puzzle_8 newTable = new Puzzle_8(subTree.getTable());
      currentNode.setSlideUp(newTable.slide('u') == true ? newTable.getData() : null);
    }
    if(subTree.canSlide('d')) {
      Puzzle_8 newTable = new Puzzle_8(subTree.getTable());
      currentNode.setSlideUp(newTable.slide('d') == true ? newTable.getData() : null);
    }
    if(subTree.canSlide('l')) {
      Puzzle_8 newTable = new Puzzle_8(subTree.getTable());
      currentNode.setSlideUp(newTable.slide('l') == true ? newTable.getData() : null);
    }
    if(subTree.canSlide('r')) {
      Puzzle_8 newTable = new Puzzle_8(subTree.getTable());
      currentNode.setSlideUp(newTable.slide('r') == true ? newTable.getData() : null);
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