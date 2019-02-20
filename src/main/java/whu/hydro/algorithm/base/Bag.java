package whu.hydro.algorithm.base;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @ClassName Bag
 * @Description TODO
 * @Author 86187
 * @Date 2019/2/18 21:46
 * @Version 1.0
 */
public class Bag<Item> extends AbstractBase<Item>{
//    private Node first;

    public Bag(){
        super();
    }
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }



}
