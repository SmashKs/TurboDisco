package taiwan.no.one.analytic

abstract class Property(
    val propertyName: String,
    val parameter: Any,
    val providers: List<Provider> = listOf(Provider.ANALYTICS_FIREBASE, Provider.SENTRY),
)
