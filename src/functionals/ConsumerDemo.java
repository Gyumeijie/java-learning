package functionals;

import java.util.function.Consumer;

public class ConsumerDemo {

   public static void main(String[] args) {
      // Function<Integer, Void> consumer = (value) -> null;
      // Function<Integer, Integer> consumer = (value) -> value;
      Consumer<Integer> consumer = (value) -> System.out.println(value);
      integerConsumer(1, consumer);
   }

   // Abstract for operation which takes an argument but returns nothing
   public static void integerConsumer(Integer value, Consumer<Integer> consumer) {
      consumer.accept(value);
   }
}
