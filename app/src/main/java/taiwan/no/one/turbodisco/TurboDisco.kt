package taiwan.no.one.turbodisco

import android.app.Application
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import taiwan.no1.network.networkProvider

class TurboDisco : Application() {
    override fun onCreate() {
        super.onCreate()

        //region Koin Start Setting
        startKoin {
            androidLogger()
            androidContext(this@TurboDisco)
            modules(networkProvider)
        }
        //endregion

        FirebaseApp.initializeApp(this)
    }
}
