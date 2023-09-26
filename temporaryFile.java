import java.util.Scanner;

class Main {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String name = in.nextLine();
      String f = name.substring(0, name.indexOf(" "));
      String l = name.substring(name.indexOf(" ") + 1);
      System.out.println("Hello, " + f.substring(1, 2).toUpperCase() + f.substring(2) + f.substring(0, 1).toLowerCase() + "ay" + " " + l.substring(1, 2).toUpperCase() + l.substring(2) + l.substring(0, 1).toLowerCase() + "ay";);
   }
}
