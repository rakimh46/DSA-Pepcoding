import java.util.*;

public class Palindrome {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode MiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode nbr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nbr;
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode midNode = MiddleNode(head);
        ListNode nHead = midNode.next;
        midNode.next = null;
        nHead = reverse(nHead);
        ListNode p1 = head, p2 = nHead;
        boolean res = true;
        while (p2 != null) {
            if (p2.val != p1.val) {
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        nHead = reverse(nHead);
        midNode.next = nHead;
        return res;
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

            System.out.println(isPalindrome(dummy.next));
        }
    }
}