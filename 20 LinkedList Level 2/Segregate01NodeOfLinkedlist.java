//Segregate 01 Node Of Linkedlist Over Swapping Nodes
import java.util.*;

public class Segregate01NodeOfLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode Done = new ListNode(-1);
        ListNode Dzero = new ListNode(-1);

        ListNode curr = head, pone = Done, pzero = Dzero;

        while (curr != null) {
            if (curr.val == 0) {
                pzero.next = curr;
                pzero = pzero.next;
            } else {
                pone.next = curr;
                pone = pone.next;
            }
            curr = curr.next;
        }
        pzero.next = Done.next;
        pone.next = null;
        return Dzero.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate01(h1);
        printList(h1);
    }
}
