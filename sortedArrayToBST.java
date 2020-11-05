/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0) return null;
        TreeNode t = new TreeNode(nums[(int)Math.floor(nums.length/2)]);
        recursion(nums,0,nums.length-1,t);
        return t;
    }
    public void recursion(int[] arr, int p, int r, TreeNode node) {
        if (r>=p && p>=0  && node!=null) {
            int q = (int)Math.floor((r-p+1)/2)+p;
            int q_l = (int)Math.floor((q-p)/2.0)+p;
            int q_r = (int)Math.ceil((r-q+1)/2.0)+q;
            if (node.val>arr[q_l]) {
                node.left=new TreeNode(arr[q_l]);
            }
            if (q_r<=r && node.val<arr[q_r]) {
                node.right=new TreeNode(arr[q_r]);
            }
            recursion(arr,p,q-1,node.left);
            recursion(arr,q+1,r,node.right);
        }
    }
}
