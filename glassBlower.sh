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

finalJarCall = ''
# Build Current Directory
javac *.java

# Build all other Directories and create the final jar string
for ((i = 0; i < 2; i++))
do
    echo "${FILES[$i]}"
done


