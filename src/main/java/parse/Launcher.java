import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws Exception {




        CharacterСlassContainer listCharacterСlass = new CharacterСlassContainer("C:\\Temp\\csv1.csv");
        RaceContainer listRace = new RaceContainer("C:\\Temp\\csv1.csv");

        boolean runSystem = true;
        //boolean runSystem = Man.checkFieldInCSV(a,fields); //or move to condition if

        if (runSystem) {
            OpenCsvExample openCsvExample = new OpenCsvExample();
            openCsvExample.read("C:\\Temp\\csv1.csv");
            System.out.println(openCsvExample.size());
            System.out.println(openCsvExample.get(0).get("raceName"));
          /*  System.out.println(listRace.size());
            System.out.println(listRace.get(0).get("raceName"));
            System.out.println(listCharacterСlass.size());
            System.out.println(listCharacterСlass.get(2).get("characterName"));*/
        }
    }
}
