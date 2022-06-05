package com.graph.binarytree.algorithms;
//https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/IntervalTree.java
//https://www.youtube.com/user/algorithmscourses/playlists
//https://www.youtube.com/watch?v=E-9b8k7JK6I

public class IntervalTree {

    public InternalNode insert(InternalNode root, int low, int high) {
        if(root == null) {
            InternalNode node = new InternalNode();
            node.low = low;
            node.high = high;
            node.max = high;
            return node;
        }

        if(low < root.low) {
            root.left = insert(root.left, low, high);
        } else {
            root.right = insert(root.right, low, high);
        }

        root.max = Math.max(root.high, high);
        return root;
    }

    public InternalNode isOverlap(InternalNode root, int low, int high) {
        if(root == null) {
            return null;
        }

        if(root.high >= low && root.low <= high) {
            return root;
        }

        if(root.left != null && root.left.max > low) {
            return isOverlap(root.left, low, high);
        } else {
            return isOverlap(root.right, low, high);
        }
    }

    public static void main(String args[]) {
        IntervalTree it = new IntervalTree();
        InternalNode root = null;
        root = it.insert(root, 10, 15);
        root = it.insert(root, 11, 13);
        root = it.insert(root, 18, 21);
        root = it.insert(root, 20, 25);
        root = it.insert(root, 0, 7);

        System.out.println(it.isOverlap(root, 8, 9));
        System.out.println(it.isOverlap(root, 17, 17));
        System.out.println(it.isOverlap(root, 21, 22));
        System.out.println(it.isOverlap(root, 21, 22));
        System.out.println(it.isOverlap(root, 12, 18));
        System.out.println(it.isOverlap(root, 24, 26));
    }

}

class InternalNode {
    int low;
    int high;
    int max;
    InternalNode left;
    InternalNode right;

    @Override
    public String toString() {
        return "InternalNode{" +
                "max=" + max +
                ", low=" + low +
                ", high=" + high +
                '}';
    }
}
