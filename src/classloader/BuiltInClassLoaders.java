package classloader;


import java.util.ArrayList;


public class BuiltInClassLoaders {

   public static void main(String args[]) {

      /* System or Application class loader:
       * It loads files found in the classpath environment variable, -classpath or
       * -cp command line option.
       *
       * Output: jdk.internal.loader.ClassLoaders$AppClassLoader@3d4eac69
       */
      System.out.println("Classloader of this class: " + BuiltInClassLoaders.class.getClassLoader());
      System.out.println(Thread.currentThread().getContextClassLoader());
      System.out.println(ClassLoader.getSystemClassLoader());

      /* Extension Class Loader:
       * Loading the extensions of the standard core Java classes, from the JDK
       * extensions directory, usually $JAVA_HOME/lib/ext directory or any other
       * directory mentioned in the java.ext.dirs system property
       *
       * Output: jdk.internal.loader.ClassLoaders$ExtClassLoader@xxxxxxxx
       */
      // System.out.println("Classloader of Logging: " + Logging.class.getClassLoader());


      /* Bootstrap Class Loader:
       * Loading JDK internal classes, typically rt.jar and other core libraries
       * located in $JAVA_HOME/jre/lib directory.
       *
       * Output: null
       */
      System.out.println("Classloader of ArrayList: " + ArrayList.class.getClassLoader());
   }
}
