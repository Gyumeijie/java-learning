package functionals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
   public static void main(String[] args) {
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

      // Print all even numbers
      eval(list, n -> n % 2==0);

      // Print all numbers greater than 3
      eval(list, n -> n > 3);

      // public interface Predicate {
      //    boolean test(T t);
      //}
      Predicate<Integer> odd = (value) -> value % 2==1;
      eval(list, odd);

   }

   public static void eval(List<Integer> list, Predicate<Integer> predicate) {
      for (Integer n : list) {
         if (predicate.test(n)) {
            System.out.println(n + " ");
         }
      }
   }
}
