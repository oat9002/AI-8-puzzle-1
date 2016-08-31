public class Tree {
  private Node rootNode;
  private Node currentNode;
  
  public Tree(Node rootNode) {
    this.rootNode = rootNode; 
    this.currentNode = rootNode;
  }
  
  public void expand(Node slideUp,Node slideDown,Node slideLeft,Node slideRight) {
    currentNode.setSlideUp(slideUp);
    currentNode.setSlideDown(slideDown);
    currentNode.setSlideLeft(slideLeft);
    currentNode.setSlideRight(slideRight);
  }
  
  public void freeAllChild() {
    currentNode.setSlideUp(null);
    currentNode.setSlideDown(null);
    currentNode.setSlideLeft(null);
    currentNode.setSlideRight(null);
  }
 
}