# Threads
+ [Overview](#overview)
+ [Defining threads](#defining-threads)
+ [Instantiating threads](#instantiating-threads)
+ [Starting threads](#starting-threads)
+ [Thread states and transistions](#thread-states-and-transistions)
+ [Sleep threads](#starting-threads)
+ [Exam tricks](#exam-tricks)

## Overview
In this module we treat with the creation of worker threads using ``Runnable``, callable, and the use of the ``ExecutorService``
to concurrently execute tasks.

Then we will see how to identify potential threading problems among deadlock, starvation, livelock and race conditions.

We will end up to learn when we should use ``synchronized`` keyword and how to use ``java.util.concurrent.atomic`` 
package to control the order of thread execution.

## Defining threads
You can define a thread in one of two ways:
 1. Extend the ``java.lang.Thread`` class
    ```java
    class MyThread extends Thread { }
    ```
    * This approach does not allow to extend another class.
    * You could both override and overload ``run()`` method
 2. Implement the ``Runnable`` functional interface
    ```java
    class MyRunnable implements Runnable {
        public void run() {
            System.out.println("MyRunnable is executing");
        }
    }
    ```
    * You must implement ``run()`` method of the interface
    * You can instantiate ``MyRunnable`` with ``new()``
    * You can instantiate ``MyRunnable`` with lambda as ``Runnable``is a functional interface
   
For the exam you should know at minimum the following methods of ``Thread`` class:  
```java
// instance methods
start()
run()
getName()
setName("thread 1")

// static method
yield()
sleep()
Thread.currentThread().getId()  // get a positive unique long number that identify the current thread
Thread.currentThread().getName()  // get the name of the current thread
```

## Instantiating threads
You always need a ``Thread`` to do the job that could be implemented in two way:
 1. with the method ``run()`` of ``Thread`` object instantiated with one of the constructors below
    ```java
    // the method run() of this object is invoked
    Thread()
    Thread(String name)
    ```
 2. with the method ``run()`` of the ``Runnable`` instance. In this case you will pass it to one of the following constructors
    ```java
    // if the target is null, the method run() of the Thread object is invoked
    Thread(Runnable target)
    Thread(Runnable target, String name)
    ```

## Starting threads
Define and instantiating a ``Thread`` is not enough to run it because you need to invoke ``start()`` method on 
the ``Thread`` object. It make three things:
 1. A new thread of execution starts (with a new call stack)
 2. The thread moves from the NEW state to the RUNNABLE state
 3. It is ready to be executed by scheduler
 
You can check in every moment if a thread is alive with the method ``isAlive()``. A thread is alive if it has been started and has not yet died

> **WARNING** \
> Invoking directly the method ``run()`` of a ``Thread`` instance DOES NOT mean that it will run in a separate thread!!!

If you start a single thread it works as we expect, but It's not true when we start multiple threads. 

Nothing is guaranteed except the that each thread will start and will run to completion.
It means that running the same code multiple times on the same machine or on several machines the results could not be the same!!! Why?

The scheduler manages the threads based on its own scheduling policy and we have no the total control over it, but we
can influence the scheduling with the following methods:
```java
// methods of Thread class
public static void sleep(long millis) throws InterruptedException
public static void yield()
public final void join() throws InterruptedException
public final void setPriority(int newPriority)

// method inherited by Object class
public final void wait() throws InterruptedException
public final void notify()
public final void notifyAll()
```

Some example of how to define, instantiate and start a thread is on [DefineInstantiateStartThreads](src/DefineInstantiateStartThreads.java).

## Thread states and transistions
![alt text](readme_resources/thread-states.png)

## Sleep threads
The static method ``Thread.sleep()`` could be invoked in the thread code to sleep it at least for the period of time
specified as parameter (milliseconds). We said AT LEAST because when the thread wake up its state is changed to RUNNABLE.
We don't know how much time it need to be run by scheduler!

> **WARNING**
>
> One thread could not send another thread to sleep 

Look at the sample on [SleepThread](src/SleepThread.java)

## Exam tricks
> **What is and is not guaranteed**
> 
> In the exam you MUST demonstrate to know what IS and IS NOT guaranteed behaviour, regardless the JVM

> **DAEMON threads**
> 
> Don't worry, in the exam there are no questions about this topic!

> **Instantiate thread with another thread**
>
> ```java
> // a bit silly, but LEGAL
> Thread t = new Thread( new MyThread() );
> ```

> **One thread can be started only one time**
>
> The runtime IllegalThreadStateException will be thrown if you start a thread that was executed previously

> **``Thread.sleep()``
>
> Don't rely on this method to give you a perfectly accurate timer!!!