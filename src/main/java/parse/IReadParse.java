import java.io.FileNotFoundException;
import java.util.Scanner;

public interface IReadParse {
    void read(String path) throws FileNotFoundException;
    void parseFields(String path) throws FileNotFoundException;
    void parseValues(String path) throws FileNotFoundException;
}