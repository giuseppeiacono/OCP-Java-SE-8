# Object orientation
+ [Overview](#overview)
+ [Override ``equals()``](#override-equals)
+ [Override ``hashCode()``](#ovverride-hashcode)
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


## Exam tricks
> **Valid override of ``equals()``, ``hashCode()`` and ``toString()``** \
> Make sure to know the rules of overriding to avoid the following errors:
>   ```java
>   class Foo {
>     // it is not a valid override because it should be public 
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