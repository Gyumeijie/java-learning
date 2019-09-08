package multithread.creation;

/*
 *  When a Thread object's run() method is invoked directly, the statements in
 *  the run() method are executed by the "current thread" thread than by the
 *  "newly created thread".
 */

class ThreadRun extends Thread {
   @Override
   public void run() {
      Thread currentThread = Thread.currentThread();
      System.out.println(currentThread.getName() + " " + currentThread.getId());
      System.out.println("ThreadRun is running");
   }
}

class ThreadImplement implements Runnable {
   @Override
   public void run() {
      Thread currentThread = Thread.currentThread();
      System.out.println(currentThread.getName() + " " + currentThread.getId());
      System.out.println("ThreadImplement is running");
   }
}

public class ThreadRunOrStart {

   public static void main(String[] args) {

      Thread currentThread = Thread.currentThread();
      System.out.println(currentThread.getName() + " " + currentThread.getId());

      // Run in newly created thread
      Thread threadRun = new ThreadRun();
      threadRun.start();

      // Run in current thread
      Thread threadImplement = new Thread(new ThreadImplement());
      threadImplement.run();
   }
}
