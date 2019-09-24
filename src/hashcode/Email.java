package hashcode;

import java.util.HashSet;

/**
 * When put object in `HashSet` or insert `HashMap` as key, we must guarantee the consistency of
 * the hashcode value of the object. Otherwise that object can not be deleted and thus cause memory
 * leakage.
 */
public class Email {
  private String address;

  private Email(String address) {
    this.address = address;
  }

  @Override
  public int hashCode() {
    return address.hashCode();
  }

  public static void main(String[] args) {
    HashSet<Email> set = new HashSet<>();
    Email email = new Email("163.com");
    set.add(email);

    // The hashcode changes
    email.address = "zju.edu.cn";

    System.out.println("Is contained: " + set.contains(email)); // false
    System.out.println(set.size()); // 1
    set.remove(email);
    System.out.println(set.size()); // 1
  }
}
