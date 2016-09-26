package com.ai;

public class Node {
    private Puzzle_8 data = null;
    private Node previousNode = null;
    private Node nextNode = null;
    private Node slideUp = null;
    private Node slideDown = null;
    private Node slideLeft = null;
    private Node slideRight = null;
    private int costToGoal = -1;
    private int depth = 0;
  
    public Node() {
    }

    public Node(Puzzle_8 data) {
        this.data = data;
    }

    public Node(Puzzle_8 data, int depth){
      this.data = data;
      this.depth = depth;
    }
  
    public void setData(Puzzle_8 data) {
        this.data = data;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
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
  
    public int getCostToGoal() {
      return costToGoal;
    }
  
    public void setCostToGoal(int costToGoal) {
      this.costToGoal = costToGoal;
    }
  
    public int getDepth() {
      return depth;
    }

    public void setDepth(int depth) {
      this.depth = depth;
    }
  
    public void setAllChild(Node slideUp, Node slideDown, Node slideLeft, Node slideRight) {
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