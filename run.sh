#!/bin/sh
javac -classpath junit-3.8.2.jar -Xlint:deprecation studentinfo/*.java
if [ $? -eq 0 ]; then
    java -cp .:junit-3.8.2.jar junit.textui.TestRunner studentinfo.AllTests
fi
