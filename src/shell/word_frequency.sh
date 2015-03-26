#!/bin/bash

awk 'BEGIN {FS = " "} \
    { \
        for(i = 1; i <= NF; i ++) { \
        dict[$i] ++
        } \
    } \
    END { \
        for (i in dict) { \
            print i, dict[i]
        } \
    }' words.txt | sort -k 2 -nr

