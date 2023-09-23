package DataSt;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    public static class Item{
        int val1, val2;

        public Item(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
    public static void main(String[] args) {
        // 항상 정렬 상태 유지
        PriorityQueue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                if(i1.val1 == i2.val1){
                    return Integer.compare(i1.val2, i2.val2);
                }else
                    return Integer.compare(i1.val1, i2.val1);
            }
        });

        queue.add(new Item(4,3));
        queue.add(new Item(3,6));
        queue.add(new Item(4,8));
        queue.add(new Item(1,1));

        if (queue.size() !=0)
            queue.poll(); // 1,1

        queue.add(new Item(7,3));
        queue.add(new Item(2,6));

        // 단순 출력(정렬상태 X)
        for(Item item : queue){
            System.out.println(item.val1+ " : "+ item.val2);
        }
        System.out.println("\n");
        // 정렬상태 출력
        while (queue.size()!=0){
            Item item = queue.poll();
            System.out.println(item.val1+ " : "+ item.val2);
        }
    }
}
