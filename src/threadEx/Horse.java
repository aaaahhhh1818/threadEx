package threadEx;

public class Horse extends Thread { //말 하나당 실 연결해주기

  private String name; //말의 이름
  private int pos; //말들의 위치

  public Horse(String name) {
    this.name = name;
    this.pos = 0;
  }

  @Override
  public void run() {
    this.gallop();
  }

  public void gallop() {
    for(int i = 0; i < 100; i++) {

      int range = (int)(Math.random() * 10) + 1; //말이 1~10까지 달리게 해줌

      this.pos += range; //원래 말의 위치 변경해주기

      //말 하나가 System.out 사용하는 동안 다른 말들은 사용할 수 없음
      //여러 Thread가 하나의 System.out을 사용하면 불안정함
      synchronized (System.out) {
        int count  = this.pos/10;
        for(int j = 0; j < count; j++) {
          System.out.print(".");
        }
        System.out.println(this.name + ": " + this.pos);
      }

      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }//end for
  }

  public static void main(String[] args) {

    Horse h1 = new Horse("아현말");
    Horse h2 = new Horse("승범말");
    Horse h3 = new Horse("민지말");
    Horse h4 = new Horse("정우말");

    h1.start();
    h2.start();
    h3.start();
    h4.start();

  }

}
