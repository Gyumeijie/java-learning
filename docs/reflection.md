# Reflection in Java

**Reflection** is an `API` which is used to examine or modify the behavior 
of methods, classes, interfaces at `runtime`.

- The required classes for reflection are provided under java.**lang**.reflect package.

- Invoke methods at runtime irrespective of the `access specifier` used with them.

- get information about **Class**, **Constructors**, **Methods**, **Fields**.


## Important observations

1. We can invoke an method through reflection if we know its `name` and `parameter types`.
We use below two methods for this purpose
    
    **getDeclaredMethod()**: 
    
    ```
    Class.getDeclaredMethod(name, parametertype)
    
    name- the name of method whose object is to be created
    parametertype - parameter is an array of Class objects
    ```
    
    **Invoke()**:
    
    ```
    Method.invoke(Object, parameter)
    
    If the method of the class doesn’t accepts any 
    parameter then null is passed as argument.
    ```
2. Access the private variables and methods of a class with the help of
the **setAccessible** method.

## Advantages of Using Reflection:

- Extensibility Features
- Debugging and testing tools

## Drawbacks

- Performance Overhead
- Exposure of Internals