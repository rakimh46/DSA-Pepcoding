// queue in fifo
public class normalQueue {
    public static class CustomQueue {
        int[] data;
        int first;
        int size;

        public CustomQueue(int n) {
            data = new int[n];
            first = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            System.out.print("[ ");
            for (int i = 0; i < size; i++) {
                System.out.print(data[(first + i) % data.length] + " ");
            }
            System.out.println("]");
        }

        void add(int val) {
            if (size() == data.length) {
                System.out.println("queue overflow");
                return;
            } else {
                data[(first + size) % data.length] = val;
                size++;
            }
        }

        int remove() {
            if (size() == 0) {
                System.out.println("underflow");
                return -1;
            } else {
                int val = data[first];
                data[first] = 0;
                first = (first + 1) % data.length;
                size--;
                return val;

            }

        }

        int peek() {
            if (size() == 0) {
                System.out.println("underflow");
                return -1;
            } else {
                return data[first];
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        CustomQueue qu = new CustomQueue(n);

        qu.add(5);
        qu.add(10);
        qu.add(15);
        qu.add(20);
        qu.add(15);
        qu.display();
        System.out.println( qu.remove());
        qu.display();
        System.out.println(qu.peek());
        System.out.println(qu.size());

    }
}
