public class practie {

    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cp) {
            data = new int[cp];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            System.out.print("[");
            for (int i = tos; i >= 0; i--) {
                System.out.print(" "+data[i]+" ");
            }
            System.out.print("]");
        }

        void push(int val) {
            // write ur code here
            if(size() == data.length ){
                //System.out.println("Stack overflow");
                int[] newdata=new int[2*data.length];
                for (int i = 0; i < data.length; i++) {
                    newdata[i]=data[i];
                }
                data=newdata;
                push(val);
                return; 
            }else{
                tos++;
                data[tos]=val;
            }
            
          }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos];
                data[tos] = 0;
                tos--;
                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos];
            }

        }
    }

    public static void main(String[] args) {
        int n = 5;
        CustomStack st = new CustomStack(n);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70);
        st.display();
        // System.out.println(st.pop());
    }

}
