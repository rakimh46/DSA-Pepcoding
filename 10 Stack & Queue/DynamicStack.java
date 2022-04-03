public class DynamicStack {

    public static class CustomStack {
        int[] data;
        int tos;
    
        public CustomStack(int cap) {
          data = new int[cap];
          tos = -1;
        }
    
        int size() {
          // write ur code here
          return tos+1;
        }
    
        void display() {
          // write ur code here
          for(int idx = tos; idx >= 0; idx--){
              System.out.print(data[idx]+" ");
          }
          System.out.println();
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
          // write ur code here
          if(size() == 0 ){
              System.out.println("Stack underflow");
              return -1;
          }else{
              int val = data[tos];
              data[tos]=0;
              tos--;
              return val;
          }
        }
    
        int top() {
           // write ur code here
           if(size() == 0 ){
              System.out.println("Stack underflow");
    
    
    
              return -1;
          }else{
              int val = data[tos];
              return val;
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

        

    }
}
