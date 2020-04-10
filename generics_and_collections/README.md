# Object orientation
+ [Overview](#overview)
+ [Override ``equals()``](#override-equals)
+ [Override ``hashCode()``](#ovverride-hashcode)
+ [Collections](#collections)
    - [Collections framework](#collections-framework)
        * [Core interfaces](#core-interfaces)
        * [Implementation classes](#implementation-classes)
    - [Choose the best collections implementation class](#choose-the-best-collections-implementation-class)
        + [``List``](#list)
        + [``Set``](#set)
        + [``Map``](#map)
        + [``Queue``](#queue)
    - [Using Collections](#using-collections)
        + [Boxing with ``==`` and ``equlas()``](#boxing-with--and-equlas)
        + [``Comparable`` vs ``Comparator``](#comparable-vs-comparator)
+ [Exam tricks](#exam-tricks)

## Overview
This module consists of three main topics:
 1. ``equals()`` and ``hashCode()``: why we should override them, what are their contracts and how they are related
 2. Java collections: the most important classes to create collections and how they work
 3. Java generics
 
Don't worry! The scope of the exam is not to be a guru of Java collections and generics because they are huge topics.
We will learn just the most important aspects for the exam and some extra knowledge to have a strong base for the future. 

## Override ``equals()``

![alt text](readme_resources/why-override-%20equals.png)

| equlas() contract| |
| :---: | :---: |
| reflexive | ``x.equals(x)`` is always ``true`` |
| symmetric | ``x.equals(y)`` is ``true`` <br/> if and only if <br/> ``y.equals(x)`` is ``true`` |
| transitive | if ``x.equals(y)`` is ``true`` <br/> and ``y.equals(z)`` is ``true`` <br/> then ``x.equals(z)`` MUST BE ``true``  |
| consistent | multiple invocatoins of ``x.equals(y)`` return the same value |
| ``null`` reference | ``x.equals(null)`` is always ``false`` |

## Ovverride ``hashCode()``
The hashcode is used to increase the performance of large collections based on hashtable during the storing and localization of data.

As in the same bucket of the hashtable we can have more than one entry, the retrieval process consists of two steps:
 1. use ``hashCode()`` to find the bucket
 2. use ``equals()`` to locate the right element
 
It means that if two objects are considered equal using the ``equals()`` method, then they MUST have identical hashcode values. 
So to be truly safe, your rule of thumb should be:
 > if you override ``equals()`` , override ``hashCode()`` as well

| hashCode() contract|
| ----   |
| Provided that no information used in equals() comparisons on the object is modified, <br/> multiple invocations of ``hashCode()`` on the same object MUST return the same integer |
| if ``x.equals(y)`` is ``true`` <br/> x and y MUST HAVE the same hashcode |
| if ``x.equals(y)`` is ``false`` <br/> is NOT REQUIRED that x and y hashcode must be distinct |

## Collections
This section resumes the most important details concerning to the interfaces and classes of the ``Collections`` framework involved in the exam.

### Collections framework
Follow the interfaces and implementation classes of [the Collections framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html) 
which you should know for the exam and that could be considered a strong base to work with Java collections.

#### Core interfaces

![alt text](readme_resources/collections-core-interfaces.png)

#### Implementation classes

![alt text](readme_resources/collections-map-classes.png)

![alt text](readme_resources/collections-set-classes.png)

![alt text](readme_resources/collections-list-classes.png)

![alt text](readme_resources/collections-queue-deque-classes.png)

### How to choose the best implementation
How to choose the best implementation class of collections framework for our purpose?

#### List
 * **``LinkedList``**
    * fast insertion and deletion
 * **``ArrayList``** 
    * fast iteration
    * you don't expect a lot of insertion and deletion
    
#### Set
 * **``HashSet``**
    * no duplicates
    * no order
    * higher access performance depending on ``hashCode()`` implementation
  * **``LinkedHashSet``**
    * iterate through the elements in the order in which they were inserted
  * **``TreeSet``**
    * natural order (in ascending order) or custom order (by ``Comparator``)
    
#### Map
 * **``HashMap``**
    * no order
    * no sorter
    * allows null keys or values
    * higher access performance depending on ``hashCode()`` implementation
 * **``Hashtable``**
    * synchronized
    * does NOT allow null keys or values
 * **``LinkedHashMap``**
    * fast iteration
 * **``TreeMap``**
    * natural order (in ascending order) or custom order (by ``Comparator``)
 
#### Queue
 * **``PriorityQueue``**
    * natural order (in ascending order) 
    * custom order (by ``Comparator``)
    * custom priority-in, priority-out where the order represents their RELATIVE priority
 * **``ArrayDeque``**
    * to implement queue or stack
    * double-ended queue
    * high performance

### Using Collections
We know the most important interfaces and classes of the Collections framework and how to choose the best collection
implementation for our purpose. Now it's time to know how to use them!

#### Boxing with ``==`` and ``equlas()``
In order to save memory, two instances of the following wrapper objects (created through boxing) will always be == when their
primitive values are the same:
 * Boolean
 * Byte
 * Character from \u0000 to \u007f (7f is 127 in decimal)
 * Short and Integer from –128 to 127
> **WARNING**
>
> Take care with Integer and Short, as shows the example below:
> ```java
> Integer a1 = 127;
> Integer a2 = 127;
> Integer b1= 128;
> Integer b2 = 128;
> System.out.println( a1 == a2 ); // true because the value belong to [-128, 127]
> System.out.println( b1 == b2 ); // false based on the above
> ```

The second thing you MUST remember is that wrapper reference variable can be ``null``. 
It means that the developer is in charge of to check it, else JVM will throws a ``NullPointerException`` at runtime. 

#### ``Comparable`` vs ``Comparator``
It's really important to understand what are these interfaces and how to use them because of many reasons.

They are used to impose a total ordering on collections of objects:
 * ``Comparable`` defines a natural order (alphabetically, number value, ...)
 * ``Comparator`` defines a custom order based on object's properties
    
> **WARNING**
>
> Collections could be sorted if and only if the objects implements at least one of the interfaces above, as they define 
> the total order. In the other cases, the compiler will get something like this when we try to sort the elements:
> ```java
> TestDVD.java:13: cannot find symbol
> symbol : method sort(java.util.ArrayList<DVDInfo>)
> location: class java.util.Collections
> Collections.sort(dvdlist);
> ```

The table highlight the differences between these interfaces.

| Difference | ``Comparable`` | ``Comparator`` |
| :--------- | :------------- | :------------- |
| Method syntax | ``int a.compareTo(b)`` | ``int compare(a, b)`` |
| Class impact | The class must be changed accordingly | The comparator is implemented on a separated class |
| Multiple ways to order objects | No | Yes, as much as I need |
| Implemented by some Java API classes | Yes, for example ``String`` , wrapper classes, ``LocalDate``, ``LocalTime`` ... | No, because it was introduced to define a custom order |
| Replaceable with Lambda | No | Yes, because it is a [functional interface](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html) |

## Exam tricks
> **Valid override of ``equals()``, ``hashCode()`` and ``toString()``** \
> Make sure to know the rules of overriding to avoid the following errors:
>   ```java
>   class Foo {
>     // it is not a valid override because it should be public hashCode() contract
>     boolean equals(Object o) { } 
>     int hashCode() { } 
>     String toString() { } 
>   }
>   ```
>   ```java
>   class Foo {
>     // it's not an override, but a valid overload because the argument type is not Object 
>     public boolean equals(Foo o) { }
>   }
>   ```

> **hashcode tricky exam questions** \
> appropriate/correct != legal != efficient
> 
> It is legal return the same hashcode for every instance, but it's terribly inefficient because it means that
> all objects will be put in the same bucket

> **``hashCode()`` is a MUST when...** \
> ``HashSet`` and ``LinkedHashSet``does not allow duplicates as dictated by ``Set`` contract. 
> It means that ``equals()`` must be override to identify duplicates, so you MUST override ``hashCode()`` too

> **Interface means interface, class means class** \
> If you are asked to choos an interface, choose an interface, NOT a class! And vice versa...

> **Take care about argument type!** \
> ``equals()`` take an argument of type ``Object``
> ``compareTo()`` take an argument of the type you are sorting

> **Diamond syntax reminder** \
> ```java
> ArrayList<String> stuff = new ArrayList<>() // legal from Java 7
> 
> List<> stuff = new ArrayList<String>(); // NOT legal
> ```