package threadEx;

public class Ex1 {

  public static void main(String[] args) throws Exception {

    // 섞여서 실행. 실행 될 때마다 다르게 나옴
    new Thread(() -> {

      for(int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName() + " A" + i);
        try {
          Thread.sleep(100); //0.1초 쉬었다가 실행할거임
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }).start();

    for(int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + " B" + i);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

}