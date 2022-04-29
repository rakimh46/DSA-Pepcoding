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

        public void reversePI() {
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node nbr = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nbr;
            }

            Node temp = head;
            head = tail;
            tail = temp;
        }

        public int kthFromLast(int k) {
            // write your code here
            Node slow = head, fast = head;
            while (k > 0) {
                fast = fast.next;
                k--;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }

        public int mid() {
            Node slow = head, fast = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        public void removeDuplicates() {
            // write your code here
            LinkedList res = new LinkedList();
            res.addFirst(this.getFirst());
            this.removeFirst();
            while (this.size() > 0) {
                if (this.getFirst() == res.getLast()) {
                    this.removeFirst();
                } else {
                    res.addFirst(this.getFirst());
                    this.removeFirst();
                }
            }

            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }

        public void oddEven() {
            LinkedList oddList = new LinkedList();
            LinkedList evenList = new LinkedList();
            while (this.size > 0) {
                int temp = this.getFirst();
                if (temp % 2 == 0) {
                    evenList.addLast(temp);
                } else {
                    oddList.addLast(temp);
                }
                this.removeFirst();
            }
            if (oddList.size > 0 && evenList.size > 0) {
                this.head = oddList.head;
                oddList.tail.next = evenList.head;
                this.tail = evenList.tail;
                this.size = oddList.size + evenList.size;
            } else if (oddList.size > 0) {
                this.head = oddList.head;
                this.tail = oddList.tail;
                this.size = oddList.size;
            } else if (evenList.size > 0) {
                this.head = evenList.head;
                this.tail = evenList.tail;
                this.size = evenList.size;
            }

        }

        private void reversePRHelper(Node node) {
            if (node == null) {
                return;
            }
            reversePRHelper(node.next);
            if (node != tail) {
                node.next.next = node;
            }
        }

        public void reversePR() {
            reversePRHelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public static Node left;

        private boolean IsPalindromeHelper(Node node) {
            if (node == null) {
                return true;
            }

            boolean rres = IsPalindromeHelper(node.next);
            if (rres == false) {
                return false;
            } else {
                if (left.data == node.data) {
                    left = left.next;
                    return true;
                } else {
                    return false;
                }
            }
        }

        public boolean IsPalindrome() {
            left = head;
            return IsPalindromeHelper(head);
        }

        public static Node start;

        private void foldHelper(Node node, int idx) {
            if (node == null) {
                return;
            }
            foldHelper(node.next, idx + 1);
            if (idx > size / 2) {
                Node temp = start.next;
                start.next = node;
                node.next = temp;
                start = temp;
            } else if (idx == size / 2) {
                node.next = null;
                this.tail = node;
                return;
            }

        }

        public void fold() {
            start = head;
            foldHelper(head, 0);
        }

        public void kReverse(int k) {
            // write your code here
            LinkedList ans = null;
            LinkedList temp = new LinkedList();

            while (this.size > 0) {
                if (size >= k) {
                    for (int i = 0; i < k; i++) {
                        temp.addFirst(getFirst());
                        removeFirst();
                    }
                } else {
                    while (size() > 0) {
                        temp.addLast(getFirst());
                        removeFirst();
                    }
                }
                if(ans==null){
                    ans=temp;
                    temp=new LinkedList();
                }else{
                    ans.tail.next=temp.head;
                    ans.tail=temp.tail;
                    ans.size+=temp.size;
                    temp=new LinkedList();
                }
            }

            this.head=ans.head;
            this.tail=ans.tail;
            this.size=ans.size;
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
        System.out.println(ll.kthFromLast(3));
        ll.oddEven();
        ll.display();
        ll.reversePR();
        System.out.println(ll.IsPalindrome());
        ll.display();
        ll.fold();
        ll.display();

    }
}