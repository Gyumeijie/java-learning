package generics;

import java.util.Arrays;
import java.util.List;

public class BoundedWildcardType {
   public static void main(String[] args) {
      // Upper Bounded Wildcards
      List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
      System.out.println("Total sum is:" + sum(integerList));

      List<Double> doubleList = Arrays.asList(1.0, 2.1, 3.2, 4.3);
      System.out.println("Total sum is:" + sum(doubleList));

      // Lower Bounded Wildcards
      List<Number> numberList = Arrays.asList(5, 6, 7, 8);
      printOnlyIntegerClassOrSuperClass(integerList);
      printOnlyIntegerClassOrSuperClass(numberList);

      // printOnlyIntegerClassOrSuperClass(doubleList);
   }

   // (Inclusive)Upper bound: subclass which extends the Number
   private static double sum(List<? extends Number> list) {
      double sum = 0.0;
      for (Number i : list) {
         sum += i.doubleValue();
      }
      return sum;
   }

   // (Inclusive)Lower bound: class itself and it's superclass
   private static void printOnlyIntegerClassOrSuperClass(List<? super Integer> list) {
      System.out.println(list);
   }
}
