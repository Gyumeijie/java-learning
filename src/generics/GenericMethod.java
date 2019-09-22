package generics;

public class GenericMethod {
   public static void main(String[] args) {
      Integer[] integerArray = {1, 2, 3, 4};
      printArray(integerArray);

      Double[] doubleArray = {1.0, 2.1, 3.2, 4.3};
      printArray(doubleArray);
   }

   // All generic method declarations have a type parameter section delimited by angle
   // brackets (< and >) that precedes the method's return type(<E> in this example)
   private static <E> void printArray(E[] inputArray) {
      for (E element : inputArray) {
         System.out.printf("%s ", element);
      }
   }
}
