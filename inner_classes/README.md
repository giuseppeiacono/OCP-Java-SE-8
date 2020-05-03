# Inner classes
+ [Overview](#overview)
+ [Types of inner classes](#types-of-inner-classes)
    - [Nested classes](#nested-classes)
    - [Method-local inner classes](#method-local-inner-classes)
    - [Anonymous classes](#anonymous-classes)
+ [Lambda as inner classes](#lambda-as-inner-classes)
+ [Static classes](#static-classes)
+ [Exam tricks](#exam-tricks)

## Overview
This module is focused on the different types of inner classes and those cases where we can replace
the specific type of inner class with LAMBDA.

The static classes are not inner classes, but they are included in this chapter of the official Oracle book.

## Types of inner classes
In this section we will discuss the three types of inner classes:
 * Nested classes 
 * Method-local inner classes
 * Anonymous classes

### Nested classes
 * It is declared at the same level of instance variables
 * It MUST BE instantiated by the outer class to be used
 * It can be instantiated and used by an external class
 * It can access all members of the outer class
 * From within the nested class:
    * ``this`` references the nested class
    * ``MyOuter.this`` references the outer class

Look at [InnerNestedClass](src/InnerNestedClass.java).
   
### Method-local inner classes
 * It is declared beneath an INSTANCE or STATIC method. It MUST BE instantiated in the method where it is declared
 * It CANNOT modify the local variables. It would produce a COMPILER ERROR!
 * The method would be only ``abstract`` or ``final``, never both at the same time!
 * If the inner class is declared beneath a STATIC method remember that you can use ``this`` or instance variables/methods, 
   as normally is for the static methods
   
Look at [MethodLocalInnerClass](src/MethodLocalInnerClass.java).

### Anonymous classes
 * The anonymous classes are called in this way because they have no name. 
 * They are declared at the same level of instance variables 
 * They consists of two types:
    * **Subclass**: override methods of the superclass
    * **Implementors**: implements the methods of an interface
    
Both types are instantiated with ``new``. We know that Java does not allow to instantiate an interface, but in this case 
it create for us an instance of a class that implements the interface.

Look at [AnonymousInnerClasses](src/AnonymousInnerClasses.java) for more details.

## Lambda as inner classes
We know that lambda can replace a functional interface. It means that every inner class regarding functional interfaces
can be substituted with the corresponding lambda expressions.

Look at [LambdaAsInnerClass](src/LambdaAsInnerClass.java).

## Static classes


## Exam tricks
> **Anonymous classes semicolon**
>
> ```java
> Popcorn p = new Popcorn() {
>     public void pop() {
>         System.out.println("anonymous popcorn");
>     }
> }   // COMPILER ERROR: missing semicolon
> ```

> **Method-local inner class**
>
> Subclasses CANNOT declare their own methods:
> ```java
> class Popcorn {
>     public void pop() {
>         System.out.println("popcorn");
>     }
>  }
> 
> class Food {
>     Popcorn p = new Popcorn() {
> 
>        // ILLEGAL: Popcorn class has no this method!
>         public void sizzle() {
>             System.out.println("anonymous sizzling popcorn");
>         }
> 
>         public void pop() {
>             System.out.println("anonymous popcorn");
>         }
>     };
> }
> ```