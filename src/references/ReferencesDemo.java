package references;

import org.junit.jupiter.api.Test;

import java.lang.ref.*;
import java.util.Map;
import java.util.WeakHashMap;

import static org.junit.jupiter.api.Assertions.*;


public class ReferencesDemo {
   public static void main(String[] args) {

   }

   @Test
   public void strongReferences() {
      Object referent = new Object();
      // Creating Strong reference by assignment
      Object strongReference = referent;
      assertSame(referent, strongReference);

      referent = null;
      System.gc();

      assertNotNull(strongReference);
   }

   @Test
   /**
    * A weak reference, simply put, is a reference that isn't strong enough to force an
    * object to remain in memory.
    */
   public void WeakReferences() {
      Object referent = new Object();
      WeakReference<Object> weakReference = new WeakReference<>(referent);

      assertSame(referent, weakReference.get());

      referent = null;
      System.gc();

      assertNull(weakReference.get());
   }

   @Test
   /**
    * The WeakHashMap use a type of WeakReference as key, once the key has no strong reference,
    * The corresponding entries will be deleted after the GC.
    */
   public void weakHashMap() throws InterruptedException {
      Map<Object, Object> weakHashMap = new WeakHashMap<>();
      Object key = new Object();
      Object value = new Object();
      weakHashMap.put(key, value);

      assertTrue(weakHashMap.containsValue(value));

      key = null;
      System.gc();

      // Wait entries put into `ReferenceQueue` to be cleared
      Thread.sleep(1000);

      assertFalse(weakHashMap.containsValue(value));
   }


   @Test
   /**
    * A soft reference is exactly like a weak reference, except that it is less eager to throw away the
    * object to which it refers.
    */
   public void softReferences() {
      Object referent = new Object();
      SoftReference<Object> softReference = new SoftReference<>(referent);

      assertNotNull(softReference.get());

      referent = null;
      System.gc();

      // soft references are be reclaimed only when jvm out of memory
      assertNotNull(softReference.get());
   }

   @Test
   /**
    * The only use for such a reference is keeping track of when it gets enqueued into a ReferenceQueue,
    * as at that point you know the object to which it pointed is dead.
    */
   public void phantomReferenceAlawaysNull() {
      Object referent = new Object();
      PhantomReference<Object> phantomReference = new PhantomReference<>(referent, new ReferenceQueue<>());

      assertNull(phantomReference.get());
   }

   @Test
   /**
    * When passed a ReferenceQueue to a Reference Constructor, the jvm will insert
    * the object into the queue when it will be reclaimed.
    */
   public void referenceQueue() throws InterruptedException {
      Object referent = new Object();
      ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
      WeakReference<Object> weakReference = new WeakReference<>(referent, referenceQueue);

      assertFalse(weakReference.isEnqueued());
      Reference<? extends Object> polled = referenceQueue.poll();
      assertNull(polled);

      referent = null;
      System.gc();

      // Wait entries put into `ReferenceQueue` to be cleared
      Thread.sleep(1000);

      assertTrue(weakReference.isEnqueued());
      Reference<? extends Object> removed = referenceQueue.remove();
      assertNotNull(removed);
   }
}
