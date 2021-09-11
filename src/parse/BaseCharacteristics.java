import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class BaseCharacteristics<T> extends ArrayList<T> {

    protected abstract T getInstance();

    protected Field[] retrievingFields() {
        Class<?> current = getInstance().getClass();
        Field[] fields = current.getDeclaredFields();
        return fields;
    }

    public BaseCharacteristics (String path) throws FileNotFoundException {

        Field[] fields = retrievingFields();
        IReadParse openCsvExample = new OpenCsvExample();
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
    }

//    public BaseCharacteristics (String path) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File(path));
//        scanner.useDelimiter("\\r\\n");
//       String a = scanner.next();
//
//        Field[] fields =retrievingFields();
//
//        while (scanner.hasNext()) {
//          //  String[] words = a.split(";");
//            //words = scanner.next().split(";");
//            String[] words = scanner.next().split(";");
//            T targetObject = getInstance();
//            for (int j = 0; j < words.length; j++) {
//                Field field = fields[j];
//
//                if (field.getType().equals(int.class)) {
//                    setField(targetObject, field.getName(), Integer.parseInt(words[j]));
//                } else if (field.getType().equals(boolean.class)) {
//                   setField(targetObject, field.getName(), Boolean.parseBoolean(words[j]));
//                } else if (field.getType().equals(String.class)) {
//                    setField(targetObject, field.getName(), words[j]);
//                }
//
//            }
//            add(targetObject);
//        }
//    }


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
