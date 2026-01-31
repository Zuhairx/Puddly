@echo off
echo Compiling Java files...
javac -d bin -cp "lib/mysql-connector-j-9.5.0.jar" src/Puddly/*.java src/Puddly/controller/*.java src/Puddly/model/*.java src/Puddly/view/*.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b 1
)
echo Compilation successful.
echo Running the application...
java -cp "bin;lib/mysql-connector-j-9.5.0.jar" Puddly.launch
pause
