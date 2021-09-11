import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BaseCharacteristics<T> extends ArrayList<T> {
    public String RaceName;
    public String race;
    public String sex;
    public int paraped;
    public boolean pidr;
    private T race1;

    protected abstract T getInstance();

    public void getList (String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter("\\r\\n");
       String a = scanner.next();

        Field[] fields =retrievingFields();

        List<T> list = new ArrayList<>();// List players

        while (scanner.hasNext()) {
          //  String[] words = a.split(";");
            //words = scanner.next().split(";");
            String[] words = scanner.next().split(";");
            T targetObject = getInstance();
            for (int j = 0; j < words.length; j++) {
                Field field = fields[j];

                if (field.getType().equals(int.class)) {
                    setField(targetObject, field.getName(), Integer.parseInt(words[j]));
                } else if (field.getType().equals(boolean.class)) {
                   setField(targetObject, field.getName(), Boolean.parseBoolean(words[j]));
                } else if (field.getType().equals(String.class)) {
                    setField(targetObject, field.getName(), words[j]);
                }

            }
            list.add(targetObject);
            System.out.println(list.size());
        }
       for (int i = 0; i < 3; i++) {
           race1 = list.get(i);
           for (int j = 0; j < 5; i++) {

               Field field1 = fields[j];
                //System.out.println(list.size());
            //   field1.getName();
                System.out.println(race1);
                        //.field1.getName());// + " " + list.get(i).paraped + " " + list.get(i).race + " " + list.get(i).sex + " " + list.get(i).pidr);
           }
                   //System.out.println(list.get(i).toString().);+ " " + list.get(i).paraped + " " + list.get(i).race + " " + list.get(i).sex + " " + list.get(i).pidr);
        }

    }


    protected abstract Field[] retrievingFields();


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



  /*  static protected <T>T createContents() {
        return <T>T ;
    }*/



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
