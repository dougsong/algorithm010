package Week03.p105;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * @author songzheng
 */
public class Solution {

    private Map<Integer, Integer> value2IndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        value2IndexMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            value2IndexMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
//        int rootValIndex = indexOf(inorder, rootVal);
        int rootValIndex = value2IndexMap.get(rootVal);

        int leftTreeNodeCount = rootValIndex - inLeft;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorder, preLeft + 1, preLeft + leftTreeNodeCount, inLeft, rootValIndex - 1);
        root.right = build(preorder, inorder, preLeft + leftTreeNodeCount + 1, preRight, rootValIndex + 1, inRight);

        return root;
    }

    private int indexOf(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            throw new IllegalArgumentException("array cannot be empty");
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        throw new IllegalArgumentException("array not found target: " + target);
    }

}
