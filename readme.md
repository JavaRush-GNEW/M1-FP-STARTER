
## Run the program

### Commands:

```
-e Encrypt
-d Decrypt
-bf Brute force
```

### Arguments:
```
-k Key
-f File path
```

### Example:
```
-e -k 1 -f "/path/to/file.txt"  - Encrypt file with key 1
-d -k 5 -f "/path/to/file [ENCRYPTED].txt" - Decrypt file with key 5
-bf -f "/path/to/file [ENCRYPTED].txt" - Brute force decrypt file
```

### Arguments could be in any order
```
-e -f "/path/to/file.txt" -k 1
```

## About the project

### Implemented tasks
All mandatory tasks are completed.
- Program compiled in jar format and released on GitHub.
- Program can be run from the console by passing arguments.
- Program implements three options: [ENCRYPT, DECRYPT, BRUTE_FORCE].
- Program implements only one option at a time.
- If you use Encrypt or Decrypt command, key value is mandatory.
- Program writes the result into a new file, which name contains
a label according to command used: [ENCRYPTED], [DECRYPTED],
[BRUTE_FORCE]. In case of using Bruteforce, the calculated key value
is appended to the file name as well.
- Program can be used English language only.
- Only letters of latin alphabet are encrypted.
- After decryption, the text has exactly the same formatting as the original file
- (spaces, indents, line separators, symbols, upper and lower case letters).

### Not implemented tasks
- Program does not work for Ukrainian or any other languages.
- Program does not encode any special or blank symbols (latin letters only).
- Program does not work with CLI.
- Program does not have UI.
