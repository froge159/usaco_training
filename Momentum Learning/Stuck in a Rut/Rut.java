import java.util.*;
import java.io.*;

public class Rut {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        pw.close();
    }
}
/*
Boolean 10001 array holding grass true/false
Integer 10001 arraylist holding all cows index in specs
2d arraylist holding all cows specs
2d array holding ha scow stopped moving
Array holding each count


For I in range 10000
	If stopped = true, continue;
	
	Make changes (make sure to update main grid and specs)
	If it moved onto an empty cell, stopped = true
	If there already is a cow on the position a cow is trying to move:
		Add to that subarray
	Count++
	
	For every cow:
		Make their corresponding cells empty
		

Looping through specs:
	If stopped = true, print out ending count
Else, print infinity*/
