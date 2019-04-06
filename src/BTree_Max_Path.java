///**
// * recursive way
// * Time complexity -> O(N)
// */
//public class BTree_Max_Path {
//    public int maxDepth(TreeNode root) {
//        if (root == null){
//            return 0;
//        }else{
//            int left_height = maxDepth (root.left);
//            int right_height = maxDepth (root.right);
//
//            return Math.max(left_height, right_height) +1;
//        }
//
//    }
//}
