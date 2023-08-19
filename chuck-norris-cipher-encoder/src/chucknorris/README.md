# Chuck Norris Cipher Encoder

## About

This program can encrypt a given text as Chuck Norris Unary (CNU) code, or can decrypt a given CNU code back to literal
String depending on the user choice. It can also handle user input.

A CNU can be described as a unary code, with 0's only, indicating how many 0's and 1's in a binary code there are.

- ```00``` being ```binary 0``` and ```0``` being ```binary 1``` indicates the beginning of a block.
- Trailing 0's before the other ````0```` or ```00``` show how many 0's or 1's there are in that block.
- ```0 0 00 0000 0 00``` represents ```1000011``` in binary which represents ```char 'C'``` in ASCII.

## Implementation

You may find the example below useful to understand how the program works:

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

## Contact

Thank you for checking my project out! Your interest is very much appreciated!

Please do not hesitate to contact me regarding any subjects! Mail me <a href="leventpolat408@gmail.com">here</a>!