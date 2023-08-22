# Chuck Norris Cipher Encoder

Welcome to the Chuck Norris Cipher Encoder project! This is a Java project which is one of the projects in the Hyperskill's
<a href="https://hyperskill.org/tracks/8"><i>Introduction to Java</i></a> track. Find the details of the project
<a href="https://hyperskill.org/projects/293?track=8">here</a>.

## About

Secret agents often use various encryption methods to protect sensitive information. The Chuck Norris cipher is a 
unique encryption technique that employs a single character and spaces to encode and decode messages. 
While it might sound simple, this cipher presents a fun and interesting challenge for programmers.

This program can encrypt a given text as Chuck Norris Unary (CNU) code, or can decrypt a given CNU code back to literal
String depending on the user choice. It can also handle user input.

A CNU can be described as a unary code, with 0's only, indicating how many 0's and 1's in a binary code there are.

- ```00``` being ```binary 0``` and ```0``` being ```binary 1``` indicates the beginning of a block.
- Trailing 0's before the other ````0```` or ```00``` show how many 0's or 1's there are in that block.
- ```0 0 00 0000 0 00``` represents ```1000011``` in binary which represents ```char 'C'``` in ASCII.

## Implementation and Features

The program will guide you through your encryption and decryption along the way with the below features:

- Encryption of text into a sequence of zeros and spaces using the Chuck Norris cipher.
- Decryption of encoded sequences back into the original text.
- Interactive user interface that guides you through the encryption and decryption process.

Before exploring the world of encryption in a creative and entertaining way with the Chuck Norris cipher, you
may find the below example helpful for you to image what this program looks like:

```
Please input operation (encode/decode/exit):
> encode
Input string:
> Hey!
Encoded string:
0 0 00 00 0 0 00 000 0 00 00 00 0 0 00 0 0 00000 00 00 0 0 00 0 0 0 00 0000 0 0

Please input operation (encode/decode/exit):
> decode
Input encoded string:
> 0 0 00 00 0 0 00 000 0 00 00 00 0 0 00 0 0 00000 00 00 0 0 00 0 0 0 00 0000 0 0
Decoded string:
Hey!

Please input operation (encode/decode/exit):
> exit
Bye!
```

## Getting Started

1. Clone this repository to your local machine.
2. Compile the Java source files using a Java compiler.
3. Run the compiled program to start interacting with the Chuck Norris cipher.

Feel free to experiment with different input strings, encode and decode operations, 
and explore the intricacies of the Chuck Norris cipher.

## Contact

Thank you for checking my project out! Your interest is very much appreciated!

Please do not hesitate to contact me regarding any subjects! Mail me <a href="leventpolat408@gmail.com">here</a>.

Happy ciphering!