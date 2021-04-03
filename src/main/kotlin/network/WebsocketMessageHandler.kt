package network

class WebsocketMessageHandler : MessageHandler {
    override fun handleMessage(message: String?) {
        println(message)
    }
}