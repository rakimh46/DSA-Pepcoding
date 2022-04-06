/**
 * Linked_List_Start
 *  Add last
 * Display
 * size
 */
public class LinkedListStart {

    public static class Node{
        int data;
        Node next;
    }

    public static class linkedlist{
        Node head,tail;
        int size;

        void addLast(int val){
            Node node=new Node();
            node.data=val;

            if(size==0){
                head=tail=node;
            }else{
                tail.next=node;
                tail=node;
            }
            size++;
        }

        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }

        int size(){
            return this.size;
        }
    }
    public static void main(String[] args) {
        linkedlist LL=new linkedlist(); 
        LL.addLast(10);
        LL.addLast(20);
        LL.addLast(30);
        LL.addLast(40);
        LL.addLast(50);
        LL.display();
        System.out.println(LL.size());

    }
    
}