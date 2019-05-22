package classloader.customclassloader.delegation.withparent;

import classloader.customclassloader.CustomClassLoaderWithParent;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestClassLoaderOutOfClasspath {
   public static void main(String args[]) throws MalformedURLException, ClassNotFoundException {
      // Output: /Users/yumeijie/idea-workspace/java-learning/out/production/java-learing
      System.out.println(System.getProperty("java.class.path"));

      // File not in `classpath`
      String path = "file:///Users/yumeijie/idea-workspace/java-learning/resources/classloaders/";
      URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL(path)});
      CustomClassLoaderWithParent customClassLoader = new CustomClassLoaderWithParent(new URL(path), urlClassLoader);

      // Output: java.net.URLClassLoader@19469ea2, delegates to the parent: URLClassLoader
      Class<?> klassOne = customClassLoader.loadClass("SampleClass");
      System.out.println(klassOne.getClassLoader());

      // Output: java.net.URLClassLoader@19469ea2
      Class<?> klassTwo = urlClassLoader.loadClass("SampleClass");
      System.out.println(klassTwo.getClassLoader());

      // Output: true
      System.out.println(klassOne.equals(klassTwo));
   }
}
