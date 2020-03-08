# Object orientation
+ [Overview](#overview)
+ [Singleton Design Pattern](#singleton-design-pattern) 
    - [Singleton initialization](#singleton-initialization)
    - [Benefits](#benefits)

## Overview
This chapter of Oracle book resume a lot of the concepts concerning to ``OCA Java SE 8`` certification. 
As this project is focused on the topics covered in the ``OCP Java SE 8`` exam, you can see below just notes about these.

## Singleton Design Pattern
The OCP exam covers only this design pattern.

The singleton pattern is useful when we need to manage some information from a single instance (called the singleton). 
The key parts of this pattern are:
1. store the singleton on a ``private static final`` variable
2. ``public static`` method to get the singleton
3. ``private`` constructor so no callers can instantiate the object directly

Look at a couple of examples to understand how this pattern could be implemented before and after Java 8:
* [SingletonOldStyle](/src/java/main/SingletonOldStyle.java) 
* [SingletonNewStyle](/src/java/main/SingletonNewStyle.java)

### Singleton initialization
There are two way to initialize the singleton object:
 * **Eager**: create the object before we need it. Useful if the object isn't expensive to create or we need it every time the program runs
 * **Lazy**: create the object on the first use
 
### Benefits
* There is only one instance of the object in the program that keep track of information used across the application
* The performance is better in case of objects that would be expensive to create
