=============================================================
Connect4
=============================================================

##Summary 
This repository contains a re-written implementation of the Connect4 game, as required for the Software Development course. Connect4 is a two player game. Players take turns inserting a token into one of seven columns on a 6 row board. The first player to have four tokens in a row (horizontally, vertically or diagonally) wins. 
This implementation is a one-player game, with a computer simulated opponent. 

##Compilation

To run a clean installation of everything:

```
  $ ant
```

This will compile the application, create executable (jar), run tests and produce Javadoc documentation.

Test results can then be found in:

```
  $ cd build/test-html/
```

Javadoc documentation can be found in: 

```
  $ cd build/doc
```

Jars can be found in: 
```
  $ cd jar/
```

##Execution

To run Connect4, first compile the code as described above and then simply use the command: 

```
  $java -jar lib/Connect4.jar
```


##Enjoy!
