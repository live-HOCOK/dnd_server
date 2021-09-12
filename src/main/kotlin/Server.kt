import com.google.gson.Gson
import messages.Message
import messages.MessageType
import messages.RollDice
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress


class Server(port: Int) : WebSocketServer(InetSocketAddress(port)) {

    var ipPlayers = listOf<String>()

    override fun onOpen(webSocket: WebSocket, clientHandshake: ClientHandshake) {

        webSocket.send("эээээээээээ")
    }

    override fun onClose(webSocket: WebSocket, i: Int, massage: String, b: Boolean) {
        println("close: " + webSocket.remoteSocketAddress.hostName)
    }

    override fun onMessage(webSocket: WebSocket, message: String) {
        println(message)
        val mess = Gson().fromJson(message, Message::class.java)
        println(mess.messageType)
        println(mess.data)
        println(MessageType.RollDice)
        if (mess.messageType == MessageType.RollDice){
            val rollDice = Gson().fromJson(mess.data.toString(), RollDice::class.java)
            rollDice.SetValue()
            mess.messageType = MessageType.RollDice
            mess.data = rollDice
            print(mess.toJSON())
            broadcast(mess.toJSON())
        }
    }

    override fun onStart() {
        println("Server started!")
    }

    override fun onError(webSocket: WebSocket, e: Exception) {
        println(e)
    }

}