package relections;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class dynamicProxy {
   public static void main(String[] args) {
      Original original = new Original();
      Handler handler = new Handler(original);

      System.out.println(If.class.getClassLoader());

      If f = (If) Proxy.newProxyInstance(If.class.getClassLoader(), new Class[]{If.class}, handler);
      f.originalMethod("proxy test");
   }

   interface If {
      void originalMethod(String s);
   }

   static class Original implements If {
      public void originalMethod(String s) {
         System.out.println(s);
      }
   }

   static class Handler implements InvocationHandler {
      private final If original;

      public Handler(If original) {
         this.original = original;
      }

      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         System.out.println("before call");
         method.invoke(original, args);
         System.out.println("after call");
         return null;
      }
   }
}
