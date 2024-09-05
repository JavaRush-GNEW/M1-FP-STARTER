
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
-d -k 5 -f "/path/to/file[ENCRYPTED].txt" - Decrypt file with key 5
-bf -f "/path/to/file[ENCRYPTED].txt" - Brute force decrypt file
```

### Argument could be in any order
```
-e -f "/path/to/file.txt" -k 1
```

## Summary
### What was done ?
```
All basic requirements were implemented:
- Encryption
- Decryption
- Brute force algorithm
```

 Additional features that were implemented:
```
- Ukrainian language added
- Auto detecting language method
```
### What hasn't been done from the basic requirements?
```
All basic features have been implemented
```
### Features of the project
```
The features of the project are the use of large English and Ukrainian dictionaries 
to form a dataset for brute force encoding of the file. This solution provides better acurracy 
for the brute force operation. 
Also language auto-detection was implemented.This makes it possible to use many languages in the
program and to add new languages without changing the client code.
```

### What the mentor should pay attention to during the inspection?
```
 - BruteForce.java
 - Alphabet.java
 - CryptoOperationHandler.java
```