import java.util.concurrent.Callable;

public class d implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread ().getName ()+"开始"+i);
        }
        //表示线程运行完毕之后的结果
        return "结束";
    }
}
