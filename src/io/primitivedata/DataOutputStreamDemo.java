package io.primitivedata;

import java.io.*;

public class DataOutputStreamDemo {
   public static void main(String[] args) {
      try {
         File file = new File("src/io/primitivedata/out.txt");
         FileOutputStream fos = new FileOutputStream(file.getCanonicalPath());
         DataOutputStream dos = new DataOutputStream(fos);
         dos.writeInt(0);
         dos.writeUTF("yumeijie");
         dos.flush();
         dos.close();
      } catch (FileNotFoundException e) {
         System.out.println(e.getMessage());
      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
   }
}
