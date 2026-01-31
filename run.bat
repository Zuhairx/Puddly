@echo off
echo Compiling Java files...
for /r src %%f in (*.java) do javac -d bin -cp "lib/mysql-connector-j-9.5.0.jar" %%f
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b 1
)
echo Compilation successful.
echo Running the application...
java -cp "bin;lib/mysql-connector-j-9.5.0.jar" PTPudding.launch
pause
