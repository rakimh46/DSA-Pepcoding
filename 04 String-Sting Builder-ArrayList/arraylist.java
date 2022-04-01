import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // add in last10
        list.add(20);
        list.add(30);
        list.add(3, 40); // with index
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(100);
        list.add(9, 110);

        list.set(8, 90);
        System.out.println(list.get(5));
        System.out.println(list.size());

        System.out.println(list);

    }
}
