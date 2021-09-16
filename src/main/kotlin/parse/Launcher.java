package parse;

public class Launcher {
    public static void main(String[] args) throws Exception {



        //ArrayList listRace = new RaceContainer();

        CharacterСlassContainer listCharacterСlass = new CharacterСlassContainer(new CsvParser("src/main/resources/CharacterСlass.csv"));
        RaceContainer listRace = new RaceContainer(new CsvParser("src/main/resources/Race.csv"));

        System.out.println(listRace.get(0).getHealth());
        //System.out.println(listCharacterСlass.get(0).getSkill());
        System.out.println(listRace.get(0).getRaceName());


        System.out.println(listCharacterСlass.get(0).getHealth());
        System.out.println(listCharacterСlass.get(0).getSkill());
        System.out.println(listCharacterСlass.get(0).getEquipments()[1]);

       // Field[] fields = Man.retrievingFields(man);
        //boolean runSystem = Man.checkFieldInCSV(a,fields); //or move to condition if

    }
}
