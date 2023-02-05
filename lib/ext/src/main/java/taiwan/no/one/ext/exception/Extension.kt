package taiwan.no.one.ext.exception

inline fun UnsupportedOperation(): Nothing = throw UnsupportedOperationException()

inline fun UnsupportedOperation(reason: String): Nothing = throw UnsupportedOperationException(reason)
