package messages

class RollDiceMessage constructor(number: Int): Message<Int>() {

    override val messageType: MessageType = MessageType.RollDice

    override fun toJSON(): String {
        return "sss"
    }

    override val value: Int = number
}