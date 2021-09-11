import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;

public abstract class BaseCharacteristics<T> extends ArrayList<Map<String,Object>> {

    protected abstract T getInstance();

/*    protected Field[] retrievingFields() {
        Class<?> current = getInstance().getClass();
        Field[] fields = current.getDeclaredFields();
        return fields;
    }*/


    public BaseCharacteristics (String path) throws FileNotFoundException {

}


/*    public boolean checkFieldInCSV(String a, Field[] fields) {
        boolean runSystem = false;
        String[] words = a.split(";");
        for (int i = 0; i < words.length; i++) {
            if (fields[i].getName().compareTo(words[i]) == 0) { // Checking fields CSV
                runSystem = true;
            } else {
                System.out.println("All shit!");
                runSystem = false;
                break;
            }
        }
        return runSystem;
    }*/

}
