package optionals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalDemo {

   public static void main(String[] args) {
   }

   @Test
   public void Optional_IsPresent() {
      String name = "yumeijie";
      Optional<String> opt = Optional.of(name);
      assertTrue(opt.isPresent());
   }

   @Test
   public void Optional_IsEmpty() {
      String name = null;
      Optional<String> opt = Optional.ofNullable(name);
      assertTrue(opt.isEmpty());
   }

   @Test
   // Conditional Action with ifPresent()
   public void Optional_IfPresent() {
      String str = null;
      if (str!=null) {
         System.out.println(str);
      }

      Optional<String> opt = Optional.of("yumeijie");
      opt.ifPresent(name -> System.out.println(name));
   }

   @Test
   // Default value with orElse()
   public void Optional_OrElse() {
      String nullName = null;
      String name = Optional.ofNullable(nullName).orElse("yumeijie");
      assertEquals("yumeijie", name);
   }

   @Test
   // Default value with orElseGet()
   public void Optional_OrElseGet() {
      String nullName = null;
      String name = Optional.ofNullable(nullName).orElseGet(() -> "yumeijie");
      assertEquals("yumejie", name);
   }

   @Test
   public void Optional_OrElseThrow() {
      String nullName = null;
      assertThrows(IllegalArgumentException.class, () -> {
         Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
      });
   }

   @Test
   // Returning value with get()
   public void Optional_Get() {
      Optional<String> opt = Optional.of("yumeijie");
      String name = opt.get();
      assertEquals("yumeijie", name);
   }

   @Test
   // Conditional return with filter()
   public void Optional_Filter() {
      Integer year = 2019;
      Optional<Integer> yearOptional = Optional.of(year);
      boolean is2019 = yearOptional.filter(y -> y==2019).isPresent();
      assertTrue(is2019);
      boolean is2020 = yearOptional.filter(y -> y==2020).isPresent();
      assertFalse(is2020);
   }

   @Test
   // Transforming value with map()
   public void Optional_Map() {
      List<String> companyNames = Arrays.asList("alibaba", "huawei",
              "tencent", "baidu");
      Optional<List<String>> listOptional = Optional.of(companyNames);

      int size = listOptional.map(List::size).orElse(0);
      assertEquals(4, size);
   }
}
