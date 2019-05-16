package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class simpleStreamDemo {

   public static void main(String args[]) {

      List<Integer> number = Arrays.asList(2, 3, 4, 5);
      List<Integer> square = number.stream().map(x -> x * x)
                                   .collect(Collectors.toList());

      // [4, 9, 16, 25]
      System.out.println(square);
      square.forEach(System.out::println);

      // 2, 4
      number.stream().filter(x -> x % 2==0).forEach(System.out::println);

      // 14
      int sum = number.stream().reduce(0, (acc, x) -> acc + x);
      System.out.println(sum);

      // true
      boolean answer = number.stream().allMatch(x -> x > 0);
      System.out.println(answer);

      // true
      answer = number.stream().anyMatch(x -> x > 4);
      System.out.println(answer);

      // false
      answer = number.stream().noneMatch(x -> x < 3);
      System.out.println(answer);

      // 6
      Stream<Integer> integer = Stream.of(1, 2, 3, 4, 5, 6);
      System.out.println(integer.collect(Collectors.counting()));

      // 6 7 8 9 10
      IntStream stream = IntStream.range(1, 10);
      //  discarding the first 5 elements of the stream.
      stream.skip(5).forEach(System.out::println);

      // 6 7 8 9 10
      List<Integer> unsorted = Arrays.asList(10, 9, 8, 7, 6);
      unsorted.stream().sorted().forEach(System.out::println);
   }
}
