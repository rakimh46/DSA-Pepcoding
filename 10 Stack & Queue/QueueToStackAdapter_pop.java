/**
 * Queue To Stack Adapter - Pop Efficient
 */
import java.util.ArrayDeque;
import java.util.Queue;
public class QueueToStackAdapter_pop {

    public static class QueueToStackAdapterPop{
        Queue<Integer> mainq;
        Queue<Integer> helperq;

        public QueueToStackAdapterPop() {
            mainq=new ArrayDeque<>();
            helperq=new ArrayDeque<>();
        }

        int size(){
            return mainq.size();
        } 

        int pop(){
            return mainq.remove();
        }

        int top(){
            return mainq.peek();
        }

        void push(int val){
            helperq.add(val);
            while(size()>0){
                helperq.add(mainq.remove());
            }

            Queue<Integer> newq=mainq;
            mainq=helperq;
            helperq=newq;
        }

    }
    public static void main(String[] args) {
        
    }
}
