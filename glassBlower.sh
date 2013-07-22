#!/bin/bash

# Function calls --
usage()
{
cat << EOF
usage: $0 options

This script compiles all java files from directories on the Directory List and puts them within a jar file. Afterwards, cleaning the directory of extra class files.

OPTIONS:
-h      Show this message
-d      Leave the directory dirty and dont clean class files
-v      Verbose
EOF
}

removeClassfiles()
{
    # Build the command
    locationString=$1
    ereaseCommand="rm $1*.class"

    #Run it
    $ereaseCommand
}

# Main Script --

##
# !DIRECTORY LIST!
# Fill this list with all
# necessary directories
# you want glass blower to
# build
#
# Directory names must be
# followed by a slash. 
##
dirList=(
    ''
    'DB/'
    'Interfaces/'
    'Utilities/'
)

# Create String variables
buildString='javac '
jarString='jar '

# Check if we want to run verbose
verbose=0

# We want to clean extra class files
dirty=0

# Get opts, and act accordingly  
while getopts "vdh" OPTION
do
    case $OPTION in
        v)
            verbose=1
            ;;
        d)
            dirty=1
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
for i in "${dirList[@]}"
do
    buildString="$buildString $i*.java"

if [[ verbose -eq 1 ]]; then
        echo "Added directory: $i to build string. "
    fi
done

# Collect class files and Jar them
jarString="$jarString cfe ThisSongSucks.jar ThisSongSucks ThisSongSucks.class "
for i in "${dirList[@]}"
do
    jarString="$jarString $i"

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

# If we're cleaning, clean the class files
if [[ dirty -eq 0 ]]; then
    if [[ verbose -eq 1 ]]; then
        echo "Cleaning class files."
    fi

    # Remove class files from each directory
    for i in "${dirList[@]}"
    do
        removeClassfiles "$i"

        if [[ verbose -eq 1 ]]; then
            echo "Removed class files in directory: $i. "
        fi
    done
fi

# Script complete
if [[ verbose -eq 1 ]]; then
    echo "Script complete. "
fi