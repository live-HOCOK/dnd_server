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
            OpenCsvExample openCsvExample1 = new OpenCsvExample();
            OpenCsvExample openCsvExample2 = new OpenCsvExample();
            openCsvExample1.read("C:\\Temp\\Race.csv");
            System.out.println(openCsvExample1.size());
            System.out.println(openCsvExample1.get(0).get("raceName"));
            openCsvExample2.read("C:\\Temp\\CharacterСlass.csv");
            System.out.println(openCsvExample2.size());
            System.out.println(openCsvExample2.get(0).get("characterName"));
          /*  System.out.println(listRace.size());
            System.out.println(listRace.get(0).get("raceName"));
            System.out.println(listCharacterСlass.size());
            System.out.println(listCharacterСlass.get(2).get("characterName"));*/
        }
    }
}
