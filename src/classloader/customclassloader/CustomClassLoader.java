package classloader.customclassloader;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {
   private URL url;

   public CustomClassLoader(URL url) {
      super(new URL[]{url});
      this.url = url;
   }
}
