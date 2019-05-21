#  Compare two Strings in Java

`String` is **immutable** in java. When two or more objects are created
**without new** keyword, then both object refer same value. 


There are many ways to compare two Strings in Java:

- Using == operator
- Using equals() method
- Using compareTo() method
- Using compareToIgnoreCase() method
- Using compare() method

Moreover, The five ways can be categorized into two classes: 

- Reference-Based
> ==

- Value-Based
> equals(), compareTo(), compareToIgnoreCase(), compare()


### ==
> Double equals operator actually compares objects references.

```java
String s1 = "A"; 
String s2 = "A"; 
String s3 = new String("A"); 

s1 == s2 // true
s1 == s3 // false
```

### equals() 
> Compares the two given strings based on the data/content of the string.

```java
String s1 = "A"; 
String s2 = "A";
String s3 = new String("A"); 
String s4 = "a"; 

s1.equals(s2); // true
s1.equals(s3); // true
s1.equals(s4); // false
```

### equalsIgnoreCase()
> similar to equals() method, except that case is ignored.

```java
String s1 = "A"; 
String s2 = "A";
String s3 = new String("A"); 
String s4 = "a"; 

s1.equalsIgnoreCase(s2); // true
s1.equalsIgnoreCase(s3); // true
s1.equalsIgnoreCase(s4); // true
```


### compareTo()
> Compares char value and return difference, Assuming index ‘i’ is where
characters are different then compareTo() will return the result of 
`firstString.charAt(i)-secondString.charAt(i)`.

```java
String s1 = "A"; 
String s2 = "a"; 
String s3 = new String("A");

s1.compareTo(s2); // -32
s1.compareTo(s3); // 0
```

### compare()
> For locale specific comparison, compares value and returns 1, 0, -1.

```java
String s1 = "A"; 
String s2 = "A";
String s3 = new String("A"); 
String s4 = "a";

collator.compare(s1, s2); // 0
collator.compare(s1, s3); // 0
collator.compare(s1, s4); // 1
collator.compare(s4, s1); // -1
```
