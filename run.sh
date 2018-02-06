#!/bin/sh
javac -classpath junit-3.8.2.jar -Xlint:deprecation -d classes source/sis/studentinfo/*.java source/sis/report/*.java source/sis/AllTests.java

if [ $? -eq 0 ]; then
    java -cp classes:junit-3.8.2.jar junit.textui.TestRunner sis.AllTests
fi
