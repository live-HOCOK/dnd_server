package parse;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface IReadParse {
    String[] read(String path) throws FileNotFoundException;
    String[] parseFields(String path) throws FileNotFoundException;
    String[] parseValues(String path) throws FileNotFoundException;
}