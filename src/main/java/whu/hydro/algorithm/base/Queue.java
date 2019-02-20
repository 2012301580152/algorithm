package whu.hydro.algorithm.base;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @ClassName Queue
 * @Description TODO
 * @Author 86187
 * @Date 2019/2/18 21:48
 * @Version 1.0
 */
public class Queue<Item> extends AbstractBase<Item>{
//    private Node first;
    private Node last;

    public Queue() {
        super();
        last = first;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
}
