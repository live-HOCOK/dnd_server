package parse;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public interface IReadParse {
    <T>ArrayList get(Type type);
}