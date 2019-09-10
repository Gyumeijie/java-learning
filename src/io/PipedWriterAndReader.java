package io;

import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedWriterAndReader {
   public static void main(String[] args) {
      try {
         final PipedReader reader = new PipedReader();
         final PipedWriter writer = new PipedWriter(reader);

         Thread readerThread = new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                  int data = reader.read();
                  while (data!=-1) {
                     System.out.print((char) data);
                     data = reader.read();
                  }
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
         });

         Thread writerThread = new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                  writer.write("java pipe".toCharArray());
                  writer.close();
               } catch (Exception e) {
                  e.printStackTrace();
               }

            }
         });

         readerThread.start();
         writerThread.start();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
