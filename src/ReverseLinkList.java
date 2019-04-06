import Supplement.LinkedList.*;
import java.util.*;
public class ReverseLinkList {

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(){

        }
        ListNode(int val ) {
            this.val  = val;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null){
            ListNode tempNext = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tempNext;
        }
        return pre;
    }


}

