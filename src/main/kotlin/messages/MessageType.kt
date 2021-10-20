package messages

import com.google.gson.annotations.SerializedName

enum class MessageType {
    @SerializedName("0")
    RollDice,
    @SerializedName("1")
    UpdatePlayer,
    @SerializedName("2")
    RacesAndClasses,
    @SerializedName("3")
    CreatePlayer,
    @SerializedName("4")
    NewGame,
}