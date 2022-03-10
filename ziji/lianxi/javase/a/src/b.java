import java.util.ArrayList;

public class b {
    public static void main(String[] args) {
//      bb i =new bb();
//      i.show();
       new aa(){
           @Override
           public void show(){
               System.out.println(66666);
           }
       }.show();
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
}
interface aa{
   void show();
}
interface aa2{
   void show1();
   void show2();
}
//class bb implements aa{
//    @Override
//    public void show() {
//        System.out.println(8888);
//    }
//}