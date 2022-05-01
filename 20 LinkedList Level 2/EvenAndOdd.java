import java.util.*;

class EvenAndOdd {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);

        ListNode curr = head;
        ListNode odd = dummyOdd;
        ListNode even = dummyEven;

        while (curr != null) {
            if (curr.val % 2 == 0) {
                even.next = curr;
                even = even.next;
                // System.out.println(even.val+" "+curr.val);
            } else {
                odd.next = curr;
                odd = odd.next;
                // System.out.println(odd.val+" "+curr.val);
            }
            curr = curr.next;
        }
        ListNode temp = dummyOdd.next;
        dummyOdd.next = null;
        even.next = temp;

        return dummyEven.next;
    }

    public static void main(String[] args) {

        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}