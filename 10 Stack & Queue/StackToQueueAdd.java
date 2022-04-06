import java.util.Stack;

/**
 * Stack To Queue Adapter - Add Efficient
 */
public class StackToQueueAdd {

    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;
    
        public StackToQueueAdapter() {
          mainS = new Stack<>();
          helperS = new Stack<>();
        }

        int size(){
            return mainS.size();
        }

        void add(int val){
            mainS.add(val);
        }

        int peek(){
            while(mainS.size()!=0){
                helperS.add(mainS.pop());
            }
            int val=helperS.peek();
            while(helperS.size()!=0){
                mainS.add(helperS.pop());
            }
            return val;
        }
        int remove(){
            while(mainS.size()!=0){
                helperS.add(mainS.pop());
            }
            int val=helperS.pop();
            while(helperS.size()!=0){
                mainS.add(helperS.pop());
            }
            return val;
        }
    }  
    public static void main(String[] args) {
        
    }
}
