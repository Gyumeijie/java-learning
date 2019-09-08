package multithread.creation;


class ThreadByExtends extends Thread {
   @Override
   public void run() {
      System.out.println("thread created by extends is running...");
   }
}

class ThreadByImplement implements Runnable {
   public void run() {
      System.out.println("tread created by implement is running...");
   }

}

public class ThreadCreation {
   public static void main(String[] args) {
      Thread threadByExtends = new ThreadByExtends();
      threadByExtends.start();

      // Thread threadByImplement = new Thread(new ThreadByImplement());
      // threadByImplement.start();

      // The threadByImplement has only method called run()
      ThreadByImplement threadByImplement = new ThreadByImplement();
      threadByImplement.run();
   }
}
