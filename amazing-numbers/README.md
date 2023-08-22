# Amazing Numbers

Welcome to the Amazing Number Properties project! This is a Java project which is one of the projects in the
Hyperskill's <a href="https://hyperskill.org/tracks/8"><i>Introduction to Java</i></a> track. Find the details of the project 
<a href="https://hyperskill.org/projects/184?track=8">here</a>.

In this program, we explore the fascinating world of <a href="https://en.wikipedia.org/wiki/Recreational_mathematics">recreational mathematics</a> and 
<a href="https://en.wikipedia.org/wiki/Number_theory">number theory</a>. 
Numbers are an integral part of our daily lives, but did you know that they possess a myriad of interesting properties beyond their numerical values? 
This project delves into some of these captivating number properties and provides you with the tools to identify and classify them programmatically.

## About

Recreational mathematics is a branch of mathematics that focuses on engaging and intriguing mathematical concepts that are not necessarily tied to practical applications. 
It allows us to explore the aesthetic and intellectual aspects of mathematics, providing a unique perspective on numbers and their relationships.

Number theory, on the other hand, is a more formal branch of mathematics that deals specifically with the properties and relationships of integers. 
It encompasses topics such as prime numbers, divisibility, modular arithmetic, and various number sequences. Within this realm, we encounter a diverse array of number types, 
each with its own distinct set of characteristics.

## Number Types Explored

Throughout this project, we'll delve into the following types of numbers:

- **Buzz Number**: A number that is divisible by 7 or ends with the digit 7.
- **Duck Number**: A number with at least one zero digit that is not zero itself.
- **Palindromic Number**: A number that reads the same forwards and backwards.
- **Gapful Number**: A number that is formed by concatenating its first and last digit, and is divisible by that number.
- **Spy Number**: A number whose sum of digits is equal to the product of its digits.
- **Sunny Number**: A number that is one greater than a perfect square.
- **Square Number**: A number that is the result of multiplying an integer by itself.
- **Jumping Number**: A number where the absolute difference between adjacent digits is 1.
- **Happy Number**: A number that eventually reaches the value 1 when a specific operation is repeatedly applied to its digits.
- **Sad Number**: A number that enters a cycle without reaching the value 1 when subjected to the same operation.

## Implementation and Features

In this program, you'll be able to learn what properties a number has, select all the numbers 
in a particular range with the specified properties, you can include and exclude properties to be shown, and more! All you have to do is to input what you want
to know without worrying about the algorithms that are run under the hood!

A demo below might be insightful for you to better understand the structure of the program:

```
Welcome to Amazing Numbers!

Supported requests:
- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
  * the first parameter represents a starting number;
  * the second parameter shows how many consecutive numbers are to be processed;
- two natural numbers and properties to search for;
- a property preceded by minus must not be present in numbers;
- separate the parameters with one space;
- enter 0 to exit.

Enter a request: 1 10

               1 is odd, palindromic, spy, square, jumping, happy
               2 is even, palindromic, spy, jumping, sad
               3 is odd, palindromic, spy, sunny, jumping, sad
               4 is even, palindromic, spy, square, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
               8 is even, palindromic, spy, sunny, jumping, sad
               9 is odd, palindromic, spy, square, jumping, sad
              10 is even, duck, jumping, happy

Enter a request: 1 5 -odd

               2 is even, palindromic, spy, jumping, sad
               4 is even, palindromic, spy, square, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               8 is even, palindromic, spy, sunny, jumping, sad
              10 is even, duck, jumping, happy

Enter a request: 1 5 -even

               1 is odd, palindromic, spy, square, jumping, happy
               3 is odd, palindromic, spy, sunny, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
               9 is odd, palindromic, spy, square, jumping, sad

Enter a request: 1 5 -odd -even gapful

The request contains mutually exclusive properties: [-ODD, -EVEN]
There are no numbers with these properties.

Enter a request: 1 5 odd square -odd

The request contains mutually exclusive properties: [-ODD, ODD]
There are no numbers with these properties.

Enter a request: 1 5 sunny square

The request contains mutually exclusive properties: [SQUARE, SUNNY]
There are no numbers with these properties.

Enter a request: 1 5 -sunny -square

               2 is even, palindromic, spy, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
              10 is even, duck, jumping, happy
```

## Contact

Many thanks for checking my project out! Please do not hesitate contact me regarding any subject. You can mail me
<a href="mailto:leventpolat408@gmail.com">here</a>.
