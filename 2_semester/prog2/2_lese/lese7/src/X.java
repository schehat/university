import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class X implements Serializable { 
    private int x1; 
    public X(int x) { x1= x; }
    public String toString() {
        return "hier " + x1;
    }
}

