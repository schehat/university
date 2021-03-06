/** Abgabeteam 3
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U10 Referenztypen als Parameter
*/
import java.awt.Point;
public class Swap {
    public static void main(String[] args) {
        Point p1= new Point(5, 2);
        Point p2= new Point(-3, 6);
        swapPoints(p1, p2);
        System.out.println("p1: ("+p1.x+", "+p1.y+")");
        System.out.println("p2: ("+p2.x+", "+p2.y+")");
    }
    
    /** Methode vertauscht die Inhalte der Objekte die als Parameter 
        eingebenen wurden
        Parameter: sind Objekte der Klasse Point
    */
    public static void swapPoints(Point p1, Point p2) {
        int tmpX = p1.x;
        int tmpY = p1.y;
        p1.setLocation(p2.x, p2.y);
        p2.setLocation(tmpX, tmpY);
    }
}