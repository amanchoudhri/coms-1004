----------
Aman Choudhri
ac4972
ReadMe.txt
----------

Hello! My code for this assignment was very simple. First, I check to make sure
that the user correctly entered two arguments. If not, the program prints out an
error and exits. After this check, the program tries to load in the input file.
If a FileNotFoundException is caught, it exits. Before we start the bulk of the
program, I also check to make sure that the output file is valid (this way, we
don't run the entire program only to discover later that the output file can't
be written to). 

Then, the bulk of the program begins. The program moves line by line through the
file, at each line checking whether the entry contains the string "Invalid". If
so, the program splits the string on spaces and stores the last token (since
that's where the IP address is found in each log message). Then it updates a
hashmap storing the number of times a given invalid IP address tried to login.
Finally, the program outputs each IP address which occurred in the input file
more than three times to the output file.
