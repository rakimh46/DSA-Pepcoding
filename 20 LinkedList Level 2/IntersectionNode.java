
import java.util.*;

public class IntersectionNode {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        ListNode lA = headA, lB = headB;

        int l1 = length(headA);
        int l2 = length(headB);
        System.out.println(l1 + "    " + l2);
        int diff = l1 > l2 ? l1 - l2 : l2 - l1;
        // diff=Math.max(l1,l2) - Math.min(l1, l2); // second method
        if (l1 > l2) {
            while (diff > 0) {
                lA = lA.next;
                diff--;
            }
        } else if (l2 > l1) {
            while (diff > 0) {
                lB = lB.next;
                diff--;
            }
        }
        while (lA != lB) {
            lA = lA.next;
            lB = lB.next;
        }
        return lA;
    }

    // Input_code===================================================

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}
