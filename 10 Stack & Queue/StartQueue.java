import java.util.*;

public class StartQueue {
    public static void main(String[] args) {
        Queue<Integer> qu=new ArrayDeque<>();

        System.out.println(qu);
        qu.add(10);
        qu.add(20);
        qu.add(30);
        qu.add(40);
        qu.add(50);
        System.out.println(qu);
        System.out.println( qu.remove());
        qu.add(60);
        System.out.println(qu);
        System.out.println(qu.peek());
                    
        }

    public void push(int i) {
    };
    }

