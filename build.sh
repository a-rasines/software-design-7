#!/usr/bin/sh

echo Build
cd Google_Server
mkdir lib
ant export
cd dist
mv Gserver.jar ../../Strava_Server/lib
cd ../../Strava_Server
ant export
cd dist
mv server.jar ../../Strava_Client/lib
cd ../../Strava_Client
ant build
cd ../Facebook_Server
mkdir lib
ant build
cd ..
