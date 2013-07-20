#!/bin/bash

# Function calls --
usage()
{
cat << EOF
usage: $0 options

This script run the test1 or test2 over a machine.

OPTIONS:
-h      Show this message
-v      Verbose
EOF
}

# Main Script --

##
# !DIRECTORY LIST!
# Fill this list with all
# necessary directories
# you want glass blower to
# build
##
dirList=(
    'DB'
    'Interfaces'
    'Utilities'
)

# Create String variables
buildString='javac '
jarString='jar '

# Check if we want to run verbose
verbose=0

while getopts "v:h" OPTION
do
    case $OPTION in
        v)
            verbose=1
            ;;
        h)
            usage
            ;;
        ?)
            # It's reasonable to run the script without ops so do nothing
            ;;
    esac
done

# Build Directories
buildString="$buildString *.java"

for i in "${dirList[@]}"
do
    buildString="$buildString $i/*.java"

if [[ verbose -eq 1 ]]; then
        echo "Added directory: $i to build string. "
    fi
done

# Collect class files and Jar them
jarString="$jarString cfe ThisSongSucks.jar ThisSongSucks ThisSongSucks.class "
jarString="$jarString *.class"

for i in "${dirList[@]}"
do
    jarString="$jarString $i/"

    if [[ verbose -eq 1 ]]; then
        echo "Added directory: $i to jar string. "
    fi
done

# Run the build command
if [[ verbose -eq 1 ]]; then
    echo "Running build command: "
    echo $buildString
fi
$buildString

# Run our jar command
if [[ verbose -eq 1 ]]; then
    echo "Running jar command: "
    echo $jarString
fi
$jarString

# Script complete
if [[ verbose -eq 1 ]]; then
    echo "Script complete. "
fi

## MAKE IT CLEAN UP CLASS FILES AFTER SINCE YOU JUST NEED TO RUN A JAR, GIVE IT AN OpTION TO NOT DO THIS