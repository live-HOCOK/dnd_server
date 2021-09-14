fun main(args: Array<String>) {
    val port = 8765
    val s = Server(port)
    s.start()
    println("Server starting on port: ${s.port}")
    while (true){
        val keyIn = readLine()
        if (keyIn.equals("exit")){
            s.stop(1000)
            break
        }
    }
}