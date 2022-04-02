package neibulei;

public class swimming {
    public static void main(String[] args) {
  goswimming(new Swimming() {
      @Override
      public void swim() {
          System.out.println(233);
      }
  });
    }

    public static void goswimming(Swimming swimming){
        swimming.swim();
    }

    interface Swimming{
        void swim();
    }
}
