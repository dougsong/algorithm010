package com.zhenran.leetcode.p144;

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
//    public List<Integer> preorderTraversal(TreeNode root) {
//        // 递归写法
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        List<Integer> resultList = new ArrayList<>();
//        resultList.add(root.val);
//        resultList.addAll(preorderTraversal(root.left));
//        resultList.addAll(preorderTraversal(root.right));
//
//        return resultList;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代写法
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(root);

        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}
