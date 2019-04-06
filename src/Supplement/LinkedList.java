package Supplement;

public class LinkedList {
    ListNode head;

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            data = d;
            next = null;
        }
    }


    public static LinkedList insert(LinkedList list, int data) {
        ListNode new_node = new ListNode(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            ListNode last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

        return list;
    }

    public static void printList(LinkedList list) {
        ListNode currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList test = new LinkedList();
        test = insert(test, 1);
        test = insert(test, 3);
        test = insert(test, 2);
        printList(test);
    }

}