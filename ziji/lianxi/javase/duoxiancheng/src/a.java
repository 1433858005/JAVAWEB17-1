import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class a {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      //线程开启之后需要执行里面的call方法
        d d1 = new d();
        //可以获取线程执行完毕之后的结果。也可以作为参数传递给Thread对象
        FutureTask<String> ft = new FutureTask<>(d1);
        //创建线程对象
        Thread t1 = new Thread(ft);
        t1.setName("飞机");
        //设置线程优先级
        t1.setPriority ( 1 );
        // 获取线程的优先级
        System.out.println( t1.getPriority());
        //开启线程
        t1.start();
//        String s = ft.get();
//        System.out.println(s);
        ///////////////////////////////////
        d d2 = new d();
        FutureTask<String> ft2 = new FutureTask<>(d2);
        Thread t2 = new Thread(ft2);
        t2.setName("坦克");
        // 获取线程的优先级
        System.out.println( t2.getPriority());
        t2.start();
//        String s2 = ft2.get();
//        System.out.println(s2);
    }
}
