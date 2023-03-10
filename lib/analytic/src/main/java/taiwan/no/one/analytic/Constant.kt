package taiwan.no.one.analytic

object Constant {
    sealed class Events(val name: String) {
        data object FirstLaunch : Events("first_launch")

        data object SessionStart : Events("session_start")

        // Each event is having its own class
        data object Navigated : Events("navigated") {
            // this is an object which contains possible parameters. Note: it's not a final
            // list of possible parameters, some parameters can be re-used from other events.
            // The point is to keep all possible constants in this class
            data object Params {
                const val FROM = "from"
                const val TO = "to"
                const val EXTRA_INFO = "extra_information"
                const val TIME_OF_CLICKS = "time_of_clicks"
            }
        }

        data object SendClicked : Events("send_clicked") {
            object Params {
                const val WHICH = "which"
                const val TIME_OF_CLICKS = "time_of_clicks"
            }
        }

        data object NotificationsChanged : Events("notifications_changed")
    }

    object UserProperties {
        const val NOTIFICATION_STATE = "notification_state" // here we have a list of user properties
    }
}
