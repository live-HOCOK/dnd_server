import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws Exception {



        ArrayList listRace = new RaceContainer();
        BaseCharacteristics listCharacterСlass = new CharacterСlassContainer();
       // Field[] fields = Man.retrievingFields(man);
        boolean runSystem = true;
        //boolean runSystem = Man.checkFieldInCSV(a,fields); //or move to condition if

        if (runSystem) {
            //Man.createList(scanner,a,fields);
           // listRace.getList("C:\\Temp\\csv1.csv");
            ((RaceContainer) listRace).getList("C:\\Temp\\csv1.csv");
            listCharacterСlass.getList("C:\\Temp\\csv1.csv");
           // System.out.println(listRace.size());
        }
    }
}
