public class DynamicQueue {
    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int n) {
            data = new int[n];
            front = 0;
            size = 0;
        }

        int size() {
            return size + 1;
        }

        void display(){
            if(size()==0){
                System.out.println("underflow");
            }else{
                for (int i = 0; i < size; i++) {
                    System.out.print(data[(front+i)%data.length]+" ");
                }
                System.out.println();
            }
        }

        void add(int val) {
            if (size() == data.length) {
                int[] newd = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    newd[i] = data[i];
                }
                data = newd;
                add(val);
                return;
            } else {
                data[(front + size) % data.length] = val;
                size++;
            }
        }

        int remove(){
            if(size()==0){
                System.out.println("underflow");
                return -1;
            }else{
                int val=data[front];
                data[front]=0;
                front=(front+1)%data.length;
                size--;
                return val;
            }
        }
        int  peek(){
            if(size()==0){
                System.out.println("underflow");
                return -1;
            }else{
                int val=data[front];
                return val;
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
        qu.add(20);
        qu.add(25);
        qu.display();
        System.out.println( qu.remove());
        qu.display();
        System.out.println(qu.peek());
        System.out.println(qu.size());

    }
}
