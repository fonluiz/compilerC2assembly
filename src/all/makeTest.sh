rm *.java
rm *.class
jflex lexical_simpler.flex
java -jar ../../lib/java-cup-11b.jar -locations -interface -parser Parser -xmlactions NewParser.cup
javac -cp ../../lib/java-cup-11b-runtime.jar:. *.java
java -cp ../../lib/java-cup-11b-runtime.jar:. Parser input.c simple.xml
java -cp ../../lib/java-cup-11b-runtime.jar:. Parser wrong_input.c wrong_input.xml