package messages

import com.google.gson.annotations.SerializedName

enum class MessageType {
    @SerializedName("0")
    RollDice,
    @SerializedName("1")
    UpdateParameters,
    @SerializedName("2")
    RacesAndClasses,
}