
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

### Argument could be in any order
```
-e -f "/path/to/file.txt" -k 1
```

## About the project

### Implemented
- Program compiled in jar format and released on GitHub.
- Program can be run from the console by passing arguments.
- Program implements three options: [ENCRYPT, DECRYPT, BRUTE_FORCE].
- Program implements only one option at a time.
- Program writes the result into a new file, which name contains a label according to command used.
- Program can be used English language only.
- Only letters of the latin alphabet are encrypted.
- After decryption, the text *mostly* has the same formatting as the original file (spaces, indents, symbols, upper and lower case letters).

### Not implemented
- Program does not work for Ukrainian or any other languages.
- Program does not encode any symbols except latin letters.
- Program does not have UI.
- 2 tests failed: After decryption, the line separators are different from the originals.
- Code simplicity: Cypher.calculateKey() method has over 20 lines. 
### Extra
After hours of troubleshooting, I have not found a way to correctly convey the line separators into the output file.
The issue is most likely in the FileManager.write() method. Any feedback appreciated. :)
