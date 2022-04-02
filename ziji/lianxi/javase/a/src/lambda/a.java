package lambda;

public class a {
    public static void main(String[] args) {
        aa(new kk() {
            @Override
            public void show() {
                System.out.println(6666);
            }
        });
       aa(()->{System.out.println(7777);});
    }

    public  static void aa(kk ll){
        ll.show();
    }
    interface  kk{
        void show();
    }
}
