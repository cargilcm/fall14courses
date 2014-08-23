Chris Cargile
CSIS659-SOA
Term:Fall 2014
Project: SOC One

OBJECTIVE: 
- Accept input from the command-line specifying any two zones representing a departure and arrival
destination spanning 0 or more zones to formulate the cost of a Delta flight to be displayed as 
command output.

PROJECT STRUCTURE:
This submission contains the required .java files needed to run the program along with cost/zone
.txt files as transcribed from the image embedded in the .pdf assignment file.

BUILD PROCESS
Using JDK environment only:  
- javac src/java/main/Main.java ;  java src/java/main/Main

Using Maven 3.1.1:	
- mvn install test ;  java -cp target/classes Main