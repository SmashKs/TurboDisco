package taiwan.no.one.analytic

import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import io.sentry.Sentry
import io.sentry.SentryEvent
import io.sentry.SentryLevel
import io.sentry.protocol.Message
import java.util.Date

class Sender(
    private val analytics: FirebaseAnalytics,
) {
    fun sendEvent(event: Event) {
        if (event.providers.contains(Provider.ANALYTICS_FIREBASE)) {
            analytics.logEvent(event.eventName, event.params.toBundle())
        }
        if (event.providers.contains(Provider.SENTRY)) {
            val sentryEvent = SentryEvent(Date()).apply {
                level = SentryLevel.INFO
                logger = event.eventName
                message = Message().apply { unknown = event.params }
            }
            Sentry.captureEvent(sentryEvent)
        }
        Log.d(
            "Analytics",
            "\uD83D\uDCE9 Event was sent: ${event.eventName}. Params: ${event.params}. Providers: ${event.providers}",
        )
    }

    fun setUserProperty(property: Property) {
        if (property.providers.contains(Provider.ANALYTICS_FIREBASE)) {
            analytics.setUserProperty(property.propertyName, property.toString())
        }
        if (property.providers.contains(Provider.SENTRY)) {
            // do nothing
        }
    }
}
