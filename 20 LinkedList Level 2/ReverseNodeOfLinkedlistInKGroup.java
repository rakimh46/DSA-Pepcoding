import java.util.*;

public class ReverseNodeOfLinkedlistInKGroup {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int length(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        int size = length(head);
        
        ListNode curr = head;

        ListNode fhead = null;
        ListNode ftail = null;

        ListNode thead = null;
        ListNode ttail = null;
        while (size > 0) {
            int temp=k;
            if (size >= k) {
                while(temp-->0){
                    ListNode fwd = curr.next;
                    curr.next = null;
                    if (thead == null) {
                        thead = curr;
                        ttail = curr;
                    } else {
                        curr.next = thead;
                        thead = curr;
                    }
                    curr = fwd;

                }
                size-=k;
            } else {
                ftail.next = curr;
                break;
            }

            if (fhead == null) {
                fhead = thead;
                ftail = ttail;
            } else {
                ftail.next = thead;
                ftail = ttail;
            }
            thead = ttail = null;
        }

        return fhead;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}
