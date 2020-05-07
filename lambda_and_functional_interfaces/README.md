# Lambda expressions and functional interfaces
+ [Overview](#overview)
+ [Lambda expression](#lambda-expression)
+ [Functional interfaces](#functional-interfaces)

## Overview
In this module we dive into lambda details and we learn how to use some important functional interfaces of Java.

## Lambda expression
Follow equivalent lambda expression just to brush up on the syntax:
```java
// optional parenthesis for the parameter
DogQuerier dq = (d) -> d.getAge() > 9;
DogQuerier dq = d -> d.getAge() > 9;

// mandatory parenthesis because of the parameter type
DogQuerier dq = (Dog d) -> d.getAge() > 9;

// mandatory parenthesis because there is more than one parameter
DogQuerier dq = (d, n) -> d.getAge() > n;

// optional curly braces if there is only one statement 
DogQuerier dq = d -> { return d.getAge() > 9; };
```

Lambda expression could be passed in to method, as parameter.

> **EFFECTIVELY final variable** is a variable or parameter whose value isn't changed after it is initialized

What variables can I access from lambda? And what can I do with them?
 1. you can use the value of both final and effectively final variable, but you can't change their values!
 2. you can define and use variables in the body of lambda
```java
final String catType = "persian";   // final variable 
int numCats = 3;                    // EFFECTIVELY final variable

DogQuerier dqWithCats = d -> {
    // legal because the variable is defined and used in the body of lambda
    int numBalls = 1;
    numBalls++;
    System.out.println("Number of balls: " + numBalls);

    numCats++;  // COMPILER ERROR: can't change variable defined out of the body lambda

    // legal because you can use the value of final and EFFECTIVELY final variables
    System.out.println("Number of cats: " + numCats); 

    return d.getAge() > 9;
};
```

## Functional interfaces