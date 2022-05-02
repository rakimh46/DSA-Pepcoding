import java.util.*;

public class SegregateNodeOverPivotIndex {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate(ListNode head, int idx) {
        int i = 0, data = 0;
        ListNode curr = head;
        while (curr != null) {
            if (i == idx)
                data = curr.val;

            i++;
            curr = curr.next;
        }
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode(-1);

        ListNode ps = smaller, pl = larger;
        ListNode PivotNode = null;
        curr = head;
        i = 0;
        while (curr != null) {
            if (i == idx) {
                PivotNode = curr;
            } else if (curr.val <= data) {
                ps.next = curr;
                ps = ps.next;
            } else { // greater than pivot
                pl.next = curr;
                pl = pl.next;
            }
            curr = curr.next;
            i++;
        }

        ps.next = PivotNode;
        PivotNode.next = larger.next;
        pl.next = null;
        return smaller.next;
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
        int idx = scn.nextInt();
        h1 = segregate(h1, idx);
        printList(h1);
    }
}
