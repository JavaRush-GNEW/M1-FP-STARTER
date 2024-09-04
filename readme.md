Commands:

e Encrypt
d Decrypt
bf Brute force
Arguments:

k Key
f File path

Example:

e 1 f "/path/to/file.txt"  - Encrypt file with key 1
d 5 f "/path/to/file [ENCRYPTED].txt" - Decrypt file with key 5
bf f "/path/to/file [ENCRYPTED].txt" - Brute force decrypt file

Argument could be in any order

e "/path/to/file.txt" 1
