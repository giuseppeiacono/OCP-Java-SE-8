# Concurrency
+ [Overview](#overview)
+ [``java.util.concurrent`](#javautilconcurrent)
    - [Atomic package](#atomic-package)
    - [Locks package](#locks-package)
    - [ReentrantLock](#reentrantlock)


## Overview
In this module we will see how to create and manage a multithreading application that use all the power of the modern 
multicore devices.

The package ``java.util.concurrent`` provides several classes to do it.

## ``java.util.concurrent``

![alt text](readme_resources/java-util-concurrent-package.png)

### Atomic package
Classes of this package are thread-safe because they use CAS (Compare and Swap) instructions of the modern CPU. This 
behaviour is provided by method ``compareAndSet(...)``.

Look at [AtomicCounter](src/AtomicCounter.java).

### Locks package
Nowadays there is no vast difference between performance of ``synchronized`` keyword and ``java.util.concurrent`` classes.

Some reasons why use the ``java.util.concurrent.locks`` package: 
 * The ability to duplicate traditional synchronized blocks
 * Nonblock scoped locking—obtain a lock in one method and release it in another (this can be dangerous, though)
 * Multiple wait / notify / notifyAll pools per lock—threads can select which pool ( ``Condition`` ) they wait on
 * The ability to attempt to acquire a lock and take an alternative action if locking fails
 * An implementation of a multiple-reader, single-writer lock

### ReentrantLock
We know that the first step to access shared resources in a multithreading application is always get the lock on the object.
We can get it with synchronized methods/blocks, but ``ReentrantLock`` gives us alternatives with some benefits.

The first thing to do is always get the lock as follow
```java
Lock lock = new ReentrantLock();
```

At this point we have three options to lock the shared resource depending on our purpose:
 1. ``lock.lock()`` is the equivalent of synchronized methods/blocks. Get immediately the lock or blocks until acquire it
 2. ``lock.tryLock()`` if the lock fails come back later instead of wait until it is released
 3. ``lock.tryLock(2, TimeUnit.SECONDS)`` wait for the lock at maximum two seconds, else try again later to get the lock
 
The examples code are available on [ReentrantLockSamples](src/ReentrantLockSamples.java).