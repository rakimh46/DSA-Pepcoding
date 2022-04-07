// Common node between two linked list
//findIntersection
public class findIntersection {

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

        public int middleElement() {
            Node slow = head;
            Node fast = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        public static int findIntersection(linkedlist li, linkedlist di) {
            // write your code hereth
            
            Node ltemp = li.head;
            System.out.println(ltemp.data);
            Node dtemp = di.head;
            if (li.size() > di.size()) {
                int diff = li.size() - di.size();
                while (diff > 0) {
                    ltemp = ltemp.next;
                    diff--;
                }
            } else {
                int diff = di.size() - li.size();
                while (diff > 0) {
                    dtemp = dtemp.next;
                    diff--;
                }
            }
            while (ltemp.data!=dtemp.data) {
                ltemp = ltemp.next;
                dtemp = dtemp.next;
            }
            return ltemp.data;
        }

    }

    public static void main(String[] args) {
        linkedlist li = new linkedlist();
        linkedlist di = new linkedlist();
        li.addFirst(10);
        li.addLast(20);
        li.addLast(30);
        li.addLast(40);
        li.addLast(50);
        li.addLast(60);
        li.display();

        di.addFirst(80);
        di.addLast(70);
        di.addLast(40);
        di.addLast(50);
        di.addLast(60);
        di.display();

        int inter = linkedlist.findIntersection(li, di);
        System.out.println(inter);
    }
}
