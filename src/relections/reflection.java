package relections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test {
   private String string;

   public Test() {
      string = "test-relections.reflection-in-java";
   }

   public void methodOne() {
      System.out.println("The string is " + string);
   }


   public void methodTwo(int i) {
      System.out.println("The integer is " + i);
   }


   public void methodThree(float f) {
      System.out.println("The float is " + f);
   }

   private void methodFour() {
      System.out.println("Private method invoked");
   }
}

public class reflection {

   public static void main(String args[]) throws Exception {
      Test obj = new Test();

      Class cls = obj.getClass();
      System.out.println("The name of class is " + cls);

      /* Problem: unhandled exception: java.lang.NoSuchMethodException
       * Solution: append `throws Exception` to the main */
      Constructor constructor = cls.getConstructor();
      System.out.println("The name of constructor is " + constructor.getName());

      Method[] methods = cls.getMethods();
      for (Method method : methods) {
         System.out.println(method.getName());
      }

      Method methodcall = cls.getDeclaredMethod("methodOne");
      methodcall.invoke(obj);

      /* Problem: java.lang.NoSuchMethodException: relections.Test.methodTwo()
       * Solution: add `int.class` */
      methodcall = cls.getDeclaredMethod("methodTwo", int.class);
      methodcall.invoke(obj, 1);

      /* Problem: java.lang.NoSuchMethodException: relections.Test.methodThree(int)
       * Solution: use `float.class` other than `int.class` */
      methodcall = cls.getDeclaredMethod("methodThree", float.class);
      /* Problem: java.lang.IllegalArgumentException: argument type mismatch
       * Solution: use 3.1415926f instead of 3.1415926 */
      methodcall.invoke(obj, 3.1415926f);


      Field field = cls.getDeclaredField("string");
      System.out.println("The field is " + field.getName());
      /* Problem: java.lang.IllegalAccessException class relections.reflection cannot access a member
       *         of class relections.Test with modifiers "private"
       * Solution: add field.setAccessible(true) */
      field.setAccessible(true);
      field.set(obj, "try-relections.reflection-in-java");

      methodcall = cls.getDeclaredMethod("methodOne");
      methodcall.invoke(obj);

      methodcall = cls.getDeclaredMethod("methodFour");
      methodcall.setAccessible(true);
      methodcall.invoke(obj);
   }
}

   /* Output:

      The name of class is class relections.Test
      The name of constructor is relections.Test
      methodOne
      methodTwo
      methodThree
      wait
      wait
      wait
      equals
      toString
      hashCode
      getClass
      notify
      notifyAll
      The string is test-relections.reflection-in-java
      The integer is 1
      The float is 3.1415925
      The field is string
      The string is try-relections.reflection-in-java
      Private method invoked
   */