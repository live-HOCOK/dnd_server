fun main(args: Array<String>) {
    val port = 8765
    val s = Server(port)
    s.start()
    println("ChatServer started on port: " + s.port)
    while (true){
        val keyIn = readLine()
        s.broadcast(keyIn)
        if (keyIn.equals("exit")){
            s.stop(1000)
            break
        }
    }
}