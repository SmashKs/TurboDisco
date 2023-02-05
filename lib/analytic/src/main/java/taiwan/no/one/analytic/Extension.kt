package taiwan.no.one.analytic

import android.os.Bundle

fun Map<String, Any?>.toBundle() = Bundle().apply {
    filter { (_, value) -> value != null }
        .forEach { (key, value) -> putString(key, value.toString()) }
}
