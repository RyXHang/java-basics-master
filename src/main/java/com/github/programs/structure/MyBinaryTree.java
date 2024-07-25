package com.github.programs.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class MyBinaryTree {

    private TreeNode root;

    public MyBinaryTree(Integer[] arr) {
        this.root = buildTree(arr);
    }
    public TreeNode buildTree(Integer[] arr) {
        return buildTree(arr, 0);
    }

    public TreeNode buildTree(Integer[] arr, int index){
        // 异常处理
        if (index < 0 || index >= arr.length) {
            return null;
        }

        if (arr[index] == null) return null;

        // 建立一个新的节点
        TreeNode newNode = new TreeNode(arr[index]);
        newNode.left = buildTree(arr, 2 * index + 1);
        newNode.right = buildTree(arr,  2 * index + 2);
        return newNode;
    }

    public List<List<Integer>> levelOrder() {
        // 初始化结果数组
        List<List<Integer>> result = new ArrayList<>();

        // 特判-简枝
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i ++) {
                TreeNode t = q.poll();
                level.add(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            result.add(level);
        }
        return result;
    }

    public void printLevelOrder() {
        List<List<Integer>> levels = levelOrder();
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> level = levels.get(i);
            System.out.print("Level " + i + ": ");
            for (Integer value : level) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {this.val = val;}

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // Example array to construct the binary tree
        Integer[] arr = {1, 2, 3, 4, null, 5, 6};

        // Create the binary tree from the array
        MyBinaryTree myBinaryTree = new MyBinaryTree(arr);

        myBinaryTree.printLevelOrder();
    }
}
