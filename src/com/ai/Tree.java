public class Tree(){
  private Node rootNode;
  private Node currentNode;
  public Tree(Node rootNode){
    this.rootNode = rootNode; 
    this.currentNode = rootNode;
  }
  
  public void expand(Node slideUp,Node slideDown,Node slideLeft,Node slideRight){
    currentNode.setSlideUp(slideUp);
    currentNode.setSlideDown(slideDown);
    currentNode.setSlideLeft(slideLeft);
    currentNode.setSlideRight(slideRight);
  }
  
  public void killEmAll(){
    currentNode.setSlideUp(null);
    currentNode.setSlideDown(null);
    currentNode.setSlideLeft(null);
    currentNode.setSlideRight(null);
  }
}

public class Node(){
  private Puzzle_8 data;
  private Node slideUp;
  private Node slideDown;
  private Node slideLeft;
  private Node slideRight;
  
  public Node(Puzzle_8 data){
    this.data = data;
  }
  
  public void setData(Puzzle_8 data) {
    this.data = data;
  }
  
  public void setSlideUp(Node slideUp) {
    this.slideUp = slideUp;
  }
  
  public void setSlideDown(Node slideDown) {
    this.slideDown = slideDown;
  }
  
  public void setSlideLeft(Node slideLeft) {
    this.slideLeft = slideLeft;
  }
  
  public void setSlideRight(Node slideRight) {
    this.slideRight = slideRight;
  }
    
  public Puzzle_8 getData() {
    return data;
  }
  
  public Node getSlideUp() {
    return slideUp;
  }
  
  public Node getSlideDown() {
    return slideDown;
  }
  
  public Node getSlideLeft() {
    return slideLeft;
  }
  public Node getSlideRight() {
    return slideRight;
  }
}