package com.zhenran.leetcode.p429;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
//    public List<List<Integer>> levelOrder(Node root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        Stack<Node> stack = new Stack<>();
//        List<List<Integer>> resultList = new ArrayList<>();
//        stack.push(root);
//
//        while (stack.size() > 0) {
//            List<Integer> tmpList = new ArrayList<>();
//            List<Node> child = new ArrayList<>();
//            while (stack.size() > 0) {
//                Node node = stack.pop();
//                tmpList.add(node.val);
//                if (node.children != null && node.children.size() > 0) {
//                    child.addAll(node.children);
//                }
//            }
//            resultList.add(tmpList);
//            for (int i = child.size() - 1; i >= 0; i--) {
//                stack.push(child.get(i));
//            }
//        }
//
//        return resultList;
//    }

    public List<List<Integer>> levelOrder(Node root) {
        // 递归方式
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(root.val));
        list.addAll(bfs(root.children));

        return list;
    }

    private List<List<Integer>> bfs(List<Node> children) {
        if (children == null || children.size() <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        for (Node child : children) {
            list.add(child.val);
            nodeList.addAll(child.children);
        }

        resultList.add(list);

        List<List<Integer>> bfs = bfs(nodeList);
        resultList.addAll(bfs);

        return resultList;
    }
}
