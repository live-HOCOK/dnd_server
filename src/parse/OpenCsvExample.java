import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenCsvExample implements IReadParse{


    public Scanner read(String path) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(path));
        //scanner.useDelimiter("\\r\\n");
        //String a = scanner.next();
        //String[] words = a.split(";");
        return scanner;
    }

    @Override
    public String[] parseValues(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter("\\r\\n");
        String a = scanner.next();
        while (scanner.hasNext()) {

            String[] words = scanner.next().split(";");
    }
        return new String[0];
    }

    @Override
    public String[] parseFields(String path) throws FileNotFoundException{
        read(path).useDelimiter("\\r\\n");
        String a = read(path).next();
        String[] words = a.split(";");
       // String[] words = read(path).split(";");

        return words;
    }
}