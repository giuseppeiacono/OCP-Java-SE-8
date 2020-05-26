# Threads
+ [Overview](#overview)
+ [Defining threads](#defining-threads)
+ [Instantiating threads](#instantiating-threads)
+ [Starting threads](#)
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
    * You could override ``run()`` method
    * You could overload ``run()`` method
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
     
For the exam you should know at minimun the following methods of ``Thread`` class:
```java
start()
yield()
sleep()
run()
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

> **WARNING** \
> Invoking directly the method ``run()`` of a ``Thread`` instance DOES NOT mean that it will run in a separate thread!!!

 

## Exam tricks
> **What is and is not guaranteed**
> 
> In the exam you MUST demonstrate to know what IS and IS NOT guaranteed behaviour, regardless the JVM

> **DAEMON threads**
> 
> Don't worry, in the exam there are no questions about this topic!