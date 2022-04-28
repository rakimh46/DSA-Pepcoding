public class LL {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

        public void addLast(int val) {
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

        public int size() {
            return size;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            } else if (size == 1) {
                head = tail = null;
            } else {
                Node nbr = head.next;
                head.next = null;
                head = nbr;
            }
            size--;
        }

        public int getFirst() {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }

        public int getLast() {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;
        }

        public int getAt(int idx) {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.print("Invalid arguments ");
                return -1;
            } else if (idx == 0) {
                return head.data;
            } else {
                Node temp = head;
                while (idx > 0) {
                    temp = temp.next;
                    idx--;
                }
                return temp.data;
            }
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            if (size == 0) {
                head = tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
            size++;
        }

        public void addAt(int idx, int val) {
            // write your code here
            if (idx < 0 || idx >= size) {
                System.out.println("Invaild arguments");
                return;
            } else {
                if (idx == 0) {
                    addFirst(val);
                } else if (idx == size) {
                    addLast(val);
                } else {
                    Node temp = head;
                    while (idx > 1) {
                        temp = temp.next;
                        idx--;
                    }
                    Node node = new Node();
                    node.data = val;
                    Node nbr = temp.next;

                    temp.next = node;
                    node.next = nbr;
                    size++;
                }
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            } else {
                if (size == 1) {
                    head = tail = null;
                } else {
                    Node temp = head;
                    while (temp.next != tail) {
                        temp = temp.next;
                    }
                    temp.next = null;
                    tail = temp;
                }
                size--;
            }
        }

        public void removeAt(int idx) {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invaild arguments");
                return;
            } else {
                if (idx == 0) {
                    removeFirst();
                } else if (idx == size - 1) {
                    removeLast();
                } else {
                    Node temp = head;
                    while (idx > 1) {
                        temp = temp.next;
                        idx--;
                    }
                    Node nbr = temp.next;
                    temp.next = nbr.next;
                    nbr.next = null;
                    size--;
                }
            }
        }

        public Node getAtNode(int idx) {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return null;
            } else if (idx < 0 || idx >= size) {
                System.out.print("Invalid arguments ");
                return null;
            } else if (idx == 0) {
                return head;
            } else {
                Node temp = head;
                while (idx > 0) {
                    temp = temp.next;
                    idx--;
                }
                return temp;
            }
        }

        public void reverseDI() {
            int p1 = 0;
            int p2 = size - 1;
            while (p1 < p2) {
                Node start = getAtNode(p1);
                Node end = getAtNode(p2);

                int temp = start.data;
                start.data = end.data;
                end.data = temp;

                p1++;
                p2--;
            }
        }

        public void reversePI(){
            Node prev=null;
            Node curr=head;
            while(curr!=null){
                Node nbr=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nbr;
            }

            Node temp=head;
            head=tail;
            tail=temp;
          }

    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addLast(60);
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        System.out.println(ll.size);
        ll.display();
        ll.removeFirst();
        ll.display();
        System.out.println(ll.getAt(5));
        ll.addFirst(5);
        ll.display();
        ll.addAt(2, 25);
        ll.display();
        ll.removeLast();
        ll.display();
        ll.removeAt(3);
        ll.display();
        ll.reverseDI();
        ll.display();
        ll.reversePI();
        ll.display();
    }
}