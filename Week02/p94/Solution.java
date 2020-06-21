package com.zhenran.leetcode.p94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        // 递归算法
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        List<Integer> list = new ArrayList<>(inorderTraversal(root.left));
//        list.add(root.val);
//        list.addAll(inorderTraversal(root.right));
//
//        return list;
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // 迭代算法
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            resultList.add(node.val);
            node = node.right;
        }

        return resultList;
    }
}
