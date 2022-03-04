import java.util.ArrayList;

public interface IOManager<T> {
    void writeFile(ArrayList<T> element);
    ArrayList<T> readFile();
}
