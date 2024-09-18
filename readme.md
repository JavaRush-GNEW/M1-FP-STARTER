
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
-fa File path for frequency analysis (only used in brute force mode).
```

### Example:
```
-e -k 1 -f "/path/to/file.txt"  - Encrypt file with key 1
-d -k 5 -f "/path/to/file [ENCRYPTED].txt" - Decrypt file with key 5
-bf -f "/path/to/file [ENCRYPTED].txt" - Brute force decrypt file
-bf -f "/path/to/file[ENCRYPTED].txt" -fa "/path/to/reference.txt"
```

### Argument could be in any order
```
-e -f "/path/to/file.txt" -k 1 (Чомусь коли я видаляв класи вони не видалялись на GitHab, довелось чистити кеш Git та відновляти інформацію з останнього коміту, поідеї такої проблеми вже не має бути)
```
