
import java.util.*;

public class Segregate01NodeByHead {

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
            return null;
        }

        ListNode ith = head;
        ListNode jth = head;
        while (ith != null) {
            if (ith.val == 0) {
                int temp = ith.val;
                ith.val = jth.val;
                jth.val = temp;
                jth = jth.next;
                ith = ith.next;
            } else {
                ith = ith.next;
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
        h1 = segregate01(h1);
        printList(h1);
    }
}
