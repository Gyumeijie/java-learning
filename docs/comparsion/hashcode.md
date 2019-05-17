# HashCode method in Java

> returns a hash code value for the object.

`HashMap` and `HashSet` use hashing to manipulate data. They use **hashCode()** 
method to check hash values. 

## Default Implementation

As much as is reasonably practical, the hashCode method defined by class
**java.lang.Object** does return `distinct integers` for `distinct objects`. 
 
This is typically implemented by converting the `internal address` of the object
into an `integer`, but this implementation technique is not required by the Java<sup>TM</sup>
programming language.

> The String object has overridden the default **hashCode** method by returning
a hash code for this string.

## Practice of hashCode

In order to achieve a fully working custom equality mechanism, it is mandatory
to `override hashcode()` each time you `override equals()`. Follow the tips below 
and you'll never have leaks in your custom equality mechanism:

- If two objects are equal, they **MUST** have the same hash code.

- If two objects have the same hash code, it doesn't mean that they are equal.

- Overriding **equals()** `alone` will make your business fail with hashing 
data structures like: **HashSet**, **HashMap**, **HashTable** ... etc.

- Overriding **hashcode()** `alone` doesn't force Java to ignore `memory addresses` 
when comparing two objects.

