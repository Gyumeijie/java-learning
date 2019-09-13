package string;

public class StringDemo {

   public static void main(String[] args) {
      // String creation
      StringBuffer stringBuffer = new StringBuffer("Hello");
      stringBuffer.append("YuMeiJie");
      System.out.println(stringBuffer);

      StringBuilder stringBuilder = new StringBuilder("Hello");
      stringBuilder.append("YuMeiJie");
      System.out.println(stringBuilder);

      // String methods
      System.out.println(stringBuilder.length()); // 13

      System.out.println(stringBuilder.charAt(0)); // H

      System.out.println(stringBuilder.substring(0, 5)); // Hello

      System.out.println("Hello".concat("YuMeiJie")); // HelloYuMeiJie

      System.out.println(stringBuilder.indexOf("e")); // 1
      System.out.println(stringBuilder.lastIndexOf("e")); // 12

      System.out.println("YuMeiJie".equals("YuMeiJie")); // true
      System.out.println("YuMeiJie".equalsIgnoreCase("yumeijie")); // true

      System.out.println("yumeijie".toUpperCase()); // YUMEIJIE
      System.out.println("YUMEIJIE".toLowerCase()); // yumeijie

      System.out.println(" YuMeiJie ".trim()); // "YuMeiJie"

      System.out.println("YuMeiJie".replace('e', 'E')); // YuMEiJiE
      System.out.println("YuMeiJie".replaceFirst("e", "E")); // YuMEiJie

      System.out.println("YuMeiJie".contains("Mei")); // true
      String subs[] = "http://github.com".split(":");
      for (String str : subs) {
         System.out.println(str); // http //github.com
      }

      System.out.println("YuMeiJie".endsWith("Jie")); // true
      System.out.println("YuMeiji".startsWith("Yu")); // true
   }
}
