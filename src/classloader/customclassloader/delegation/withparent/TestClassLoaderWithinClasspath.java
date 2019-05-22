package classloader.customclassloader.delegation.withparent;

import classloader.customclassloader.CustomClassLoaderWithParent;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestClassLoaderWithinClasspath {
   public static void main(String args[]) throws MalformedURLException, ClassNotFoundException {
      // Output: /Users/yumeijie/idea-workspace/java-learning/out/production/java-learing
      System.out.println(System.getProperty("java.class.path"));

      // File in `classpath`, thus can and will be loaded by application class loader
      String path = "file:///Users/yumeijie/idea-workspace/java-learning/out/production/java-learing/classloader/customclassloader/";

      URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL(path)});
      CustomClassLoaderWithParent customClassLoader = new CustomClassLoaderWithParent(new URL(path), urlClassLoader);

      // Output: jdk.internal.loader.ClassLoaders$AppClassLoader@3d4eac69
      Class<?> klassOne = customClassLoader.loadClass("classloader.customclassloader.delegation.SampleClass");
      System.out.println(klassOne.getClassLoader());

      // Output: jdk.internal.loader.ClassLoaders$AppClassLoader@3d4eac69
      Class<?> klassTwo = urlClassLoader.loadClass("classloader.customclassloader.delegation.SampleClass");
      System.out.println(klassTwo.getClassLoader());

      // Output: true
      System.out.println(klassOne.equals(klassTwo));
   }
}