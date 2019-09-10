package io.primitivedata;

import java.io.*;

public class DataInputStreamDemo {
   public static void main(String[] args) {
      try {
         File file = new File("src/io/primitivedata/out.txt");
         FileInputStream fis = new FileInputStream(file.getCanonicalPath());
         DataInputStream dis = new DataInputStream(fis);

         int integer = dis.readInt();
         System.out.println(integer);
         String str = dis.readUTF();
         System.out.println(str);

      } catch (FileNotFoundException e) {
         System.out.println(e.getMessage());
      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
   }
}
