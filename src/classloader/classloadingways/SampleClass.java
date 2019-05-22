package classloader.classloadingways;

public class SampleClass {
   private static String name;

   static {
      name = "resources.classloaders.SampleClass";
      System.out.println(" static initialized code " + name);
   }
}