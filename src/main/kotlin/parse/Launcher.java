package parse;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws Exception {



        //ArrayList listRace = new RaceContainer();

        CharacterСlassContainer listCharacterСlass = new CharacterСlassContainer("src/main/resources/CharacterСlass.csv");
        RaceContainer listRace = new RaceContainer("src/main/resources/Race.csv");
       // Field[] fields = Man.retrievingFields(man);
        boolean runSystem = true;
        //boolean runSystem = Man.checkFieldInCSV(a,fields); //or move to condition if
        
        if (runSystem) {
            //Man.createList(scanner,a,fields);
           // listRace.getList("C:\\Temp\\csv1.csv");
            //System.out.println(listRace.size());
            //System.out.println(listRace.get(0));
            //System.out.println(listCharacterСlass.get(0).size());
            System.out.println(listCharacterСlass.get(0).get("equipments"));
            //System.out.println(listCharacterСlass.get(0).get(9));
            //String s = Gson().toJson(listRace);
            Gson gson = new Gson();
            String json = gson.toJson(listRace.get(0));
            Map obj = gson.fromJson(json, listRace.get(0).getClass());
            System.out.println(obj.get("equipment"));

        }
    }
}
