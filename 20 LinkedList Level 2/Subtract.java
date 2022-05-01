
    import java.util.*;
    
    public class Subtract {
      public static Scanner scn = new Scanner(System.in);
    
      public static class ListNode {
        int val = 0;
        ListNode next = null;
    
        ListNode(int val) {
          this.val = val;
        }
      }
      
      public static int length(ListNode head){
          int len=0;
          ListNode temp=head;
          while(temp!=null){
              len++;
              temp=temp.next;
          }
          return len;
      }
      
      public static ListNode reverse(ListNode head){
          if(head==null || head.next==null){
                return head;
            }
          ListNode curr=head,prev=null;
          while(curr!=null){
              ListNode nbr=curr.next;
              curr.next=prev;
              prev=curr;
              curr=nbr;
          }
          return prev;
      }
      
      public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
          if (l2 == null) {
                return l1;
            }
          if(l1==null){
              l2.val=-l2.val;
              return l2;
          }
          
        int length1 = length(l1);
        int length2 = length(l2);
        if(length1<length2){
            ListNode save=l1;
            l1=l2;
            l2=save;
        }
        
          l1=reverse(l1);
          l2=reverse(l2);
          
          ListNode l3=new ListNode(-1);
          
          
          ListNode p1=l1;
          ListNode p2=l2;
          ListNode p3=l3;
          int borrow=0;
          
          while(p1!=null){
              
              int sub=borrow + p1.val - (p2!=null ? p2.val : 0); 
              
              if(sub<0){
                  borrow=-1;
                  sub+=10;
              }else{
                  borrow=0;
              }
              
              p3.next=new ListNode(sub);
              p3=p3.next;
              
              p1=p1.next;
              if(p2!=null) p2=p2.next;
          }
          l3=reverse(l3.next);
          while(l3!=null){
              if(l3.val!=0){
                  return l3;
              }
              l3=l3.next;
          }
        return new ListNode(0);
      }
    
      // InFput_code===================================================
    
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
    
        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
      }
    
    }
