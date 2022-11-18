echo Build
cd Strava_Server
call ant export
cd dist
move server.jar ../../Strava_Client/lib
cd ../../Strava_Client
call ant build
pause
