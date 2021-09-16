package parse;

public class CharacterСlass {
    public String characterName;
    public int health;
    public int armor;
    public int force;
    public int agility;
    public int intelligence;
    public int charisma;
    public String skill;
    public String[] equipments;

    public int getHealth() {
        return health;
    }

    public String[] getEquipments() {
        return equipments;
    }

    public int getCharisma() {
        return charisma;
    }

    public String getSkill() {
        return skill;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getForce() {
        return force;
    }

    public int getArmor() {
        return armor;
    }

    public String getCharacterName() {
        return characterName;
    }
}
