# Bulls and Cows

## About

This program is an implementation of the famous code-breaking game 
**<a href="https://en.wikipedia.org/wiki/Bulls_and_Cows"><i>Bulls and Cows</i>**</a>.

This project is one of the projects in the Hyperskill's <a href="https://hyperskill.org/tracks/8">Introduction to
Java track</a>. Find the details of the project <a href="https://hyperskill.org/projects/53?track=8">here</a>.

## Implementation and Features

The program generates a random code with a length of user desire. The numbers 0 through 9 (inclusive) is always used
to generate the secret code. Should the user wants to include lowercase letters a through z (inclusive), the user can
also ensure that.

The flow of the program below may be insightful: 

```
Please, enter the secret code's length (Q to quit):
> 4 // A secret code of length 4 will be generated

Input the number of possible symbols in the code (Q to quit):
> 16 // Secret code will be generated from 16 unique symbols (10 numbers, 6 lowercase letters)

The secret is prepared: **** (0-9, a-f).
Okay, let's start a game!
Turn 1:
> 1a34
Grade: 1 bull(s). // Grades user guess
Turn 2:
> b354
Grade: 2 bull(s) and 1 cow(s).
Turn 3:
> 93b4
Grade: 4 bull(s).
Congratulations! You guessed the secret code. // End game
```

Inputs and exceptions are also handled.

## Contact

Thank you for checking my project out! Your interest is very much appreciated!

Please do not hesitate to contact me regarding any subjects! Mail me 
<a href="mailto:leventpolat408@gmail.com">here</a>!