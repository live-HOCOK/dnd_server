package messages

abstract class Message<T> {

    abstract val messageType: MessageType

    abstract fun toJSON(): String

    abstract val value: T

}