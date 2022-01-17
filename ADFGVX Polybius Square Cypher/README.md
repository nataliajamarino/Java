# ADFGVX Polybius Square Cypher implementation by Natalia Souza Jamarino

From Project assignment:

The ADFGVX cypher was used by the German
Army in WW1 from March 1918 to encrypt field communications during the Ludendorff
Offensive (Kaiserschlacht). The cypher is so named because all messages are encrypted into
codes from the small alphabet of ADFGVX to reduce operator error when sending Morse Code
signals. Although an improvement on the ADFGX cypher used by the Germans up until 1918,
the new cypher was broken by the French cryptanalyst Georges Painvin and proved decisive in
repulsing the attack at Compiègne in June 1918.

## How to run Application

There's a Runner class and a Menu class, the Menu class shows to the user the options to encrypt and decrypt the phrases. To run first need to compile the Java classes, on terminal Run: 

```sh
cd src/ && javac -cp ".:../junit-4.10.jar" ie/gmit/dip/*.java
```

And then can start the application by running the Runner class:

```sh
java ie.gmit.dip.Runner
```

The application will show 3 options, 1 to encrypt, 2 to decrypt and 3 to quit.

## How to run tests

The application is using [Junit] to test, to run it's needed to include the jar file when execution the TestRunner class: 

```sh
java -cp ".:../junit-4.10.jar" ie.gmit.dip.TestRunner
```

That will return true if everything went ok.

## About the project

Cypher is the main class, that will encrypt / decrypt phrases.

Matrix class is where it holds the Matrix generated based on the cypher table and it's also used to convert the Matrix to a HashMap, making it easier to do columnar transposition.

Matrix Map class it's the class that holds the HashMap, it was created to use the Comparable interface and sort the Map keys accordingly.

MatrixGenerator it's the class that generates the encoding and the decoding matrix using the code passed and the cyphered text.

PolybiusSquare it's the class to that maps the character and the codes, and vice-versa for decoding, it's using a HashMap to be faster to search elements instead of a Matrix and for loops.

ColumnarTransposition it's the class that sort or unsort the crypt key inside the HashMap


[Junit]: (https://junit.org/junit4/)