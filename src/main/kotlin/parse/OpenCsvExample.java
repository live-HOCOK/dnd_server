package parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OpenCsvExample implements IReadParse{


    public String[] read(String path) throws FileNotFoundException{
       Scanner scanner = new Scanner(new File(path));
       scanner.useDelimiter("\\r\\n");
       String a = scanner.next();
       String[] words = a.split(";");
       Map<String,Object> mapObj = new HashMap<String,Object>();
        while (scanner.hasNext()) {
          //  String[] words = a.split(";");
            //words = scanner.next().split(";");
            words = scanner.next().split(";");

        }
        return words;
    }


    public String[] parseValues(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter("\\r\\n");
        String a = scanner.next();
        while (scanner.hasNext()) {

            String[] words = scanner.next().split(";");
    }
        return new String[0];
    }


    public String[] parseFields(String path) throws FileNotFoundException{

        return new String[0];
    }
}