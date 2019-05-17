package comparison;

import java.util.HashSet;
import java.util.Set;

class Name {
   private String firstname, lastname;

   public Name(String firstname, String lastname) {
      this.firstname = firstname;
      this.lastname = lastname;

   }

   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof Name)) return false;

      Name name = (Name) obj;
      return name.firstname.equals(firstname) && name.lastname.equals(lastname);
   }

   @Override
   public int hashCode() {
      // The hashCode of String object returns a hash code for this string
      return firstname.hashCode() + lastname.hashCode();
   }

}

public class hashCodeDemo {

   public static void main(String[] args) {
      Set<Name> set = new HashSet<>();
      set.add(new Name("Yu", "Meijie"));
      System.out.println(set.contains(new Name("Yu", "Meijie")));
   }
}

   /* Output:

      true
    */