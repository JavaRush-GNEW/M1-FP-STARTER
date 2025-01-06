### Notes:
- This Cypher can ENCRYPT or DECRYPT your sentences. 
- You can found correct texts or sentences by using this program.
- You can decrypt or encrypt text by using CESAR CYPHER.
- Support for UKRAINIAN and ENGLISH languages in encryption, decryption, and also in brute force

### Last Upgrades:
- We have an automatic program that can obtain decrypted text without a key.
- The program now takes into account spaces in the specified parameters.
- Some bug fixed.

### Brute force
- Сan automatically decrypt any text (Caesar cipher) and find the correct key.

### Commands:

- -e Encrypt
- -d Decrypt
- -bf Brute force

### Arguments:

- You need to write the arguments in the order: encrypt/decrypt/bruteforce(e,d,bf) + key(1 or -1 and further in decreasing, increasing order) + file path.
  In the case of bruteforce, a key is not needed.

### Example:

- -e -k 1 -f "/path/to/file.txt" - Encrypt file with key 1
- -d -k 5 -f "/path/to/file [ENCRYPTED].txt" - Decrypt file with key 5
- -bf -f "/path/to/file [ENCRYPTED].txt" - Brute force decrypt file

