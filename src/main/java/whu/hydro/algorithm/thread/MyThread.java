package whu.hydro.algorithm.thread;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/13 21:30
 * @Version 1.0
 */
public class MyThread extends Thread{
    @Override
    public void run() {

        super.run();
        for (int i = 0; i < 5; i++) {
            System.out.println("i="+(i+1));
        }
    }
}
