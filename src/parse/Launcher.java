import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws Exception {



        //ArrayList listRace = new RaceContainer();
        CharacterСlassContainer listCharacterСlass = new CharacterСlassContainer("C:\\Temp\\csv1.csv");

       // Field[] fields = Man.retrievingFields(man);
        boolean runSystem = true;
        //boolean runSystem = Man.checkFieldInCSV(a,fields); //or move to condition if
        System.out.println("1");
        if (runSystem) {
            //Man.createList(scanner,a,fields);
           // listRace.getList("C:\\Temp\\csv1.csv");
            System.out.println(listCharacterСlass.size());
            System.out.println(listCharacterСlass.get(2).RaceName);
        }
    }
}
