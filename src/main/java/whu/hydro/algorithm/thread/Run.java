package whu.hydro.algorithm.thread;

/**
 * @ClassName Run
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/13 21:40
 * @Version 1.0
 */
public class Run {

    public static void main(String[] args) {
        Thread t = new Thread();





        try {
            MyThread thread = new MyThread();
            thread.start();

            thread.interrupt();
            Thread.sleep(20);

            Thread.currentThread().interrupt();

            Thread.currentThread().getName();
            System.out.println(thread.interrupted());
            System.out.println(thread.interrupted());
//            thread.stop();
            System.out.println("end");

            System.out.println("main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


