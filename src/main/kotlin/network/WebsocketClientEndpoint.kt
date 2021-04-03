package network

import java.net.URI
import javax.websocket.ClientEndpoint
import javax.websocket.CloseReason
import javax.websocket.ContainerProvider
import javax.websocket.OnClose
import javax.websocket.OnMessage
import javax.websocket.OnOpen
import javax.websocket.Session

//@WebServiceClient
@ClientEndpoint
class WebsocketClientEndpoint(uri: URI) {

    var userSession: Session? = null
    private var messageHandler: MessageHandler? = null

    init {
        try {
            val container = ContainerProvider.getWebSocketContainer()
            container.connectToServer(this, uri)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @OnOpen
    fun onOpen(userSession: Session) {
        this.userSession = userSession
    }

    @OnClose
    fun onClose(userSession: Session, reason: CloseReason) {
        this.userSession = null
    }

    @OnMessage
    fun onMessage(message: String) {
        this.messageHandler?.handleMessage(message)
    }

    fun addMessageHandler(msgHandler: WebsocketMessageHandler) {
        this.messageHandler = msgHandler
    }

    fun sendMessage(message: String) {
        this.userSession?.asyncRemote?.sendText(message)
    }

}