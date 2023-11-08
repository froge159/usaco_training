/*
create array containing subarray[input, output]

iterating through all input/outputs:
       iterate through every possible conditional value:
             iterate through previous i/o
                   if does not satisfy, try new conditional value
             if satisfies all previous i/o, continue
        if iterated through every possible value, print LIE

        
find new conditional value:
    for every index:
         if val == x return y
*/
