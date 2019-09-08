package multithread.priority;

class ThreadA extends Thread {
   @Override
   public void run() {
      for (int i = 0; i < 4; i++) {
         System.out.println("From ThreadA: i= " + i);
      }
      System.out.println("Exit from A");
   }
}

class ThreadB extends Thread {
   @Override
   public void run() {
      for (int i = 0; i < 4; i++) {
         System.out.println("From ThreadB: i= " + i);
      }
      System.out.println("Exit from B");
   }
}

class ThreadC extends Thread {
   @Override
   public void run() {
      for (int i = 0; i < 4; i++) {
         System.out.println("From ThreadC: i= " + i);
      }
      System.out.println("Exit from C");
   }
}

public class ThreadPriority {
   public static void main(String[] args) {
      ThreadA threadA = new ThreadA();
      ThreadB threadB = new ThreadB();
      ThreadC threadC = new ThreadC();

      threadC.setPriority(Thread.MAX_PRIORITY);
      threadB.setPriority(threadA.getPriority() + 1);
      threadA.setPriority(Thread.MIN_PRIORITY);

      System.out.println("Started Thread A");
      threadA.start();
      System.out.println("Started Thread B");
      threadB.start();
      System.out.println("Started Thread C");
      threadC.start();
   }
}
