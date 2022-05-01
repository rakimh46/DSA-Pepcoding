
import java.util.*;

public class CopyLinkedlistWithRandomPointers {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode curr=head;
        
        HashMap<ListNode,ListNode> map=new HashMap<>();

        while(curr!=null){
            prev.next=new ListNode(curr.val);
            map.put(curr,prev.next);
            prev=prev.next;
            curr=curr.next;
        }
        map.put(null, null);

        ListNode onode=head;
        ListNode cnode=dummy.next;
        while(onode!=null){
            cnode.random=map.get(onode.random);
            onode=onode.next;
            cnode=cnode.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if (idx != -1)
                arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}