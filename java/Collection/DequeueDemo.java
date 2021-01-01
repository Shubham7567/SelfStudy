import java.util.Deque;
import java.util.LinkedList;
import java.util.Iterator;

public class DequeueDemo {
    public static void main(String[] args){
        Deque<String> deque = new LinkedList<String>();
        deque.add("Element1");
        deque.addFirst("Element2 added to first");
        deque.addLast("Element 3 added to last");
        deque.push("Element 4 head");
        deque.offer("Element 5 tail");
        deque.offerFirst("Element 6(head)");
        deque.offerLast("Element 7 (tail)");

        Iterator iterator = deque.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        deque.removeFirst();
        deque.removeLast();
        System.out.println("After removing first and last.");
        iterator = deque.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
