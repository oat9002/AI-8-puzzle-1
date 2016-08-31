import java.util.Arrays;

public class IDS_Search {
  private int[][] goal = new int[][]{{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 0}};
  
  public IDS_Search(int[][] table) {
    
    
  }
   
  public Tree search(Node currentNode, int depth) {
    for(int i = 0; i < depth; i++) {
      if(!isGoal(currentNode)) {
        //succeed
      } else {
      
      }         
    }
    return null;
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