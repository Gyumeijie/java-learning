package stream.collectors;


import java.util.*;

import static java.util.stream.Collectors.*;

public class CollectorsDemo {

   public static void main(String[] args) {
      List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
      System.out.println(givenList);

      /*
       * ToList collector can be used for collecting all Stream elements into a List instance.
       * The important thing to remember is the fact that we can't assume any particular List
       * implementation with this method. If you want to have more control over this, use toCollection instead.
       */
      List<String> resultList = givenList.stream().collect(toList());
      for (String item : resultList) {
         System.out.println(item);
      }

      givenList = Arrays.asList("a", "a", "b", "b", "c");
      Set<String> resultSet = givenList.stream().collect(toSet());
      for (String item : resultSet) {
         System.out.println(item);
      }

      String resultString = givenList.stream().collect(joining(" ", "prefix-", "-postfix"));
      System.out.println(resultString);

      givenList = Arrays.asList("a", "bb", "ccc", "dd");
      // {1=[a], 2=[bb, dd], 3=[ccc]}
      Map<Integer, Set<String>> resultMapIS = givenList.stream().collect(groupingBy(String::length, toSet()));
      System.out.println(resultMapIS);

      // {false=[a, bb, dd], true=[ccc]}
      Map<Boolean, List<String>> resultMapBL = givenList.stream().collect(partitioningBy(s -> s.length() > 2));
      System.out.println(resultMapBL);


      List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
      // Optional<Integer> min = numbers.stream().collect(minBy(Integer::compareTo));
      // Optional<Integer> max = numbers.stream().collect(minBy(Integer::compareTo));
      List<Optional<Integer>> resultLOI = numbers.stream().collect(teeing(minBy(Integer::compareTo), maxBy(Integer::compareTo),
              (min, max) -> {
                 // List<Integer>
                 List<Optional<Integer>> list = new LinkedList<>();
                 list.add(min);
                 list.add(max);
                 return list;
              }));

      // [Optional[2], Optional[42]]
      System.out.println(resultLOI);
   }
}
