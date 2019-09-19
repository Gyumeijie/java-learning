package collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SimpleMapDemo {
   public static void main(String[] args) {
      unOrderedMap();
      System.out.println("------------------");
      orderedMap();
   }

   public static void unOrderedMap() {
      // The HashMap is unordered
      Map<Double, Integer> maps = new HashMap<>();
      maps.put(0.1, 1);
      maps.put(0.2, 2);
      maps.put(1.0 / 3, 3);
      System.out.println(maps.get(1.0 / 3)); // 3

      for (Double key : maps.keySet()) {
         System.out.println(key);
      }

      // Use iterator
      Iterator<Map.Entry<Double, Integer>> it = maps.entrySet().iterator();
      while (it.hasNext()) {
         Map.Entry<Double, Integer> entry = it.next();
         System.out.println(entry.getKey() + " : " + entry.getValue());
      }

      // Iterate big capacity map
      for (Map.Entry<Double, Integer> entry : maps.entrySet()) {
         System.out.println(entry.getKey() + " : " + entry.getValue());
      }

      for (Integer value : maps.values()) {
         System.out.println(value);
      }
   }

   public static void orderedMap() {
      // The TreeMap is ordered
      Map<Double, Integer> maps = new TreeMap<>();
      maps.put(0.1, 1);
      maps.put(0.2, 2);
      maps.put(1.0 / 3, 3);
      System.out.println(maps.get(1.0 / 3)); // 3

      for (Double key : maps.keySet()) {
         System.out.println(key);
      }

      // Use iterator
      Iterator<Map.Entry<Double, Integer>> it = maps.entrySet().iterator();
      while (it.hasNext()) {
         Map.Entry<Double, Integer> entry = it.next();
         System.out.println(entry.getKey() + " : " + entry.getValue());
      }

      // Iterate big capacity map
      for (Map.Entry<Double, Integer> entry : maps.entrySet()) {
         System.out.println(entry.getKey() + " : " + entry.getValue());
      }

      for (Integer value : maps.values()) {
         System.out.println(value);
      }
   }
}
