/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U27 Vergleichen zweier Arrays*/
public class VergleichArrays {
    /** call kleinerGleich method*/
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 3, 4, 4};
        int[] b = {1, 2, 3, 4, 5, 4};  
        System.out.println(kleinerGleich(a, b));   
    }
    
    /** *Parameter: 2 int-arrays
        *return: boolean */
    public static boolean kleinerGleich(int[] a, int[] b) {
        if (a.length <= b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] > b[i]) {
                    return false;
                }
            }
            return true;
        }
        
        boolean check = false;
        // a.length > b.length
        if (b.length >= 1) {
            for (int i = 0; i < b.length; i++) {
                if (a[i] <= b[i]) {
                    if (a[i] < b[i]) {
                        // it means 1 value is atleast a < b and fulfills condition
                        check = true;
                    }
                } else {
                    // if this happens atleat once => a <= b not true
                    return false;
                }
            }
            return check;
        }
        
        if (a.length == 0) {
            return true;
        }
        
        if (a.length >= 1 && b.length == 0) {
            return false;
        }
        // not there compile error
        return false;
    }
}