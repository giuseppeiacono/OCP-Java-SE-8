# Assertions and exceptions
+ [Overview](#overview)
+ [Assertions](#assertions)
    - [How to enable and disable assertions](#how-to-enable-and-disable-assertions)


## Overview
This module shows how to use assertions and how to manage exceptions with the new try statements provided by Java 8.

## Assertions
Assertions are used to check a condition that should be always true, else an ``AssertionError`` is thrown and it should never, ever be handled!

There are two types of assertions:
 * __really simple__
 * __simple__

The only difference between them is that the __simple__ assertion consists of a boolean expression followed by a primitive or object that could be converted into a String. 
It is added to the stack trace. Look at this [example](/src/assertion/Assertion.java).

> **EXAM trick** \
> Any question about assertions that refers to "expression" without specify if it is a boolean test or the value to print in the stack trace,
> ALWAYS assume that it is a boolean expression 

### How to enable and disable assertions

> WARNINNG : Assertions are DISABLED by default at runtime!!!

Assertions are managed by specific JVM options:
 * enable assertions: ``-ea`` or ``-enableassertions`` 
 * DISABLE assertions: ``-da`` or ``-disableassertions`` 

Follow some examples of how to use options above in several ways: 
```
// Enable assertions in general
java -ea com.assertion.MyClass
java -enableassertions com.assertion.MyClass

// DISABLE assertions
java -da com.assertion.MyClass
java -disableassertions com.assertion.MyClass

// Enable assertions in general, except for a class
java -ea -da com.assertion.MyClass

// Enable assertions in general, except for a package
java -ea -da com.assertion...
```