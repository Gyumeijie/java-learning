package annotations.simpleDemo;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SimpleAnnotation {

   String developer() default "Gyumejie";

   String expirydate();
}

class Development {
   @SimpleAnnotation(developer = "YuMeiJie", expirydate = "06-01-2019")
   void methodOne() {
      System.out.println("Test method one");
   }

   @SimpleAnnotation(expirydate = "06-01-2019")
   void methodTwo() {
      System.out.println("Test method one");
   }

}

public class TestAnnotation {

   public static void main(String args[]) throws Exception {
      Class cls = new Development().getClass();
      Method methodOne = cls.getDeclaredMethod("methodOne");

      SimpleAnnotation annotation;
      if (methodOne.isAnnotationPresent(SimpleAnnotation.class)) {
         annotation = methodOne.getAnnotation(SimpleAnnotation.class);
         System.out.println(annotation.developer() + " : " + annotation.expirydate());
      }

      Method methodTwo = cls.getDeclaredMethod("methodTwo");
      if (methodTwo.isAnnotationPresent(SimpleAnnotation.class)) {
         annotation = methodTwo.getAnnotation(SimpleAnnotation.class);
         System.out.println(annotation.developer() + " : " + annotation.expirydate());
      }


   }
}

   /*  Output:

       YuMeiJie : 06-01-2019
       Gyumejie : 06-01-2019
    */