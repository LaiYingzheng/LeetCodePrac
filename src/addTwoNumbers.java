//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// *
// */
//class addTwoNumbers {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode RL = new ListNode(0);
//        ListNode R = l1, L = l2, curr = RL;
//        int carry = 0;
//
//        while (R!= null || L!= null){
//
//            if (R == null){
//                R = new ListNode(0);
//            }else if(L == null){
//                L = new ListNode(0);
//            }
//
//            int sum = (R.val + L.val)+carry;
//            carry = sum / 10;
//
//            if (sum >=10){
//                sum = sum%10;
//            }
//
//            curr.next = new ListNode(sum);
//            curr = curr.next;
//            /*
//
//            -------------------------------------
//            RL.next = new ListNode(sum)
//            RL = RL.next;
//            -------------------------------------
//
//            this does not work ; why
//            */
//            R = R.next;
//            L = L.next;
//
//
//        }
//
//        if (carry !=0 && R == null && L == null){
//            int sum = carry;
//            curr.next = new ListNode (sum);
//            return RL.next;
//        };
//
//        return RL.next;
//    }
//}
