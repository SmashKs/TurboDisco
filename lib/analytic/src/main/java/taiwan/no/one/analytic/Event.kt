package taiwan.no.one.analytic

abstract class Event(
    val eventName: String,
    val params: Map<String, Any?> = emptyMap(),
    val providers: List<Provider> = listOf(
        Provider.ANALYTICS_FIREBASE,
//        AnalyticsProvider.SENTRY
    ),
)
