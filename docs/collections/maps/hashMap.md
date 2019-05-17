# HashMap in Java


## Performance of HashMap

Performance of HashMap depends on 2 parameters:

- Initial Capacity, defaults to 16
- Load Factor, defaults to 0.75
> Most generally preferred load factor value is **0.75** which provides a 
good deal between time and space costs.


## Synchronized HashMap

HashMap is **unsynchronized** i.e. multiple threads can access it simultaneously.
The `Collections.synchronizedMap()` can make HashMap synchronized and avoid accidental
non-synchronized access.


## Resizing overhead

If you need to store a lot of data, you should create your HashMap with 
an `initial capacity` close to your expected volume.

By initially setting your expected size, you can avoid these costly operations.


## Key immutability

`String`, `Integer` and other `wrapper classes` are natural candidates of HashMap key,
because they are **immutable**!

If you choose to create your own Key class and don’t make it immutable, 
you might ***lose data*** inside the HashMap.


## Thread Safety

**HashMap** is `not threads safe`, for example during the `auto-resizing` mechanism,
if a thread tries to put or get an object, the map might use the old index value 
and won’t find the new bucket in which the entry is.

**HashTable** is a `thread safe` implementation that prevents from this situation.
But, since all the CRUD methods are synchronized this implementation is very slow.

**ConcurrentHashMap** is a smarter implementation of a thread safe HashMap, 
so multiples threads can get(), remove() or put() data at the same time if it 
doesn't imply accessing the same bucket or resizing the inner array.
It’s better to use this implementation in a **multithreaded** application.


