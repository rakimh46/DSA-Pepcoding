import java.util.Collections;
import java.util.PriorityQueue;

public class HeapIntro {
    public static void main(String[] args) {
        // increasing order min priorioty
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(15);
        pq.add(55);
        pq.add(25);
        pq.add(35);
        pq.add(45);
        System.out.println(pq);

        // decresing order max priority
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq1.add(5);
        pq1.add(15);
        pq1.add(55);
        pq1.add(25);
        pq1.add(35);
        pq1.add(45);

        pq.remove();
        System.out.println(pq);
        pq1.remove();
        System.out.println(pq1);

        pq.add(10);
        pq.add(20);
        pq.add(40);
        System.out.println(pq);
        while (pq.size()>0) {
            System.out.println(pq.remove());
        }

    }
}
