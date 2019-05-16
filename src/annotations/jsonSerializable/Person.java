package annotations.jsonSerializable;

@JsonSerializable
public class Person {

   @JsonElement
   private String firstName;

   @JsonElement
   private String lastName;

   @JsonElement(key = "personAge")
   private String age;

   private String address;

   public Person(String firstName, String lastName) {
      super();
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public Person(String firstName, String lastName, String age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
   }

   private String captialize(String name) {
      return name.substring(0, 1).toUpperCase() + name.substring(1);
   }

   @Init
   private void initNames() {
      this.firstName = captialize(this.firstName);
      this.lastName = captialize(this.lastName);
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getAge() {
      return age;
   }

   public void setAge(String age) {
      this.age = age;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}


class Test {

   public static void main(String args[]) throws JsonSerializationException {
      Person person = new Person("yu", "meijie", "25");
      ObjectToJsonConverter converter = new ObjectToJsonConverter();

      String jsonString = converter.convertToJson(person);

      String expected = "{\"personAge\":\"25\",\"firstName\":\"Yu\",\"lastName\":\"Meijie\"}";
      System.out.println(jsonString.equals(expected));
   }
}

      /*  Output:

          true
       */