/** Abgabeteam 3
  * Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
  * U22 Zahlen erraten*/
import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class ZahlenRaten {
    /** main methode */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Denken Sie sich eine Zahl zwischen 1 und 10 aus.");
        System.out.println("Ich werde versuchen, diese zu erraten.");
        newLine();
        
        int rand = 0;
        int count = 0;
        String input = "";
        
        while (!input.equals("j")) {
            rand = ask(random, 0, false);
            input = scanner.next().toLowerCase(); //ignores case sensitivity
            
            // if input not j or n
            while (!input.equals("j") && !input.equals("n")) {
                System.out.println("Bitte antworten Sie mit J oder N.");
                rand = ask(random, rand, true);
                input = scanner.next();
            }  
            
            count++;
        }
        
        newLine();
        System.out.println("Ich habe " + count + " Versuche gebraucht.");
        
    }
    
    /** * output for user and generate number
        * returns: int */
    public static int ask(Random random, int rand, boolean check) {
        // when user input not j/n dont generate new number
        if (!check) {
            rand = random.nextInt(10) + 1;
        }
        System.out.print("Ist es die " + rand + "? (J/N) ");
        return rand;
    }
    
    /** creates a new line */
    public static void newLine() {
        System.out.println();
    }
}
