/** Abgabeteam 03
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U19 Quadratische Gleichung
*/
import java.util.Scanner;
public class Quadratic {
    /** Eingabeaufforderung und anschließend Methodenaufruf zur Lösung der
        quadratischen Gleichung falls a != 0 ist, sonst macht das Programm nichts
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie Parameter für die Gleichung ax² + bx + c = 0 ein: ");
        double a = ask(scanner);
        double b = ask(scanner);
        double c = ask(scanner);
        
        quadratic(a, b, c);
    }
    /** Nachbedingung: a != 0
    */
    public static double ask(Scanner scanner) {
        return scanner.nextDouble();
    }
    /**
        Berechnung Fallunterscheidung der Diskriminante und danach die Lösungsmenge
        bestimmen
    */
    public static void quadratic(double a, double b, double c) {
        double d = diskriminante(a, b, c);
        String plus = "+";
        String minus = "-";
        String none = "";   
        
        if (a == 0) {
            System.out.println("a muss ungleich 0 sein");
        // double Wert ungenau deshalb sicherstellen das der negarive Wert groß ist
        } else if (d < 0 && Math.abs(d) >= 0.0001) {
            System.out.println("Keine reelle Lösung");
        // dasseble um Rundungsfehler zu vermeiden statt nomarlerweise d == 0
        } else if (Math.abs(d) < 0.0001) { 
            double x1 = 0;
            if (0 <= d) {
                x1 = cal(a, b, c, plus, minus, plus);
            } else {
                x1 = cal(a, b, c, plus, minus, none);
            }
            System.out.println("Lösung: " + round1(x1));
        } else {
            double x1 = cal(a, b, c, plus, minus, plus);
            double x2 = cal(a, b, c, plus, minus, minus);
            print(x1, "Erste");
            print(x2, "Zweite");
        }
    }
    /** Lösungsmenge bestimmen mit der Mitternachtsformel (abc-Formel). Zunächst
        Abfrage von Paramter s zur Unterscheidung der beiden Lösungen
    */
    public static double cal(double a, double b, double c, String plus, String minus, String s) {
        if (s.equals(plus)) {
            return (-b + Math.sqrt(b*b-4*a*c))/(2*a);
        } else if (s.equals(minus)) {
            return (-b - Math.sqrt(b*b-4*a*c))/(2*a);
        } else {
            return -b/(2*a);
        }
    }
    /** einfacher print Befehl wobei die Lösung x gerundet wird
    */
    public static void print(double x, String s) {
        System.out.println(s + " Lösung = " + round1(x));
    }
    /** return die Diskriminante (der Wurzelausdruck in der Gleichung)
    */
    public static double diskriminante(double a, double b, double c) {
        return b*b-4*a*c;
    }
    /** Rundet eine gegebene Zahl auf eine Nachkommastelle. */
    public static double round1(double value) {
        if (Double.isNaN(value)) return value;
        if (Double.isInfinite(value)) return value;
        return Math.round(value * 10) / 10.0;
    }
}