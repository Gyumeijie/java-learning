package multithread.concurrency;

class MathSin extends Thread {
   public double deg;
   public double res;

   public MathSin(int degree) {
      deg = degree;
   }

   @Override
   public void run() {
      System.out.println("Executing sin of " + deg);
      double deg2Rad = Math.toRadians(deg);
      res = Math.sin(deg2Rad);
      System.out.println("Exit from MathSin. Res = " + res);
   }
}

class MathCos extends Thread {
   public double deg;
   public double res;

   public MathCos(int degree) {
      deg = degree;
   }

   @Override
   public void run() {
      System.out.println("Executing cos of " + deg);
      double deg2Rad = Math.toRadians(deg);
      res = Math.cos(deg2Rad);
      System.out.println("Exit from MathCos. Res = " + res);
   }
}

class MathTan extends Thread {
   public double deg;
   public double res;

   public MathTan(int degree) {
      deg = degree;
   }

   @Override
   public void run() {
      System.out.println("Executing tan of " + deg);
      double deg2Rad = Math.toRadians(deg);
      res = Math.tan(deg2Rad);
      System.out.println("Exit from MathTan. Res = " + res);
   }
}


public class MathThreads {
   public static void main(String[] args) {
      MathSin st = new MathSin(45);
      MathCos ct = new MathCos(60);
      MathTan tt = new MathTan(30);
      st.start();
      ct.start();
      tt.start();

      /*
       * Worker threads are concurrently executed on shared or dedicated CPUs
       * depending on the type of machine.
       */
      try {
         st.join();
         ct.join();
         tt.join();
         double res = st.res + ct.res + tt.res;
         System.out.println("Sum of sin, cos, tan = " + res);
      } catch (Exception e) {

      }
   }
}
