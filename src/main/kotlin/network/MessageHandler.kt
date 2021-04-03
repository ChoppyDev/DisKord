package network

interface MessageHandler {
    fun handleMessage(message: String?)
}