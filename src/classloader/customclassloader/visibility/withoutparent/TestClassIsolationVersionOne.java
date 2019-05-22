package classloader.customclassloader.visibility.withoutparent;

import classloader.customclassloader.CustomClassLoader;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestClassIsolationVersionOne {

   public static void main(String args[]) throws MalformedURLException, ClassNotFoundException, NoSuchFieldException,
           NoSuchMethodException, InstantiationException, InvocationTargetException, IllegalAccessException {
      // Output: /Users/yumeijie/idea-workspace/java-learning/out/production/java-learing
      System.out.println(System.getProperty("java.class.path"));

      // File not in `classpath`, and the last slash is required
      String path = "file:///Users/yumeijie/idea-workspace/java-learning/resources/classloaders/visiblity/isolation/";


      CustomClassLoader customClassLoader = new CustomClassLoader(new URL(path));
      Class<?> klassOne = customClassLoader.loadClass("ParentClass");
      // Output: classloader.customclassloader.CustomClassLoader@33c7353a
      System.out.println(klassOne.getClassLoader());
      Method method = klassOne.getDeclaredMethod("parentMethod");
      Object instance = klassOne.getDeclaredConstructors()[0].newInstance();
      // Output: parent class name: parentclass
      method.invoke(instance);


      Field field = klassOne.getDeclaredField("name");
      field.setAccessible(true);
      field.set(klassOne, "newParentClass");
      instance = klassOne.getDeclaredConstructors()[0].newInstance();
      // Output: parent class name: newParentClass
      method.invoke(instance);


      URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL(path)});
      Class<?> klassTwo = urlClassLoader.loadClass("ChildClass");
      // Output: java.net.URLClassLoader@3b9a45b3
      System.out.println(klassTwo.getClassLoader());
      method = klassTwo.getDeclaredMethod("childMethod");
      instance = klassTwo.getDeclaredConstructors()[0].newInstance();
      // parent class name: parentclass
      method.invoke(instance);


      // Output: false
      Class<?> klassThree = urlClassLoader.loadClass("ParentClass");
      Class<?> klassFour = customClassLoader.loadClass("ParentClass");
      System.out.println(klassFour.equals(klassThree));
   }
}