import character.CharacterClass
import character.CharacterRace
import character.Player
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
    var players = mutableListOf<Player>()

    override fun onOpen(webSocket: WebSocket, clientHandshake: ClientHandshake) {
        println("${webSocket.remoteSocketAddress.hostName} connected")
        if (players.find { it.ip == webSocket.remoteSocketAddress.hostName } != null) {
            val mess =
                Message(MessageType.CreatePlayer, players.find { it.ip == webSocket.remoteSocketAddress.hostName })
            sendMessage(mess, webSocket)
            return
        }
        val raceAndClasses = RacesAndClasses()
        // TODO получать список классов и рас из csv

        raceAndClasses.classes.add(CharacterClass("гвоноед", 1, 2, 3, 4, 5, 6, 7, mutableListOf("член", "говно")))
        raceAndClasses.classes.add(CharacterClass("членоед", 7, 6, 5, 4, 5, 6, 7, mutableListOf("писька", "зуб")))
        raceAndClasses.races.add(CharacterRace("криса", 1, 2))
        raceAndClasses.races.add(CharacterRace("мышка", 2, 1))
        //
        val mess = Message(MessageType.RacesAndClasses, raceAndClasses)
        sendMessageAll(mess, webSocket)
    }

    override fun onClose(webSocket: WebSocket, i: Int, massage: String, b: Boolean) {
        println("${webSocket.remoteSocketAddress.hostName} disconnected")
    }

    override fun onMessage(webSocket: WebSocket, message: String) {
        println("Receive message: $message from ${webSocket.remoteSocketAddress.hostName}")
        var mess = Gson().fromJson(message, Message::class.java)
        when (mess.messageType) {
            MessageType.RollDice -> {
                val rollDice = Gson().fromJson(mess.data.toString(), RollDice::class.java)
                rollDice.setValue()
                mess = Message(MessageType.RollDice, rollDice)
                sendMessageAll(mess, webSocket)
            }
            MessageType.CreatePlayer -> {
                val newPlayer = Gson().fromJson(mess.data.toString(), Player::class.java)
                newPlayer.setBaseCharacteristic(webSocket.remoteSocketAddress.hostName)
                players.add(newPlayer)
                mess = Message(MessageType.UpdatePlayer, newPlayer)
                sendMessageAll(mess, webSocket)
            }
            MessageType.UpdatePlayer -> {
                val newPlayer = Gson().fromJson(mess.data.toString(), Player::class.java)
                val existingPlayer = players.find { it.ip == webSocket.remoteSocketAddress.hostName }
                players.remove(existingPlayer)
                players.add(newPlayer)
                mess = Message(MessageType.UpdatePlayer, newPlayer)
                sendMessageAll(mess, webSocket)
            }
            else -> println("WARNING: Unknown message!")
        }
    }

    override fun onStart() {
        println("Server started!")
    }

    override fun onError(webSocket: WebSocket, e: Exception) {
        println(e)
    }

    private fun sendMessageAll(message: Message, webSocket: WebSocket) {
        println("Send message: ${message.toJSON()} to ${webSocket.remoteSocketAddress.hostName}")
        broadcast(message.toJSON())
    }

    private fun sendMessage(message: Message, webSocket: WebSocket) {
        println("Send message: ${message.toJSON()} to ${webSocket.remoteSocketAddress.hostName}")
        webSocket.send(message.toJSON())
    }

}