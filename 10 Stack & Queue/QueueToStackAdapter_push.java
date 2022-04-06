import java.util.ArrayDeque;
import java.util.Queue;

//Queue To Stack Adapter 
/**
 * Queue To Stack Adapter - Push Efficient
 */
public class QueueToStackAdapter_push {

    public static class QueueToStack{
        Queue<Integer> mainq;
        Queue<Integer> helperq;

        public QueueToStack(){
            mainq=new ArrayDeque<>();
            helperq=new ArrayDeque<>();
        }

        int size(){
            return mainq.size();
        }

        void push(int val){
            mainq.add(val);
        }
        int pop(){
            if(size()==0){
                return -1;
            }else{
                while(mainq.size()>1){
                    helperq.add(mainq.remove());
                }
                int val=mainq.remove();

                Queue<Integer> newq=mainq;
                mainq=helperq;
                helperq=newq;

                return val;
            }
        }

        int top(){
            if(size()==0){
                return -1;
            }else{
                while(mainq.size()>1){
                    helperq.add(mainq.remove());
                }
                int val=mainq.remove();
                helperq.add(val);
                Queue<Integer> newq=mainq;
                mainq=helperq;
                helperq=newq;

                return val;
            }

        }

        

    } 

    public static void main(String[] args) {
        StartQueue st= new StartQueue();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        
        
        
    }
}