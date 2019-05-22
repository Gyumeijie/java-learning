package classloader.customclassloader;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoaderWithParent extends URLClassLoader {
   private URL url;

   public CustomClassLoaderWithParent(URL url, ClassLoader parent) {
      super(new URL[]{url}, parent);
      this.url = url;
   }

   /**
    * The findClass method get called only the class without setting parent, or
    * the parent can not find the class.
    */
   @Override
   protected Class<?> findClass(String name) throws ClassNotFoundException {
      System.out.println("Loaded from :" + url + " class: " + name);

      Class<?> klass = super.findClass(name);
      return klass;
   }
}
