import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;

public abstract class BaseCharacteristics<T> extends ArrayList<Map<String,Object>> {

    protected abstract T getInstance();

    protected Field[] retrievingFields() {
        Class<?> current = getInstance().getClass();
        Field[] fields = current.getDeclaredFields();
        return fields;
    }

/*    public BaseCharacteristics (String path) throws FileNotFoundException {

       Field[] fields = retrievingFields();
        IReadParse openCsvExample = new OpenCsvExample();
        String[] massFields1 = openCsvExample.read(path);
        String[] massFields = openCsvExample.parseFields(path);
        String[] massValues = openCsvExample.parseValues(path);
        for (int i = 0; i < massFields.length; i++) {
            T targetObject = getInstance();
            for (int j = 0; j < massFields.length; j++) {
                Field field = fields[j];
                if (field.getType().equals(int.class)) {
                    setField(targetObject, field.getName(), Integer.parseInt(massValues[j]));
                } else if (field.getType().equals(boolean.class)) {
                    setField(targetObject, field.getName(), Boolean.parseBoolean(massValues[j]));
                } else if (field.getType().equals(String.class)) {
                    setField(targetObject, field.getName(), massValues[j]);
                }

            }
            add(targetObject);
        }
    }*/

    public BaseCharacteristics (String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter("\\r\\n");
        String a = scanner.next();
        List<Map<String,Object>> listMapObj = new ArrayList<>();

        Field[] fields =retrievingFields();

        while (scanner.hasNext()) {
            Map<String,Object> mapObj = new HashMap<>();
            String[] words = scanner.next().split(";");
            for (int j = 0; j < words.length; j++) {
                String field = fields[j].getName();
                mapObj.put(field,words[j]);
            }
            add(mapObj);
        }
}


   public boolean setField(Object targetObject, String fieldName, Object fieldValue) {
        Field field;
        try {
            field = targetObject.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            field = null;
        }
        Class superClass = targetObject.getClass().getSuperclass();
        while (field == null && superClass != null) {
            try {
                field = superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                superClass = superClass.getSuperclass();
            }
        }
        if (field == null) {
            return false;
        }
        field.setAccessible(true);
        try {
            field.set(targetObject, fieldValue);
            return true;
        } catch (IllegalAccessException e) {
            return false;
        }
    }

    public boolean checkFieldInCSV(String a, Field[] fields) {
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
    }

}
