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

# Build Directories
buildString="$buildString *.java"

for i in "${dirList[@]}"
do
    buildString="$buildString $i/*.java"
    echo $buildString
done

# Run the build command
$buildString

