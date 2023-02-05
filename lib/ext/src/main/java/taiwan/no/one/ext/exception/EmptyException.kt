package taiwan.no.one.ext.exception

class EmptyException : Exception {
    constructor() : super()
    constructor(msg: String) : super(msg)
    constructor(msg: String, throwable: Throwable) : super(msg, throwable)
    constructor(throwable: Throwable) : super(throwable)
}
