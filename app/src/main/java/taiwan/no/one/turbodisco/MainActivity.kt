package taiwan.no.one.turbodisco

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import taiwan.no.one.favorite.navigation.navigateToFavorite
import taiwan.no.one.photo.navigation.PhotoGraph
import taiwan.no.one.photo.navigation.PhotoNavHost
import taiwan.no.one.photo.navigation.navigateToPhoto
import taiwan.no.one.profile.navigation.navigateToProfile
import taiwan.no.one.search.navigation.SearchGraph
import taiwan.no.one.search.navigation.SearchGraphNavHost
import taiwan.no.one.search.navigation.navigateToSearch
import taiwan.no.one.turbodisco.component.BottomNavigationComponent
import taiwan.no.one.turbodisco.entity.TopLevelNavigationItem.CAMERA
import taiwan.no.one.turbodisco.entity.TopLevelNavigationItem.EXPLORE
import taiwan.no.one.turbodisco.entity.TopLevelNavigationItem.FAVORITE
import taiwan.no.one.turbodisco.entity.TopLevelNavigationItem.PROFILE

class MainActivity : ComponentActivity() {
    // Declare the launcher at the top of your Activity/Fragment:
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
        } else {
            // TODO: Inform user that that your app will not show notifications.
        }
    }

    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS,
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val rootNavController = rememberNavController()
                val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
                Scaffold(
                    modifier = Modifier,
                    topBar = {},
                    bottomBar = {
                        BottomNavigationComponent(
                            modifier = Modifier,
//                            currentDestination = navController.currentBackStackEntryAsState()?.value?.destination,
                            onNavigateTopLevelScreen = { topLevelItem ->
                                val topLevelNavOptions = navOptions {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(rootNavController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }

                                when (topLevelItem) {
                                    EXPLORE -> rootNavController.navigateToSearch(topLevelNavOptions)
                                    CAMERA -> rootNavController.navigateToPhoto(topLevelNavOptions)
                                    FAVORITE -> rootNavController.navigateToFavorite(topLevelNavOptions)
                                    PROFILE -> rootNavController.navigateToProfile(topLevelNavOptions)
                                }
                            },
                        )
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    ) {
                        NavHost(
                            modifier = Modifier,
                            navController = rootNavController,
                            startDestination = SearchGraph,
                        ) {
                            composable<SearchGraph> { SearchGraphNavHost() }
                            composable<PhotoGraph> { PhotoNavHost() }
//                            favoriteScreen()
//                            profileScreen()
                        }
                    }
                }
            }
        }

//        askNotificationPermission()
//
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(
//            OnCompleteListener { task ->
//                if (!task.isSuccessful) {
//                    return@OnCompleteListener
//                }
//
//                // Get new FCM registration token
//                val token = task.result
//
//                // Log and toast
//                println("=================================================")
//                println(token)
//                println("=================================================")
//                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
//            },
//        )
    }
}
