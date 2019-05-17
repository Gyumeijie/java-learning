package comparison;

/**
 * Java Program to demonstrate how string in switch functionality is
 * implemented in Java SE 7 release.
 * IntelliJ IDEA with arguments:
 * 1. Take the Run menu
 * 2. Select Edit Configurations
 * 3. Fill the Program arguments field
 */
public class StringInSwitchCase {

   public static void main(String[] args) {

      String mode = args[0];

      switch (mode) {
         case "ACTIVE":
            System.out.println("Application is running on Active mode");
            break;
         case "PASSIVE":
            System.out.println("Application is running on Passive mode");
            break;
         case "SAFE":
            System.out.println("Application is running on Safe mode");
      }
   }
}


/* Decompiled Code: javap StringInSwitchCase

   import java.io.PrintStream;

   public class StringInSwitchCase{

       public StringInSwitchCase() {
       }

       public static void main(string args[]) {
           String mode = args[0];
           String s;
           switch ((s = mode).hashCode()) {
               default:
                   break;
               case -74056953:
                   if (s.equals("PASSIVE")) {
                       System.out.println("Application is running on Passive mode");
                   }
                   break;
               case 2537357:
                   if (s.equals("SAFE")) {
                       System.out.println("Application is running on Safe mode");
                   }
                   break;
               case 1925346054:
                   if (s.equals("ACTIVE")) {
                       System.out.println("Application is running on Active mode");
                   }
                   break;
           }
       }
   }
 */