# Caesar Cipher Encryptor/Decryptor

### What was implemented?
```
All main tasks from the technical requirements were completed. 
The `Encrypt` and `Decrypt` methods function correctly.
```
### What was not implemented?
```
The program does not support command-line interaction via scanner (CLI). 
Instead, a graphical user interface (GUI) was implemented.
```
### Project Features
```
- **Multilingual Support**: The program supports encryption and decryption of text in English and Ukrainian. 
It automatically detects the language of the text and selects the appropriate alphabet.

- Brute-force Implementation: A brute-force mode is available for decrypting encrypted text.

- Graphical User Interface (GUI): A user-friendly GUI was implemented 
for easier interaction with the program.
```

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