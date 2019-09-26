package exceptions;

public class FinallyMisuseDemo {
   public static void main(String[] args) {
      try {
         System.out.println("output: " + func());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static int func() throws Exception {
      for (int i = 0; i < 2; i++) {
         try {
            throw new Exception("func exception");
         } catch (Exception e) {
            throw e;
         } finally {
            /**
             * Using `break`, `return` or `continue` in `finally` block leads finally block
             * exit abnormally and the exception thrown in `try` or `catch` block not be
             * thrown out.
             */

            // break;
            // return 1;
            // continue;
         }
      }

      return 0;
   }
}
