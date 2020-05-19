# Streams
+ [Overview](#overview)
+ [What is a stream](#what-is-a-stream)
    - [Map-filter-reduce](#map-filter-reduce)
+ [Exam tricks](#exam-tricks)


## Overview
In this module we introduce streams, new addition in Java 8. We will see how they work and the strict relationship with 
lambda and functional interfaces.

## What is a stream
![alt text](readme_resources/stream-characteristics.png)

Take into account that:
 * streams are LAZY: you MUST define the TERMINAL operation to start the execution, else nothing happen!
 * streams can be used only one time, else ``IllegalStateException`` is thrown!
 * stream PIPELINES are very efficient when you work with a large amount of data. Some streams could be parallelized to get more efficiency
 * each INTERMEDIATE operation return a stream
 
Stream pipelines are so good because Java optimize the execution of multiple operations as we can see in the example below:
![alt text](readme_resources/stream-pipeline-execution-flow.png)


You can create streams of both objects and primitive values. For the exam you MUST BE able to recognize each type and
their methods.

**Stream of objects** \
The class [StreamOfObjects](src/StreamOfObjects.java) shows the ways to get stream of objects from several data structure.

Follow the methods of ``Stream`` class for the exam:

| Method | Return |
| :----- | :----: |
| ``filter ( Predicate<? super T> predicate )`` | ``Stream<T>`` |
| ``reduce ( BinaryOperator<T> accumulator )`` | ``Optional<T>`` |
| ``reduce ( T identity, BinaryOperator<T> accumulator )`` | ``T ``|
| ``count()`` | ``long`` |

**Stream of primitive values** \
The class [StreamOfPrimitives](src/StreamOfPrimitives.java) shows how to get a stream of integer, double or long primitives values.

It's really important to understand that they have their own little world. It means:
 * custom classes for the streams != ``Stream``
 * custom classes for the binary operators and predicates
 * INTERMEDIATE operations which return a value or an optional value
 * and so on...

Follow the methods and classes involved in the exam:
 
| Interface | Method | Return |
| :-------- | :----- | :----: |
| ``IntStream`` | ``filter ( IntPredicate predicate )`` | ``IntStream`` |
| ``DoubleStream`` | ``filter ( DoublePredicate predicate )`` | ``DoubleStream`` |
| ``LongStream`` | ``filter ( LongPredicate predicate )`` | ``LongStream`` |
| ``IntStream`` | ``reduce ( IntBinaryOperator op )`` | ``OptionalInt`` |
| ``IntStream`` | ``reduce ( int identity, IntBinaryOperator op )`` | ``int`` |
| ``DoubleStream`` | ``reduce( DoubleBinaryOperator op )`` | ``OptionalDouble`` |
| ``DoubleStream`` | ``reduce( double identity, DoubleBinaryOperator op )`` | ``double`` |
| ``LongStream`` | ``reduce ( LongBinaryOperator op )`` | ``OptionalLong`` |
| ``LongStream`` | ``reduce ( long identity, LongBinaryOperator op )`` | ``long`` |
| ``DoubleStream``, <br/> ``IntStream``, <br/> ``LongStream`` | ``count()`` | ``long`` |
| ``DoubleStream``, <br/> ``IntStream``, <br/> ``LongStream`` | ``sum()`` | ``double, int, long`` |
| ``DoubleStream``, <br/> ``IntStream``, <br/> ``LongStream`` | ``average()`` | ``OptionalDouble`` |
| ``DoubleStream``, <br/> ``IntStream``, <br/> ``LongStream`` | ``max()`` <br/> ``min()`` | ``OptionalDouble`` <br/> ``OptionalInt`` <br/> ``OptionalLong`` |

### Map-filter-reduce
We can process streams in three steps:
 1. **Map**: convert each data into another one. For example, we have a list of objects and we map 
         the integer field of each object with the corresponding square
 2. **Filter**: apply one or more filters to the collection
 3. **Reduce**: invoke the TERMINAL operation that return a value or an OPTIONAL value
 
> **Think of reductions as accumulators**: they accumulate values from the
>  stream so they can compute one value
 
In addition to the reduce operation offered by Java API, you can write your own reduction using ``reduce()`` method.
 
Look at the samples into [MapFilterReduceMethods](src/MapFilterReduceMethods.java) for more details.
 
## Exam tricks
> **Stream of Wrapper class != stream of primitives**
>
> Be careful on the exam:
> ```
> // streams of wrapper classes are stream of objects
> Stream<Integer>
> Stream<Double>
> Stream<Long>
> 
> // streams of primitives values
> IntStream
> DoubleStream
> LongStream
> ```