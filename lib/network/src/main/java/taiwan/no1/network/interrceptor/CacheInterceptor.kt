package taiwan.no1.network.interrceptor

import android.content.Context
import java.util.concurrent.TimeUnit
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

class CacheInterceptor(
    private val context: Context,
) : Interceptor {
    companion object {
        private const val CACHE_DAY = 1
        private const val HEADER_CACHE_CONTROL = "Cache-Control"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val cacheControl = if (true) {
            CacheControl.Builder().maxAge(0, TimeUnit.SECONDS).build()
        } else {
            CacheControl.Builder().maxStale(CACHE_DAY, TimeUnit.DAYS).build()
        }

        return response.newBuilder()
            .removeHeader(HEADER_CACHE_CONTROL)
            .header(HEADER_CACHE_CONTROL, cacheControl.toString())
            .build()
    }
}
