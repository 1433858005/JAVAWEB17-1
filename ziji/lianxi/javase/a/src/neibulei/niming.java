package neibulei;

public class niming {
    public static void main(String[] args) {
        aa2 q=  new aa2(){
            @Override
            public void show1() {
                System.out.println(001);
            }

            @Override
            public void show2() {
                System.out.println(002);
            }
        };
        q.show1();
        q.show2();
}

    interface aa2 {
        void show1();
        void show2();
    }
}