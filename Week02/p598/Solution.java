package Week02.p598;

import java.util.*;

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

class Solution {
//    public List<Integer> preorder(Node root) {
//        // 递归写法
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        List<Integer> list = new ArrayList<>();
//        list.add(root.val);
//
//        if (root.children == null || root.children.size() == 0) {
//            return list;
//        }
//
//        for (Node child : root.children) {
//            list.addAll(preorder(child));
//        }
//
//        return list;
//    }

    public List<Integer> preorder(Node root) {
        // 迭代写法
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(root);

        while (stack.size() > 0) {
            Node node = stack.pop();
            list.add(node.val);
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4));

        System.out.println(new Solution().preorder(root));
    }
}
