package character

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class Player {

    @SerializedName("Ip") var ip: String = ""
    @SerializedName("Name") val name: String = ""
    @SerializedName("PlayerRace") val playerRace: CharacterRace? = null
    @SerializedName("PlayerClass") val playerClass: CharacterClass? = null
    @SerializedName("Health") var health: Int? = null
    @SerializedName("Armor") var armor: Int? = null
    @SerializedName("Strength") var strength: Int? = null
    @SerializedName("Agility") var agility: Int? = null
    @SerializedName("Endurance") var endurance: Int? = null
    @SerializedName("Intelligence") var intelligence: Int? = null
    @SerializedName("Charisma") var charisma: Int? = null
    @SerializedName("Equipments") var equipments = mutableListOf<String>()

    fun setBaseCharacteristic(_ip: String){
        if (playerRace != null && playerClass != null) {
            ip = _ip
            health = playerRace.health + playerClass.health
            armor = playerRace.armor + playerClass.armor
            strength = playerClass.strength
            agility = playerClass.agility
            endurance = playerClass.endurance
            intelligence = playerClass.intelligence
            charisma = playerClass.charisma
            equipments = playerClass.equipments
        }
    }

    fun toJson(): String{
        return Gson().toJson(this)
    }

}