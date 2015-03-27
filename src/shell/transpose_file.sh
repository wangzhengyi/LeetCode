#!/bin/bash

awk '
BEGIN {
 FS = " ";
}
{
    for(i = 1; i <= NF; i ++) {
        if (NR == 1) {
            info[i] = $i;
        } else {
            info[i] = info[i] " " $i
        }
    }
}
END {
    for (i = 1; info[i] != ""; i ++) {
        print info[i];
    }
} ' file.txt
