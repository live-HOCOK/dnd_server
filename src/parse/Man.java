import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class Man<T> {
    String name;




    public static Field[] retrievingFields(Man man) {
        Class<?> current = man.getClass().getSuperclass();
        Field[] fields = current.getDeclaredFields();
        return fields;
    }


    public static boolean setField(Object targetObject, String fieldName, Object fieldValue) {
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



    static protected <T>T createContents() {
     return <T>T ;
    }

    public static <T> List<T> createList (Scanner scanner,String a) {
        //Class<T> t = new Class<T>().getClass();
        //Field[] fields = t.getDeclaredField();
        Field[] fields = createContents().getDeclaredFields();

        List<T> list = new ArrayList<>();// List players

        while (scanner.hasNext()) {
            String[] words = a.split(";");
            words = scanner.next().split(";");

            for (int j = 0; j < words.length; j++) {
                Field field = fields[j];
                if (field.getType().equals(int.class)) {
                    setField(createContents(), field.getName(), Integer.parseInt(words[j]));
                } else if (field.getType().equals(boolean.class)) {
                    setField(createContents(), field.getName(), Boolean.parseBoolean(words[j]));
                } else if (field.getType().equals(String.class)) {
                    setField(createContents(), field.getName(), words[j]);
                }
            }
            list.add(createContents());
        }
        for (int i = 0; i < list.size(); i++) {
   //         System.out.println(list.get(i).name + " " + list.get(i).paraped + " " + list.get(i).race + " " + list.get(i).sex + " " + list.get(i).pidr);
        }
        return list;
    }

    public static boolean checkFieldInCSV(String a, Field[] fields) {
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
