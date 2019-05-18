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

### @Retention
> A retention policy determines at what point annotation should be **discarded**.

Java defined 3 types of retention policies through `java.lang.annotation`.
RetentionPolicy enumeration. It has **SOURCE**, **CLASS** and **RUNTIME**.
And the default retention policy type is **CLASS**.

Annotation with retention policy **SOURCE** will be `retained` only with **source code**, 
and `discarded` during **compile time**.

Annotation with retention policy **CLASS** will be `retained` till **compiling the code**, 
and `discarded` during **runtime**.

Annotation with retention policy **RUNTIME** will be available to the JVM through **runtime**.


### @Target
> Indicates the kinds of program element to which an annotation type is applicable.

- ElementType.TYPE: 
> Class, interface (including annotation type), or enum declaration
- ElementType.CONSTRUCTOR
> Constructor declaration
- ElementType.FIELD
> Field declaration (includes enum constants)
- ElementType.LOCAL_VARIABLE
> Local variable declaration
- ElementType.METHOD
> Method declaration
- ElementType.PACKAGE
> Package declaration
- ElementType.PARAMETER
> Parameter declaration

### @Document
> Indicates that annotations with a type are to be documented by javadoc 
and similar tools by default.

### @Inherited
> Indicates that an annotation type is automatically inherited.

