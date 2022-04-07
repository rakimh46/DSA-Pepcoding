public class GetValueLinkedList {

    public static class Node {
        int data;
        Node next;
    }

    public static class linkedlist {
        Node head, tail;
        int size;

        void addLast(int val) {
            Node node = new Node();
            node.data = val;

            if (size == 0) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else {
                if (size == 1) {
                    head = tail = null;
                } else {
                    Node node = new Node();
                    node = head.next;
                    head.next = null;
                    head = node;
                }
                size--;
            }
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        int size() {
            return this.size;
        }

        public int getFirst() {
            // write your code here
            if (size() == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }

        }

        public int getLast() {
            // write your code here
            if (size() == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 && idx >= size()) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                while(idx>0){
                    temp=temp.next;
                    idx--;
                }
                return temp.data;
            }
        }
    }

    public static void main(String[] args) {
        linkedlist LL = new linkedlist();
        LL.addLast(10);
        LL.addLast(20);
        LL.addLast(30);
        LL.addLast(40);
        LL.addLast(50);
        LL.display();
        System.out.println(LL.size());
        System.out.println(LL.getAt(3));

    }
}
