CS442 Design Patterns
Spring 2015
PROJECT 2 README FILE

Due Date: Sunday, March 15, 2015
Submission Date: Sunday, March 15, 2015
Grace Period Used This Project: 0 Days
Grace Period Remaining: 2 Days
Author(s): Lucas Eager Leavitt
e-mail(s): leagerl1@binghamton.edu


PURPOSE:

[
  Create and Multithreaded client server pair that takes input from the client (name and num),
  stores it and processes whether or not this number is prime and prints that response to the
  client
]

PERCENT COMPLETE:

[
  I believe I have completed 100% of the project.
]

PARTS THAT ARE NOT COMPLETE:

[
  N/A
]

BUGS:

[
  N/A
]

FILES:

[
  Included with this project are 12 files:

  Debug.java, the file which provides debugging functionality for the program
  ClientDriver.java, calls the Client and displays its menu
  ClientMenu.java, prints the client menu options
  ServerDriver.java, calls the Server and its menu
  ServerMenu.java, prints the server menu options
  PrimeServerSocket.java, establishes the server socket connection in new thread
  PrimeServerWorker.java, process all input output from socket in new thread
  PrimeClientSocket.java, establishes the client socket connection in new thread
  CheckPrime.java, helper class that determines if given int is prime
  PrimeDriver.java, the main class containing the main method for running the program
  build.xml, file that tells ant how to compile and run the project
  README, the text file you are presently reading
]

SAMPLE OUTPUT:

[

  java] Please enter an option:
     [java] 1) Client Name
     [java] 2) All Clients
     [java] 3) Quit
     [java] 
1
     [java] Please enter a client name
John
     [java] John 123
     [java] Please enter an option:
     [java] 1) Client Name
     [java] 2) All Clients
     [java] 3) Quit
     [java] 

TO COMPILE:

[
  Just extract the files and then do ant -buildfile src/build.xml all
]

TO RUN:

[
  To run server:  ant -buildfile build.xml -Darg0=Server -Darg1=<portNum> -Darg2=<debugVal> run 
  To run client: ant -buildfile build.xml -Darg0=Client -Darg1=<hostname> -Darg2=<portNum> -Darg3=<debugVal> run 
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Lucas Eager Leavitt

[
   * http://docs.oracle.com/javase/tutorial/networking/sockets/index.html
   * http://javarevisited.blogspot.com/2014/05/double-checked-locking-on-singleton-in-java.html
]

ACKNOWLEDGEMENT:

[
  N/A

]
