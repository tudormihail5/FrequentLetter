# Letter that starts the most words

### What it does:

This is a basic Java application, that outputs the letter that starts the most words on a large text. 

### How I built it:

- The program first opens a connection to the specific URL and retrieves the content as an input stream.
- The findLetter method is called with the buffered input stream as an argument. Inside it, it initialises an array called 'letters' with 26 zeros. This array is meant to count the occurences of each letter of the English alphabet in the text.
- It then reads the content of the file line by line using a BufferedReader. For each line, it converts the line to lowercase, it checks if the line is not empty and if the first character is a lowercase letter; if these conditions are met, it increments the corresponding element in the letters array based on the character's ASCII value. It iterates through the characters in the line and checks if a punctuation character is followed by a lowercase letter. If it is the case, it increments the value in letters in the same manner.
- After processing all the lines, it determines which letter occured the most in the text by finding the element with the maximum value in the letters array, printing it.

### Challenges I ran into:

Initially, I thought words can only be preceded by space, but after carefully reading the specification, I realised I was wrong. So words could only be preceded by space, '"', ''', '_', '(', '<', '{', and '['. Brackets and quotes were a bit confusing, because I was first thinking only at '(' and '''.
