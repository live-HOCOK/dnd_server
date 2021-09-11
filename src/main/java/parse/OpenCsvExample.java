import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;

public class OpenCsvExample extends ArrayList<Map<String,Object>> implements IReadParse {

    public void read(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter("\\r\\n");
        String a = scanner.next();
        String[] fields = a.split(";");
        //List<Map<String,Object>> listMapObj = new ArrayList<>();

        while (scanner.hasNext()) {
            Map<String, Object> mapObj = new HashMap<>();
            String[] words = scanner.next().split(";");
            for (int j = 0; j < words.length; j++) {
                String field = fields[j];
                mapObj.put(field, words[j]);
            }
            add(mapObj);
        }
    }


    @Override
    public void parseValues(String path) throws FileNotFoundException {
        System.out.println("ha-ha");
    }

    @Override
    public void parseFields(String path) throws FileNotFoundException {
        System.out.println("ha-ha");

    }
}