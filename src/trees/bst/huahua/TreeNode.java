package trees.bst.huahua;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    private TreeNode root;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode node, int val) {
        this.val = val;
        node.left = null;
        node.right = null;
    }

    public TreeNode createBST(List<Integer> nums) {
        root = new TreeNode();
        for (Integer num : nums) {
            root = insert(root, num);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val <= root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public boolean search(TreeNode root, int x) {
        if (root == null) {
            return false;
        }
        if (root.val == x) {
            return true;
        }
        if (root.val < x) {
            return search(root.left, x);
        } else {
            return search(root.right, x);
        }
    }

    public boolean balanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && balanced(root.left) && balanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l, r) + 1;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        print(root.val);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        print(root.val);
    }

    public void print(int val) {
        System.out.print(val + "\t");
    }

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(3);
        values.add(1);
        values.add(4);
        values.add(7);
        values.add(6);
        TreeNode root = new TreeNode();
        root = root.createBST(values);
        root.inOrder(root);
        int max = root.maxVal(root);
        System.out.println();
        System.out.println(max);
    }

    public int maxVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxVal(root.left);
        int maxRight = maxVal(root.right);
        int maxLR = Math.max(maxLeft, maxRight);
        return Math.max(root.val, maxLR);
    }
}
