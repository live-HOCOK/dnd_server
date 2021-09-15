package character

import com.google.gson.annotations.SerializedName

class CharacterClass(@SerializedName("Name") val name: String,
                     @SerializedName("Health") val health: Int,
                     @SerializedName("Armor") val armor: Int,
                     @SerializedName("Strength") val strength: Int,
                     @SerializedName("Agility") val agility: Int,
                     @SerializedName("Endurance") val endurance: Int,
                     @SerializedName("Intelligence") val intelligence: Int,
                     @SerializedName("Charisma") val charisma: Int,
                     @SerializedName("Equipments") val equipments: MutableList<String>
)