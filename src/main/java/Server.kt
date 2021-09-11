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
        val hostname = webSocket.remoteSocketAddress.hostName
        println(hostname)
        println(message)
    }

    override fun onStart() {
        println("Server started!")
    }

    override fun onError(webSocket: WebSocket, e: Exception) {
        println(e)
    }

}