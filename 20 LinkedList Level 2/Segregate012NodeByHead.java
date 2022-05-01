
import java.util.*;

public class Segregate012NodeByHead {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode ith = head;
        ListNode jth = head;
        ListNode kth = head;

        while (ith != null) {
            if (ith.val == 2) {
                ith = ith.next;
            } else if (ith.val == 1) {
                int temp = ith.val;
                ith.val = kth.val;
                kth.val = temp;
                ith = ith.next;
                kth = kth.next;
            } else if (ith.val == 0) {
                int temp = ith.val; // swap i j
                ith.val = jth.val;
                jth.val = temp;

                if (ith.val != 2) {
                    int temp2 = ith.val; // swap i k
                    ith.val = kth.val;
                    kth.val = temp2;
                }
                ith = ith.next;
                jth = jth.next;
                kth = kth.next;
            }
        }
        return head;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}
