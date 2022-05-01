import java.util.*;

public class MultiplyTwoLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode multiplyWithDigit(ListNode head, int digit) {
        ListNode dummy = new ListNode(-1);
        ListNode ac = dummy;
        ListNode curr = head;
        int carry = 0;
        while (curr != null || carry != 0) {

            int mul = (curr != null ? curr.val * digit : 0) + carry;
            carry = mul / 10;
            ac.next = new ListNode(mul % 10);
            curr = (curr != null) ? curr.next : null;
            ac = ac.next;
        }
        return dummy.next;
    }

    public static void addTwoList(ListNode head, ListNode ansItr) {
        ListNode c1 = head;
        ListNode c2 = ansItr;
        int carry = 0;
        while (c1 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2.next != null ? c2.next.val : 0);

            int digit = sum % 10;
            carry = sum / 10;

            if (c2.next != null) {
                c2.next.val = digit;
            } else {
                c2.next = new ListNode(digit);
            }

            if (c1 != null) {
                c1 = c1.next;
            }
            c2 = c2.next;
        }
    }

    public static ListNode reverse(ListNode head) {
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

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode l2_Itr = l2;
        ListNode duumy = new ListNode(-1);
        ListNode ansItr = duumy;
        while (l2_Itr != null) {
            ListNode prod = multiplyWithDigit(l1, l2_Itr.val);
            l2_Itr = l2_Itr.next;

            addTwoList(prod, ansItr);
            ansItr = ansItr.next;
        }
        return reverse(duumy.next);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

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
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}
