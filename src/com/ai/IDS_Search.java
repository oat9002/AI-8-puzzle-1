//package com.ai;

import java.util.Arrays;
import java.util.HashSet;

public class IDS_Search {
    private int[][] goal = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}};

    HashSet<String> hashSet = new HashSet<>();

    public IDS_Search() {
    }

    public IDS_Search(int[][] goal) {
        this.goal = goal;
    }


    public Node search(Node challenge, int maxDepth) {
        Node rootNode = new Node(challenge.getData());
        for (int depth = 0; depth < maxDepth; depth++) {
            System.out.print("Depth " + depth+" ... ");
            if (depthLimitSearch(rootNode, depth, 0)) {
                //succeed
               System.out.println("Found");
                return rootNode;
            }
            System.out.println("Complete");
        }
        //failure
        return null;
    }

    private boolean depthLimitSearch(Node currentNode, int maxDepth, int currentDepth) {

        if (currentNode != null) {
//            currentNode.getData().printTable();
            if (isGoal(currentNode)) {
                return true;
            } else if (maxDepth == currentDepth) {
                return false;
            } else {
                hashSet.add(currentNode.getData().getSequence());
                expandNode(currentNode);
                if (depthLimitSearch(currentNode.getSlideUp(), maxDepth, currentDepth + 1)) {
                    currentNode.setNextNode(currentNode.getSlideUp());
                    return true;
                }
                if (depthLimitSearch(currentNode.getSlideDown(), maxDepth, currentDepth + 1)) {
                    currentNode.setNextNode(currentNode.getSlideDown());
                    return true;
                }
                if (depthLimitSearch(currentNode.getSlideLeft(), maxDepth, currentDepth + 1)) {
                    currentNode.setNextNode(currentNode.getSlideLeft());
                    return true;
                }
                if (depthLimitSearch(currentNode.getSlideRight(), maxDepth, currentDepth + 1)) {
                    currentNode.setNextNode(currentNode.getSlideRight());
                    return true;
                }
                if (currentNode.getSlideUp() != null) {
                    hashSet.remove(currentNode.getSlideUp().getData().getSequence());
                }
                if (currentNode.getSlideDown() != null) {
                    hashSet.remove(currentNode.getSlideDown().getData().getSequence());
                }
                if (currentNode.getSlideLeft() != null) {
                    hashSet.remove(currentNode.getSlideLeft().getData().getSequence());
                }
                if (currentNode.getSlideRight() != null) {
                    hashSet.remove(currentNode.getSlideRight().getData().getSequence());
                }
                currentNode.freeAllChild();
            }
        }
        return false;
    }

    private void expandNode(Node currentNode) {
        if (currentNode.getData().canSlide('u')) {
            Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
            newTable.slide('u');
            if (!hashSet.contains(newTable.getSequence())) {
                Node newNode = new Node(newTable);
                currentNode.setSlideUp(newNode);
            }
        }
        if (currentNode.getData().canSlide('d')) {
            Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
            newTable.slide('d');
            if (!hashSet.contains(newTable.getSequence())) {
                Node newNode = new Node(newTable);
                currentNode.setSlideDown(newNode);
            }
        }
        if (currentNode.getData().canSlide('l')) {
            Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
            newTable.slide('l');
            if (!hashSet.contains(newTable.getSequence())) {
                Node newNode = new Node(newTable);
                currentNode.setSlideLeft(newNode);
            }
        }
        if (currentNode.getData().canSlide('r')) {
            Puzzle_8 newTable = new Puzzle_8(currentNode.getData().getTable());
            newTable.slide('r');
            if (!hashSet.contains(newTable.getSequence())) {
                Node newNode = new Node(newTable);
                currentNode.setSlideRight(newNode);
            }
        }
    }

    private boolean isGoal(Node currentNode) {
        return Arrays.deepEquals(currentNode.getData().getTable(), goal);
    }

}