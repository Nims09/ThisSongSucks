#!/bin/bash

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

if [ $# = "-v" ]; then #FIX ME THIS NEEDS A PROPER CHECK 
    verbose=1
    echo "Verbose turned on. "
fi

# Build Directories
buildString="$buildString *.java"

for i in "${dirList[@]}"
do
    buildString="$buildString $i/*.java"

    if [ verbose = 1 ]; then
        echo "Added directory: $i to build string. "
    fi
done

# Collect class files and Jar them
jarString="$jarString cfe ThisSongSucks.jar ThisSongSucks ThisSongSucks.class "
jarString="$jarString *.class"

for i in "${dirList[@]}"
do
    jarString="$jarString $i/"

    if [ verbose = 1 ]; then
        echo "Added directory: $i to jar string. "
    fi
done

# Run the build command
if [ verbose = 1 ]; then
    echo "Running build command: "
    echo $buildString
fi
$buildString

# Run our jar command
if [ verbose = 1 ]; then
    echo "Running jar command: "
    echo $jarString
fi
$jarString

# Script complete
if [ verbose = 1 ]; then
    echo "Script complete. "
fi

