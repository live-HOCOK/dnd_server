package messages

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


class Message(
    @SerializedName("MessageType") var messageType: MessageType? = null,
    @SerializedName("Data") var data: Any? = null) {

    fun toJSON(): String {
        return Gson().toJson(this)
    }

}