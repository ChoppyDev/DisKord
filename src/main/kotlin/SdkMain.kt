import network.WebsocketClientEndpoint
import network.WebsocketMessageHandler
import java.net.URI

fun main() {

    try {
        println("starting project")

        val test = WebsocketClientEndpoint(URI("wss://gateway.discord.gg/?v=6&encoding=json"))

        test.addMessageHandler(WebsocketMessageHandler())
        test.sendMessage("{'test' : 'test' }")
        Thread.sleep(5000);
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }


}