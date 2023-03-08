package taiwan.no1.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import java.io.File
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.internal.cache.CacheInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import taiwan.no1.network.qualifier.CacheQualifier

internal val interceptorProvider = module {
    single { File(androidApplication().cacheDir, "http-cache") }
    single { 10 * 1024 * 1024L }
    single { Cache(get(), get()) }

    single<Interceptor> { CacheInterceptor(get()) }
    single<Interceptor>(CacheQualifier()) { taiwan.no1.network.interrceptor.CacheInterceptor(get()) }
}

internal val jsonProvider = module {
    single {
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            encodeDefaults = false
        }
    }
}

val networkProvider = module {
    includes(interceptorProvider, jsonProvider)

    single {
        HttpClient(OkHttp) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            install(ContentNegotiation) { json(get()) }
            // Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = 15_000L
                connectTimeoutMillis = 15_000L
                socketTimeoutMillis = 15_000L
            }
            engine {
                config {
                    followRedirects(true)
                }
                addInterceptor(get())
                addNetworkInterceptor(get(CacheQualifier()))
            }
        }
    }
}
