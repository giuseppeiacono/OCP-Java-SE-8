# Object orientation
+ [Overview](#overview)
+ [Instanceof operator](#instanceof-operator)
+ [Singleton Design Pattern](#singleton-design-pattern) 
    - [Singleton initialization](#singleton-initialization)
    - [Benefits](#benefits)
+ [Immutable classes](#immutable-classes)

## Overview
This chapter of Oracle book resume a lot of the concepts concerning to ``OCA Java SE 8`` certification. 
As this project is focused on the topics covered in the ``OCP Java SE 8`` exam, you can see below just notes about these.

## Instanceof operator
The instanceof operator **CANNOT BE USED** if there is no relationship between the object and the type compared!!!

If you do it, you'll get a compilation error as shown it the example below:

> ```
> File f = new File("myFile.txt");
> FileWriter fw = new FileWriter(f);
> BufferedWriter bw = new BufferedWriter(fw);
> if (bw instanceof String) {
>       System.out.println("bw is of type String");
> }
> 
> // COMPILATION ERROR
> incompatible types: java.io.BufferedWriter cannot be converted to java.lang.String
> ```

## Singleton Design Pattern
The OCP exam covers only this design pattern.

The singleton pattern is useful when we need to manage some information from a single instance (called the singleton). 
The key parts of this pattern are:
1. store the singleton on a ``private static final`` variable
2. ``public static`` method to get the singleton
3. ``private`` constructor so no callers can instantiate the object directly

Look at a couple of examples to understand how this pattern could be implemented before and after Java 8:
* [SingletonOldStyle](src/SingletonOldStyle.java) 
* [SingletonNewStyle](src/SingletonNewStyle.java)

### Singleton initialization
There are two way to initialize the singleton object:
 * **Eager**: create the object before we need it. Useful if the object isn't expensive to create or we need it every time the program runs
 * **Lazy**: create the object on the first use
 
### Benefits
* There is only one instance of the object in the program that keep track of information used across the application
* The performance is better in case of objects that would be expensive to create

## Immutable classes
One class is considered immutable if it has all the requirements below:
 * It is ``final`` so that it cannot be extended
 * Its variables are ``private`` and ``final``
 * The constructor make new copies of any mutable object
 * Do not provide any setter method
 * If any of the getter methods return a mutable object reference, make a copy of the actual object, and return the reference to the copy 