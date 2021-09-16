package character


import com.google.gson.annotations.SerializedName

class CharacterRace(@SerializedName("Name") val name: String,
                    @SerializedName("Health") val health: Int,
                    @SerializedName("Armor") val armor: Int)

