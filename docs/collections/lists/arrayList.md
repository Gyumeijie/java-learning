# ArrayList in Java

ArrayList is a part of collection framework. It provides us `dynamic arrays`
in Java. Though, it may be **slower than** standard arrays but can be helpful
in programs where **lots of manipulation** in the array is needed.


## Array vs ArrayList

#### Resizable 

**Array** is static in size that is fixed length data structure;
**ArrayList** is dynamic in size

#### Performance
> Performance of Array and ArrayList depends on the operation you are performing.

resize() opertation: automatic resize of ArrayList will slow down the performance.

add() or get() operation: adding an element or retrieving an element from the array 
or arraylist object has almost same  performance.

#### Primitives

ArrayList can not contains primitive data types (like int , float , double) 
it can only contains Object while Array can contain both primitive data types 
as well as objects.

JVM through **Autoboxing** (converting primitives to equivalent objects internally)
ensures that only objects are added to the arraylist object. 

#### Multi-dimensional

Array can be multi dimensional , while ArrayList is always single dimensional.