public class Tree {
  private Node rootNode;
  private Node currentNode;
  
  public Tree(Node rootNode) {
    this.rootNode = rootNode; 
    this.currentNode = rootNode;
  }
  
  public void setAllChild(Node slideUp,Node slideDown,Node slideLeft,Node slideRight) {
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
 
  public Node getRootNode() {
    return rootNode;
  }
  
  public Node getCurrentNode() {
    return currentNode;
  }
     
  public void setRootNode(Node rootNode) {
    this.rootNode = rootNode;
  }
  
  public void setCurrentNode(Node currentNode) {
    this.currentNode = currentNode;
  }
}