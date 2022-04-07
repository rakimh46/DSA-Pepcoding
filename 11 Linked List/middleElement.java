public class middleElement {

    public static class Node {
        int data;
        Node next;
    }

    public static class linkedlist {
        Node head, tail;
        int size;

        // first method
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

        // 2nd method
        public void addFirst(int val) {
            // write your code here
            Node node = new Node();
            node.data = val;

            if (size == 0) {
                head = tail = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        // 3rd method
        public void addAt(int idx, int val) {
            // write your code here

            if (idx < 0 && idx >= size()) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size() - 1) {
                addLast(val);
            } else if (idx > 0 || idx < size() - 1) {
                Node temp = head;
                for (int jump = 1; jump <= idx - 1; jump++) {
                    temp = temp.next;
                }
                Node nbr = temp.next;
                Node node = new Node();
                node.data = val;
                temp.next = node;
                node.next = nbr;
                size++;
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

        public int kthFromLast(int k) {
            // write your code here
            Node slow = head;
            Node fast = head;
            while (k > 0) {
                fast = fast.next;
                k--;
            }
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }

        public int middleElement(){
            Node slow = head;
            Node fast = head;
            while(fast!=tail && fast.next!=tail){
                slow=slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

    }

    public static void main(String[] args) {
        linkedlist LL = new linkedlist();
        LL.addFirst(20);
        LL.addLast(30);
        LL.addLast(50);
        LL.addLast(60);
        LL.addLast(70);
        LL.addLast(80);
        LL.addFirst(10);
        LL.addAt(3, 40);
        LL.display();
        System.out.println( LL.middleElement());

    }
}
