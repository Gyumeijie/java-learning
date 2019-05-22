package classloader.customclassloader.delegation;

import classloader.customclassloader.CustomClassLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestClassLoaderOutOfClasspath {
   public static void main(String args[]) throws MalformedURLException, ClassNotFoundException {
      // Output: /Users/yumeijie/idea-workspace/java-learning/out/production/java-learing
      System.out.println(System.getProperty("java.class.path"));

      // File not in `classpath`
      String path = "file:///Users/yumeijie/idea-workspace/java-learning/resources/classloaders/";

      // Output: classloader.customclassloader.CustomClassLoader@33c7353a
      CustomClassLoader customClassLoader = new CustomClassLoader(new URL(path));
      Class<?> klassOne = customClassLoader.loadClass("SampleClass");
      System.out.println(klassOne.getClassLoader());

      // Output: java.net.URLClassLoader@19469ea2
      URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL(path)});
      Class<?> klassTwo = urlClassLoader.loadClass("SampleClass");
      System.out.println(klassTwo.getClassLoader());

      // Output: false
      System.out.println(klassOne.equals(klassTwo));
   }
}
