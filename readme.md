# CAESAR CIPHER
author Serhii Lahuta

# ENGLISH
### Run the program

#### Commands:

```
-e Encrypt
-d Decrypt
-bf Brute force
```

#### Arguments:
```
-k Key
-f File path
```

#### Example:
```
-e -k 1 -f "/path/to/file.txt"  - Encrypt file with key 1
-d -k 5 -f "/path/to/file [ENCRYPTED].txt" - Decrypt file with key 5
-bf -f "/path/to/file [ENCRYPTED].txt" - Brute force decrypt file
```

#### Argument could be in any order
```
-e -f "/path/to/file.txt" -k 1
```

# УКРАЇНСЬКА
### Запуск програми

#### Команди:

```
-e Зашифрувати
-d Розшифрувати
-bf Підбір коду
```

#### Аргуметни:
```
-k Ключ
-f Шлях до файлу
```

#### Приклад:
```
-e -k 1 -f "/path/to/file.txt"  - Зашифрувати файл з ключем 1
-d -k 5 -f "/path/to/file [ENCRYPTED].txt" - Розшифрувати файл з ключем 5
-bf -f "/path/to/file [ENCRYPTED].txt" - Розшифрувати файл методом підбору ключа
```

#### Аргументи можуть бути у будь-якому порядку
```
-e -f "/path/to/file.txt" -k 1
```