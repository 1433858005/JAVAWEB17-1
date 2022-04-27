public class b extends Thread{
    //重写两个方法，为给线程设置名称
    public b() {
        super();
    }
    public b(String name) {
        super(name);
    }
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"线程开启了"+i);
        }
    }
}
