package parse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.File;
import java.io.FileNotFoundException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class CsvParser extends BaseParseToJson {

    ArrayList<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

    public CsvParser(String path)throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter("\\r\\n");
        String[] fields =scanner.next().split(";");

        while (scanner.hasNext()) {
            Map<String,Object> mapObj = new HashMap<String,Object>();
            String[] words = scanner.next().split(";");

            for (int j = 0; j < words.length; j++) {
                String field = fields[j];
                mapObj.put(field,words[j]);
            }
            list.add(mapObj);
        }
    }

    public <T>ArrayList get(Type type) {
        ArrayList<T> l = new ArrayList<T>();

        //Type type = new TypeToken< ArrayList<Map<String,Object>>>(){}.getType();
        //Type type = new TypeToken<type>(){}.getType();
      //  Type t = instance.getClass().getGenericSuperclass();
       // Type type1 = new TypeToken<in1.getClass>(){}.getType();
        //Type[] parameters = type.getArrayComponentType;
        for (int i = 0; i < list.size(); i++) {
            Gson gson = new Gson();
            String json = gson.toJson(list.get(0));
            json = json.replace("\"[", "[");
            json = json.replace("]\"", "]");
            json = json.replace("\"{", "{");
            json = json.replace("}\"", "}");
            // String a = "{\"equipments\":[da,ea,tata1],\"armor\":\"10\",\"skill\":\"light\",\"characterName\":\"paladin\",\"health\":\"100\",\"force\":\"12\",\"agility\":\"8\",\"charisma\":\"5\",\"intelligence\":\"8\"}";
          //  T obj = gson.fromJson(json, Class<T> in1);
            Type typ = new TypeToken<T>(){}.getType();
            T obj = gson.fromJson(json, type);
            // public <T> T fromJson(JsonElement json, Class<T> classOfT)
         //   T outputList = new Gson().fromJson(json, new TypeToken<T>() { }.getType());
           // l.add(outputList);
            l.add(obj);
        }
        return l;
    }


}