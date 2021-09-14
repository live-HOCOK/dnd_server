import character.CharacterClass
import character.CharacterRace
import com.google.gson.Gson
import messages.Message
import messages.MessageType
import messages.RacesAndClasses
import messages.RollDice
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress


class Server(port: Int) : WebSocketServer(InetSocketAddress(port)) {

    override fun onOpen(webSocket: WebSocket, clientHandshake: ClientHandshake) {
        println("${webSocket.remoteSocketAddress.hostName} connected")
        val raceAndClasses = RacesAndClasses()
        // TODO получать список классов и рас из csv
        raceAndClasses.classes.add(CharacterClass("гвоноед", 1, 2, 3, 4, 5, 6))
        raceAndClasses.races.add(CharacterRace("криса", 1, 2, 3, 4, 5, 6, ""))
        //
        val mess = Message()
        mess.messageType = MessageType.RacesAndClasses
        mess.data = raceAndClasses
        println("Send message: ${mess.toJSON()} to ${webSocket.remoteSocketAddress.hostName}")
        webSocket.send(mess.toJSON())
    }

    override fun onClose(webSocket: WebSocket, i: Int, massage: String, b: Boolean) {
        println("${webSocket.remoteSocketAddress.hostName} disconnected")
    }

    override fun onMessage(webSocket: WebSocket, message: String) {
        println("Receive message: $message from ${webSocket.remoteSocketAddress.hostName}")
        val mess = Gson().fromJson(message, Message::class.java)
        if (mess.messageType == MessageType.RollDice){
            val rollDice = Gson().fromJson(mess.data.toString(), RollDice::class.java)
            rollDice.setValue()
            mess.messageType = MessageType.RollDice
            mess.data = rollDice
            println("Send message : ${mess.toJSON()} to ${webSocket.remoteSocketAddress.hostName}")
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