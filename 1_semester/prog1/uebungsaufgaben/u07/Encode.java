/** Abgabeteam 3
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
*/
import java.util.Scanner;
public class Encode {
    /** Steuerung der Methoden
    */
    public static void main(String[] args) {
        String word = "Hallo";
        String word1 = encode(word);
        String word2 = decode(word1);
        print(word, word1, word2);
    }
    
    /** inkrementiert die einzelnen chars eines Strings
        Vorbedingung: para is type String
        Es werden 2 substrings vom Anfang bis zum char (ausschließend) und vom 
        vom char (ausschließend) bis zum Ende erzeugt und konkateniert. Jedoch 
        wird an der Stelle vom char zwischen den beiden substring der char Wert
        um 1 addiert und ersetzt den ursprüglichen char
    */
    public static String encode(String word) {
        for (int i = 0; i < word.length(); i++) {
            word = word.substring(0, i) + (char) (word.charAt(i)+1) + word.substring(i + 1, word.length());
        }
        return word;
    }
    
    /** dekrementiert die einzelnen chars eines Strings
        Vorbedingung: para ist String Typ
    */
    public static String decode(String word) {
        for (int i = 0; i < word.length(); i++) {
            word = word.substring(0, i) + (char) (word.charAt(i)-1) + word.substring(i + 1, word.length());
        }
        return word;
    }
    
    /** Ausgabebefehl
        Vorbedingung: 3 Parameter Typ String
        word = ursprüglicher Begriff
        word1 = encode
        word2 = decode
    */
    public static void print(String word, String word1, String word2) {
        line(word, word1);
        line(word, word2);
    }
    
    /** Ausgabe auf der Konsole
    */
    public static void line(String word, String w) {
        System.out.println("encode(\"" + word + "\")gibt zurück: " + w);

    }
}