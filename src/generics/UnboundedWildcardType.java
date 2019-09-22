package generics;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcardType {
   public static void printAll(List<?> list) {
      for (Object item : list) {
         System.out.println(item + " ");
      }
   }

   public static void main(String[] args) {
      List<Integer> integerList = Arrays.asList(1, 2, 3);
      printAll(integerList);

      List<Double> doubleList = Arrays.asList(1.0, 2.1, 3.2);
      printAll(doubleList);

      List<String> stringList = Arrays.asList("1", "2", "3", "4");
      printAll(stringList);
   }
}
