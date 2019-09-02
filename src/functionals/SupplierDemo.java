package functionals;

import java.util.function.Supplier;

public class SupplierDemo {

   // Abstract type for operation which takes no value but returns something


   public static String stringSupplier(Supplier<String> supplier) {
      return supplier.get();
   }


   public static Integer integerSupplier(Supplier<Integer> supplier) {
      return supplier.get();
   }

   public static void main(String[] args) {
      String name = "YumMiJie";
      System.out.println(stringSupplier(() -> name.length() + ""));
      System.out.println(integerSupplier(() -> name.length()));
   }
}