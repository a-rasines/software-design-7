echo Build
cd Google_Server
call ant export
cd dist
move Gserver.jar ../../Strava_Server/lib
cd ../../Strava_Server
call ant export
cd dist
move server.jar ../../Strava_Client/lib
cd ../../Strava_Client
call ant build
pause
