//Maximum Path Sum In Between Two Leaves Of Binary Tree
//Maximum Path Sum In Between Node to Leave Of Binary Tree

import java.util.Scanner;

public class PathSumBoth {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        int NTLMS;
        int LTLMS;

        Pair(int NTLMS, int LTLMS) {
            this.NTLMS = NTLMS;
            this.LTLMS = LTLMS;
        }
    }

    public static Pair maxPathSum(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair lsum = maxPathSum(root.left);
        Pair rsum = maxPathSum(root.right);

        int NTLMS = Math.max(lsum.NTLMS, rsum.NTLMS) + root.val;
        int LTLMS = Math.max(rsum.LTLMS, lsum.LTLMS);
        if (root.left != null && root.right != null) {
            LTLMS = Math.max(lsum.NTLMS + rsum.NTLMS + root.val, LTLMS);
        }
        return new Pair(NTLMS, LTLMS);

    }

    // input_Section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        Pair obj = maxPathSum(root);
        System.out.println(obj.NTLMS + " " + obj.LTLMS);
    }

    public static void main(String[] args) {
        solve();
    }
}
