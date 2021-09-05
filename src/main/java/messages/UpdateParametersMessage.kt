package messages

class UpdateParametersMessage() : Message<String>() {

    override val messageType: MessageType = MessageType.UpdateParameters

    override fun toJSON(): String {
        return "sss"
    }

    override val value: String = "ss"

}