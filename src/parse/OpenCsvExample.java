import java.lang.reflect.Field;
import java.io. * ;
import java.util.Scanner;

public class OpenCsvExample {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("C:\\Temp\\csv1.csv"));
        scanner.useDelimiter("\\r\\n");
        String a = scanner.next();

      //  Race.createList("\"C:\\\\Temp\\\\csv1.csv\");

        Man man = new Race();
        Field[] fields = Man.retrievingFields(man);
        boolean runSystem = Man.checkFieldInCSV(a,fields); //or move to condition if

        if (runSystem) {
           //Man.createList(scanner,a,fields);

            Man.createList(scanner,a);
        }
    }
}