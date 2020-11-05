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
        
        TreeNode t = new TreeNode(nums[(int)Math.floor(nums.length/2)]);
        System.out.println(t.val);
        recursion(nums,0,nums.length-1,t);
        return t;
    }
    public void recursion(int[] arr, int p, int r, TreeNode node) {
        
        if (r>=p && p>=0 && node!=null) {
            int q = (int)Math.floor((r-p)/2)+p;
            System.out.println("p="+p+"; q="+q+"; r="+r);
            if ((int)Math.floor((q-p)/2)+p==r) {node.left=null;}
            else {
            node.left=new TreeNode(arr[(int)Math.floor((q-p)/2)+p]);
            }
            if ((int)Math.floor((r-q)/2)+q==0) {node.right=null;} 
            else{
                node.right=new TreeNode(arr[(int)Math.floor((r-q)/2)+q]);
            }
            System.out.println("p="+p+"; q="+q+"; r="+r);
            if (node.left!=null) {System.out.println("left="+node.left.val); }
            if (node.right!=null) {System.out.println("right="+node.right.val);}
           
            recursion(arr,p,q-1,node.left);
            recursion(arr,q+1,r,node.right);
        }
    }
}

**********************************************************************
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
        
        TreeNode t = new TreeNode(nums[(int)Math.floor(nums.length/2)]);
        System.out.println(t.val);
        recursion(nums,0,nums.length-1,t);
        return t;
    }
    public void recursion(int[] arr, int p, int r, TreeNode node) {
        if (r>=p && p>=0 && node!=null) {
            int q = (int)Math.floor((r-p+1)/2)+p;
            if (node.val>arr[(int)Math.floor((q-p)/2)+p]) {
                node.left=new TreeNode(arr[(int)Math.floor((q-p)/2)+p]);
            }
            if (node.val<arr[(int)Math.floor((r-q)/2)+q]) {
                node.right=new TreeNode(arr[(int)Math.floor((r-q)/2)+q]);
            }
            System.out.println("p="+p+"; q="+q+"; r="+r);
            if (node.left!=null) {System.out.println("left="+node.left.val); }
            if (node.right!=null) {System.out.println("right="+node.right.val);}
           
            recursion(arr,p,(int)Math.floor((q-p)/2)+p-1,node.left);
            recursion(arr,(int)Math.floor((q-p)/2)+p+1,q,node.left);
            recursion(arr,q+1,(int)Math.floor((r-q)/2)+q-1,node.right);
            recursion(arr,(int)Math.floor((r-q)/2)+q+1,r,node.right);
        }
    }
}
