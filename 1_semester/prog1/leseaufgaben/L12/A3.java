import java.util.*;
public class A3 {
    public static void main(String[] args) {
        String[][] lab = new String[7][7];
        lab[0][0] = " S ";
        lab[0][6] = " Z ";
        lab[0][3] = " # ";
        lab[1][1] = " # ";
        lab[1][2] = " # ";
        lab[1][3] = " # ";
        lab[1][5] = " # ";
        lab[2][1] = " # ";
        lab[2][2] = " # ";
        lab[4][4] = " # ";
        lab[4][5] = " # ";
        lab[5][4] = " # ";
        lab[5][5] = " # ";
        lab[6][2] = " # ";
        for (int i = 0; i < lab.length; i++) {
            System.out.println("---------------------");
            for (int j = 0; j < lab.length; j++) {
                if (lab[i][j] != null) {
                    System.out.print(lab[i][j]);
                } else {
                    System.out.print("   ");
                }
                if (j % 6 == 0 && j != 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println(suche(0, 0, lab));
        for (int i = 0; i < lab.length; i++) {
            System.out.println("---------------------");
            for (int j = 0; j < lab.length; j++) {
                if (lab[i][j] != null) {
                    System.out.print(lab[i][j]);
                } else {
                    System.out.print("   ");
                }
                if (j % 6 == 0 && j != 0) {
                    System.out.println();
                }
            }
        }
    }
    public static String suche(int x, int y, String[][] lab) {
        if (y < 0 || y >= lab.length || x < 0 || x >= lab.length) return "Draußen";
        for (int i = 0; i < lab.length; i++) {
            System.out.println("---------------------");
            for (int j = 0; j < lab.length; j++) {
                if (lab[i][j] != null) {
                    System.out.print(lab[i][j]);
                } else {
                    System.out.print("   ");
                }
                if (j % 6 == 0 && j != 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        if (lab[x][y] == " Z ") return "Ziel";
        if (lab[x][y] == " # ") return "Wand";
        lab[x][y] = " . ";
        String weg = suche(x, y + 1, lab); // Rechts
        if (weg.endsWith("Ziel")) return "R " + weg;
        weg = suche(x + 1, y, lab); // Unten
        if (weg.endsWith("Ziel")) return "U " + weg;        
        lab[x][y] = "   ";
        return "Sackgasse";
    }
}