package taiwan.no.one.turbodisco

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseInstanceIDService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        println("==========tokennnnnn=======================================")
        println(token)
        println("=================================================")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        println("=================================================")
        println(message)
        println("=================================================")
    }

    override fun onMessageSent(msgId: String) {
        println("=================================================")
        println(msgId)
        println("=================================================")
    }
}
