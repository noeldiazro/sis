#!/bin/sh
javac -classpath junit-3.8.2.jar -Xlint:deprecation -d classes studentinfo/*.java
if [ $? -eq 0 ]; then
    java -cp classes:junit-3.8.2.jar junit.textui.TestRunner studentinfo.AllTests
fi
