//Fold Of Linkedlist
import java.util.*;

public class Fold {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode MiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode nbr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nbr;
        }
        return prev;
    }

    public static void fold(ListNode head) {
        ListNode midNode = MiddleNode(head);
        ListNode nHead = midNode.next;
        midNode.next = null;
        nHead = reverse(nHead);
        ListNode p1 = head, p2 = nHead;

        while (p2 != null) {
            ListNode node1 = p1.next;
            ListNode node2 = p2.next;
            p1.next = p2;
            p2.next = node1;

            p1 = node1;
            p2 = node2;
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;
            while (n-- > 0) {
                prev.next = new ListNode(scn.nextInt());
                prev = prev.next;
            }

            ListNode head = dummy.next;
            fold(head);
            printList(head);
        }
    }
}
