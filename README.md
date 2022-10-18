compile the project with the following code to get all the dependencies in your Jar:
```
mvn clean compile assembly:single
```
how to launch it?
 
with gui 
```
java -jar swingy.jar gui
```
with console
```
java -jar swingy.jar console
```
to use hibernate and database instead of file to get previous heroes add db
example :
```
java -jar swingy.jar gui db
```
