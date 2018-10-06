#!/bin/bash

echo Starting the build...
mvn clean install
mv target/springview-1.0.jar ./
echo Build has ended!
echo Stopping the currently running Java application...
pkill java
echo Starting the newest version of application...
nohup java -jar springview-1.0.jar &
