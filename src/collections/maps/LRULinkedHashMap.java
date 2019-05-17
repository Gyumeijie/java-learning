package collections.maps;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
   private int capacity;

   LRULinkedHashMap(int capacity) {
      // Set true for last access order and false for insertion order
      super(16, 0.75f, true);
      this.capacity = capacity;
   }

   @Override
   public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
      // Return true to remove its eldest entry from the map
      return size() > capacity;
   }
}


class Test {
   public static void main(String args[]) {
      Map<Integer, String> map = new LRULinkedHashMap<>(4);

      map.put(1, "one");
      map.put(2, "two");
      map.put(3, "tree");
      map.put(4, "four");
      map.put(5, "five");

      for (Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
         System.out.println(it.next().getKey());
      }

      map.get(2);
      map.get(5);
      map.put(6, "six");


      for (Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
         System.out.println(it.next().getKey());
      }
   }
}

   /* Outputs:

      2
      3
      4
      5

      4
      2
      5
      6
    */