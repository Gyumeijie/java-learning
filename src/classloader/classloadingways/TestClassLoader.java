package classloader.classloadingways;

public class TestClassLoader {

   public static void main(String args[]) throws ClassNotFoundException {
      // It's important to use an fully qualified name to load a class

      // Output:
      // ClassLoader classLoader = TestClassLoaderOutOfClasspath.class.getClassLoader();
      // Class<?> klazz = classLoader.loadClass("classloader.classloadingways.resources.classloaders.SampleClass");

      // Output java.lang.ClassNotFoundException: [I
      // klazz = ClassLoader.getSystemClassLoader().loadClass("[I");
      // System.out.println(klazz);


      // Output: static initialized code resources.classloaders.SampleClass
      Class<?> klazz = Class.forName("classloader.classloadingways.SampleClass");

      // Output: class [I
      klazz = Class.forName("[I");
      System.out.println(klazz);
   }
}
