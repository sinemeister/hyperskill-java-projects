# Bulls and Cows

Welcome to the Bulls and Cows project! This is a Java project which is one of the projects in the Hyperskill's
<a href="https://hyperskill.org/tracks/8"><i>Introduction to Java</i></a> track. Find the details of the project 
<a href="https://hyperskill.org/projects/53?track=8">here</a>.

## About

Bulls and Cows is a classic code-breaking game where players attempt to guess a secret code based on feedback provided 
after each guess. This Java project allows you to experience the excitement of cracking the code and mastering the strategy 
behind it.

## Implementation and Features

Bulls and Cows is a two-player game, but in this implementation, you'll be challenged by the computer to crack its secret code
that it generated for you to break!

The game proceeds as follows:

1. You set the length of the secret code and the number of possible symbols in the code.
2. The computer prepares a secret code using the specified length and symbols.
3. You attempt to guess the secret code, and after each guess, you receive feedback in the form of "bulls" and "cows."
    - A "bull" indicates a correct digit in the correct position.
    - A "cow" indicates a correct digit in the wrong position.
4. Your goal is to ultimately guess the secret code!

The computer will help you along the way with the features as follows:

- Dynamic customization of code length and symbol range.
- Real-time feedback on each guess.
- Interactive gameplay that emulates the classic Bulls and Cows experience.

Let's walk through an example gameplay session:

```
Input the length of the secret code:

4
Input the number of possible symbols in the code:
12
The secret is prepared: **** (0-9, a-b).
Okay, let's start a game!
Turn 1:
a234
Grade: 1 bull(s) and 1 cow(s).
Turn 2:
73b4
Grade: 2 bull(s) and 1 cow(s).
Turn 3:
9374
Grade: 4 bull(s).
Congratulations! You guessed the secret code.
```

## Getting Started

1. Clone this repository to your local machine.
2. Compile the Java source files using a Java compiler.
3. Run the compiled program to start playing the Bulls and Cows game.

Feel free to modify the game settings, tweak the code, and experiment with different strategies to improve
your code-breaking skills.

Enjoy the challenge of cracking the code and outsmarting the computer in this implementation of the Bulls and Cows game!

Let the guessing begin!

## Contact

Many thanks for checking my project out! Feel free to contact me related any subject. You can mail me
<a href="mailto:leventpolat408@gmail.com">here</a>.
