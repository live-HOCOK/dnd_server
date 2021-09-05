package messages

class RacesAndClassesMessage: Message<String>() {

    override val messageType: MessageType = MessageType.RacesAndClasses

    override fun toJSON(): String {
        return "sss"
    }

    override val value: String = "ss"

}