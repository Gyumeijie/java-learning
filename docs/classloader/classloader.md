# Class Loaders in Java

**Loading** refers to the process of finding the `binary form` of a class
or interface type with a particular name, perhaps by computing it on the 
fly, but more typically by retrieving a binary representation previously 
computed from source code by a Java compiler, and constructing, from that
binary from, a **Class** object to represent the class or interface.

Class loaders are responsible for **loading Java classes during runtime
dynamically to the JVM**. The JVM doesn't need to know the underlying files
or file systems in order to run Java programs thanks to class loaders.

Also, these Java classes aren't loaded into memory all at once, but dynamically
required by an application. This is where class loaders come into picture.

Every `class object` have a **classLoader** member, which can be get by
calling `cls.getClassloader()`

```
class Class<T> {
  ...
  private final ClassLoader classLoader;
  ...
}
```

## Types of Built-in Class Loaders

There are three important class loaders: **application**, **extension**, 
and **bootstrap**, and they play different roles in loading classes into
memory.

### Bootstrap Class Loader

It’s mainly responsible for loading JDK internal classes, typically **rt.jar**
and other core libraries located in `$JAVA_HOME/jre/lib directory`. Additionally, 
**Bootstrap class loader serves as a parent of all the other ClassLoader instances**.

Because the bootstrap class loader is written in native code, not Java – 
so it doesn’t show up as a Java class.

```java

// Class loader of ArrayList:null
System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
```

### Extension Class Loader

The extension class loader is a child of the bootstrap class loader and 
takes care of loading the **extensions** of the standard core Java classes. 


Extension class loader loads from the JDK extensions directory,  usually 
`$JAVA_HOME/lib/ext` directory or any other directory mentioned in the
`java.ext.dirs` **system property**.


### System Class Loader
> ClassLoader.getSystemClassLoader() or ClassLoaders$AppClassLoader

The system or application class loader, on the other hand, takes care of 
loading **all** the **application level** classes into the JVM. 

It loads files found in the classpath environment variable, `-classpath`
or `-cp` command line option. Also, it’s a child of Extensions classloader.


## Delegation Model

Class loaders follow the delegation model where on request to find a 
class or resource, a ClassLoader instance will delegate the search of the
class or resource to the **parent class loader**.

Only if the parent class loader is unsuccessful in loading the class, 
the current class loader tries to load the class itself.

Let’s say we have a request to load an application class into the JVM. 
The `system class loader` first delegates the loading of that class to its 
parent `extension class loader` which in turn delegates it to the `bootstrap 
class loader`.

![delegation-model](https://raw.githubusercontent.com/Gyumeijie/assets/master/java-learning/delegation-model.png)

## Class Isolation

The class loader can be treated as a class container which cached a group
of binary representation of class and interfaces.

The same class loaded by different loader is treated differently, i.e. they
are different.

The class loader provides a virtual isolation namespace. children class 
loaders are visible to classes loaded by its parent class loaders, but
not vice-versa.

![class-isolation](https://raw.githubusercontent.com/Gyumeijie/assets/master/java-learning/class-isolation.png)

## Class.forName vs loadClass

`Class.forName("SomeClass");` will use the class loader that loaded the 
class which calls this code and initialize the class (that is, all static
initializers will be run). 

`someClassloader.loadClass("SomeClass");` not initialize the class.

