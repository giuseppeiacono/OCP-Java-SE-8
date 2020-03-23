# I/O and NIO.2
+ [Overview](#overview)
+ [Java I/O fundamentals](#java-io-fundamentals)
    - [Classes involved in the exam](#classes-involved-in-the-exam)
    - [Combining I/O classes](#combining-io-classes)
    - [Work with files and directories](#work-with-files-and-directories)
+ [Java NIO.2](#java-nio2)
+ [Exam tricks](#exam-tricks)

## Overview
This module consists of two main sections:
 1. **I/O**
    - The fundamentals of input/output operations focused on ``java.io`` package
    - The exam is based on I/O features to read/write characters and objects (serialization/deserialization)
  2. **NIO.2**
    - The key new features introduced in Java 7 that reside into ``java.nio.file`` and ``java.nio.file.attribute`` packages 

## Java I/O fundamentals
Follow the classes and features included in the exam.

### Classes involved in the exam
You need to understand the following classes for the exam:

![alt text](readme_resources/file-and-console.png)

![alt text](readme_resources/file-readers-writers.png)

![alt text](readme_resources/stream-input-output.png)

### Combining I/O classes
You must know which chaining combinations of [Classes involved in the exam](#classes-involved-in-the-exam) are legal and which are illegal.

| Class  | Super Class | Key Constructor  Arguments | Key Methods |
| ------ | :---------: | -------------------------- | ----------- |
| File | Object | File, String <br/> String <br/> String, String | createNewFile() <br/> delete() <br/> exists() <br/> isDirectory() <br/> isFile() <br/> list() <br/> mkdir() <br/> renameTo() |
| FileWriter | Writer | File  <br/> String | close() <br/> flush() <br/> write() |
| BufferedWriter | Writer | Writer | close() <br/> flush() <br/> write() <br/> newLine() |
| PrintWriter | Writer | File (as of Java 5) <br/> String (as of Java 5) <br/> OutputStream <br/> Writer | close() <br/> flush() <br/> write() <br/> format(), printf() <br/> print(), println() |
| FileOutputStream | OutputStream | File <br/> String |  write() <br/> close() |
| FileReader | Reader | File <br/> String | read() |
| BufferedReader | Reader | Reader | read() <br/> readLine() |
| FileInputStream | InputStream | File <br/> String | read() <br/> close() |

The class [IOClassesLegalCombinations](src/IOClassesLegalCombinations.java) shows legal combinations of I/O classes above
to get readers and writers from a file.

### Work with files and directories


## Java NIO.2

## Exam tricks
 