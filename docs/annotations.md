# Annotations in Java

**Annotations** are used to provide `supplement information` about a program.

- Annotations start with ‘@’.

- Annotations do not change action of a compiled program.

- Annotations help to associate `metadata` (information) to the `program elements` 
i.e. **instance variables**, **constructors**, **methods**, **classes**, etc.

- Annotations are not pure comments as they can change the way a program is 
treated by compiler. See below code for example.

```java

    /* Java program to demonstrate that annotations are 
       not barely comments (This program throws compiler 
       error because we have mentioned override, but not 
       overridden, we have a overloaded display) */
    
    class Base { 
         public void display() { 
             System.out.println("Base display()"); 
         } 
    } 
    
    class Derived extends Base { 
         @Override
         public void display(int x) { 
             System.out.println("Derived display(int )"); 
         } 
      
         public static void main(String args[]) { 
             Derived obj = new Derived(); 
             obj.display(); 
         } 
    }
```

As is expected, the java compiler will throw the following error:
```
error: method does not override or implement a method from a supertype
```