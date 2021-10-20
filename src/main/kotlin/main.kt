fun main(args: Array<String>) {
    val port = 8765
    val s = Server(port)
    s.start()
    println("Server starting on port: ${s.port}")
    while (true){
        val keyIn = readLine()
        if (keyIn.equals("exit") or keyIn.equals("stop")){
            s.stop(1000)
            break
        } else if (keyIn.equals("players")) {
            s.players.forEach{
                println(it.ip)
            }
        } else if (keyIn.equals("new")) {
            s.players.clear()
        }
    }
}