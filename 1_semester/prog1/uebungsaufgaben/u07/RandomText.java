/**Abgabeteam 03
  * Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
  * U20 Random */
import java.util.Random;
public class RandomText {
    /** main Methode */
    public static void main(String[] args) {
        Random random = new Random();
        int row = random.nextInt(4) + 5;
        String vocals = "aeiou";
        for (int i = 0; i < row; i++) {
            int chars = random.nextInt(3) + 4;
            for (int j = 0; j < chars; j++) {
                char vocal = vocals.charAt(random.nextInt(vocals.length()));
                System.out.print(vocal);
            }
            System.out.println();
        }
    }
}