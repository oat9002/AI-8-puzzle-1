package com.ai;
public class Node {
  private Puzzle_8 data;
  private Node nextNode;
  private Node slideUp;
  private Node slideDown;
  private Node slideLeft;
  private Node slideRight;
  
  public Node() {
    data = null;
    nextNode = null;
    slideUp = null;
    slideDown = null;
    slideLeft = null;
    slideRight = null;
  }
  
  public Node(Puzzle_8 data) {
    this.data = data;
    nextNode = null;
    slideUp = null;
    slideDown = null;
    slideLeft = null;
    slideRight = null;
  }
  
  public void setData(Puzzle_8 data) {
    this.data = data;
  }
  
  public Node getNextNode() {
    return nextNode;
  }
  
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
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
  
  public void setAllChild(Node slideUp,Node slideDown,Node slideLeft,Node slideRight) {
    setSlideUp(slideUp);
    setSlideDown(slideDown);
    setSlideLeft(slideLeft);
    setSlideRight(slideRight);
  }
  
  public void freeAllChild() {
    setSlideUp(null);
    setSlideDown(null);
    setSlideLeft(null);
    setSlideRight(null);
  }
  
}