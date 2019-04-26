package cn.calvin.binaryTree.Test;

public class Test {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tree = reConstract(pre, in);
        System.out.println("后序遍历：");
        binaryTreeAfter(tree);
        System.out.println(" ");
        System.out.println("中序遍历：");
        binaryTreeMid(tree);
        System.out.println(" ");
        System.out.println("前序遍历：");
        binaryTreePre(tree);
    }

    private static TreeNode reConstract(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode root = reConstractHelp(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstractHelp(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
        if (startPre > endPre) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        root.left = null;
        root.right = null;
        int index = 0;
        if (startPre == endPre && startIn == endIn) {
            return root;
        }
        for (index = startIn; index <= endIn; index++) {
            if (in[index] == pre[startPre]) {
                break;
            }
        }
        int leftLen = index - startIn;
        int rightLen = endIn - index;
        if (leftLen > 0) {
            //递归遍历
            root.left = reConstractHelp(pre, in, startPre + 1, startPre + leftLen, startIn, index - 1);
        }
        if (rightLen > 0) {
            //递归遍历
            root.right = reConstractHelp(pre, in, startPre + 1 + leftLen, endPre, index + 1, endIn);
        }
        return root;

    }

    //前序遍历
    public static void binaryTreePre(TreeNode root) {
        System.out.print(root.val + " ");
        if (root.left != null) {
            binaryTreePre(root.left);
        }
        if (root.right != null) {
            binaryTreePre(root.right);
        }
    }

    //中序遍历
    public static void binaryTreeMid(TreeNode root) {
        if (root.left != null) {
            binaryTreeMid(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            binaryTreeMid(root.right);
        }
    }


    //后序遍历
    public static void binaryTreeAfter(TreeNode root) {
        if (root.left != null) {
            binaryTreeAfter(root.left);
        }
        if (root.right != null) {
            binaryTreeAfter(root.right);
        }
        System.out.print(root.val + " ");
    }
}

