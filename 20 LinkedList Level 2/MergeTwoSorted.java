
import java.util.*;

public class MergeTwoSorted {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l2 == null ? l1 : l2;
        }

        ListNode dummy = new ListNode(-1);

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode ans = dummy;

        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                ans.next = new ListNode(c1.val);
                c1 = c1.next;
            } else {
                ans.next = new ListNode(c2.val);
                c2 = c2.next;
            }
            ans = ans.next;
        }

        while (c1 != null) {
            ans.next = new ListNode(c1.val);
            c1 = c1.next;
            ans = ans.next;
        }
        while (c2 != null) {
            ans.next = new ListNode(c2.val);
            c2 = c2.next;
            ans = ans.next;
        }

        return dummy.next;
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
        int m = scn.nextInt();
        ListNode h2 = createList(m);

        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}