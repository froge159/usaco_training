import java.io.*;
import java.util.*;
import java.net.Inet4Address;

public class Test{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("tttt.out"));
        int team = 0;
        int single = 0;
        HashSet<Character> singleCows = new HashSet<Character>();
        HashSet<String> teamCows = new HashSet<String>();
        // rows
        char[][] row = new char[3][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        String row1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String row2 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String row3 = st.nextToken();

        for (int i = 0; i < 3; i++) {
         row[0][i] = row1.charAt(i);
         row[1][i] = row2.charAt(i);
         row[2][i] = row3.charAt(i);
        }
        int rowOneCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (row[0][i] == row[0][j]) {
                    rowOneCounter++;
                }
            }
        }
        if (rowOneCounter == 1) {
            char[] chars = row[0];
            Set<Character> charSet = new HashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : charSet) {
                sb.append(c);
            }
            String output = sb.toString();

            char[] a = output.toCharArray();
            Arrays.sort(a);
            String sortedStrRow0 = new String(a);
            teamCows.add(sortedStrRow0);

        }
        else if (rowOneCounter == 3) {
            singleCows.add(row[0][0]);
        }
        int rowTwoCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (row[1][i] == row[1][j]) {
                    rowTwoCounter++;
                }
            }
        }
        if (rowTwoCounter == 1) {
            char[] chars = row[1];
            Set<Character> charSet = new HashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : charSet) {
                sb.append(c);
            }
            String output = sb.toString();

            char[] a = output.toCharArray();
            Arrays.sort(a);
            String sortedStrRow1 = new String(a);
            teamCows.add(sortedStrRow1);
        }
        else if (rowTwoCounter == 3) {
            singleCows.add(row[1][0]);
        }
        int rowThreeCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (row[2][i] == row[2][j]) {
                    rowThreeCounter++;
                }
            }
        }
        if (rowThreeCounter == 1) {
            char[] chars = row[2];
            Set<Character> charSet = new HashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : charSet) {
                sb.append(c);
            }
            String output = sb.toString();

            char[] a = output.toCharArray();
            Arrays.sort(a);
            String sortedStrRow2 = new String(a);
            teamCows.add(sortedStrRow2);
        }
        else if (rowThreeCounter == 3) {
            singleCows.add(row[2][0]);
        }
         
        // columns
        char[][] columns = new char[3][3];
        for (int i = 0; i < 3; i++) {
            columns[0][i] = row[i][0];
            columns[1][i] = row[i][1];
            columns[2][i] = row[i][2];
        }
        
        int colOneCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (columns[0][i] == columns[0][j]) {
                    colOneCounter++;
                }
            }
        }
        if (colOneCounter == 1) {
            char[] chars = columns[0];
            Set<Character> charSet = new HashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : charSet) {
                sb.append(c);
            }
            String output = sb.toString();

            char[] a = output.toCharArray();
            Arrays.sort(a);
            String sortedColRow0 = new String(a);
            teamCows.add(sortedColRow0);
        }
        else if (colOneCounter == 3) {
            singleCows.add(columns[0][0]);
        }
        int colTwoCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (columns[1][i] == columns[1][j]) {
                    colTwoCounter++;
                }
            }
        }
        if (colTwoCounter == 1) {
            char[] chars = columns[1];
            Set<Character> charSet = new HashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : charSet) {
                sb.append(c);
            }
            String output = sb.toString();

            char[] a = output.toCharArray();
            Arrays.sort(a);
            String sortedColRow1 = new String(a);
            teamCows.add(sortedColRow1);
        }
        else if (colTwoCounter == 3) {
            singleCows.add(columns[1][0]);
        }
        int colThreeCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (columns[2][i] == columns[2][j]) {
                    colThreeCounter++;
                }
            }
        }
        if (colThreeCounter == 1) {
            char[] chars = columns[2];
            Set<Character> charSet = new HashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : charSet) {
                sb.append(c);
            }
            String output = sb.toString();

            char[] a = output.toCharArray();
            Arrays.sort(a);
            String sortedColRow2 = new String(a);
            teamCows.add(sortedColRow2);
        }
        else if (colThreeCounter == 3) {
            singleCows.add(columns[2][0]);
        }
          //diagonals
        char[][] diagonal = new char[2][3];
        for (int i = 0; i < 3; i++) {
            diagonal[0][i] = row[i][i];
        }
        diagonal[1][0] = row[0][2];
        diagonal[1][1] = row[1][1];
        diagonal[1][2] = row[2][0];
        
        int crossOneCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (diagonal[0][i] == diagonal[0][j]) {
                    crossOneCounter++;
                }
            }
        }
        if (crossOneCounter == 1) {
            char[] chars = diagonal[0];
            Set<Character> charSet = new HashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : charSet) {
                sb.append(c);
            }
            String output = sb.toString();

            char[] a = output.toCharArray();
            Arrays.sort(a);
            String sortedCross0 = new String(a);
            teamCows.add(sortedCross0);
        }
        else if (crossOneCounter == 3) {
            singleCows.add(columns[0][0]);
        }
        int crossTwoCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (diagonal[1][i] == diagonal[1][j]) {
                    crossTwoCounter++;
                }
            }
        }
        if (crossTwoCounter == 1) {
            char[] chars = diagonal[1];
            Set<Character> charSet = new HashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : charSet) {
                sb.append(c);
            }
            String output = sb.toString();

            char[] a = output.toCharArray();
            Arrays.sort(a);
            String sortedCross1 = new String(a);
            teamCows.add(sortedCross1);
        }
        else if (crossTwoCounter == 3) {
            singleCows.add(columns[1][0]);
        }

        pw.println(singleCows.size());
        pw.println(teamCows.size());
        pw.close();
        
    
    }
}
