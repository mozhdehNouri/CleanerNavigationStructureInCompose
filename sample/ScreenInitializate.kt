import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.example.pixabayapp.navigationNewStructure.multiModule.FavoriteRoutes
import com.example.pixabayapp.navigationNewStructure.safeScreenInitial

fun NavGraphBuilder.unfavoriteScreen(screen: @Composable (NavBackStackEntry) -> Unit) =
    safeScreenInitial(
        route = FavoriteRoutes.UnfavoriteScreen.router,
        screenSetUp = {
            screen.invoke(it)
        }
    )

fun NavGraphBuilder.searchScreen(screen: @Composable (NavBackStackEntry) -> Unit) =
    safeScreenInitial(
        route = FavoriteRoutes.SearchScreen.router,
        screenSetUp = {
            screen.invoke(it)
        }
    )

fun NavGraphBuilder.deleteScreen(screen: @Composable (NavBackStackEntry) -> Unit) =
    safeScreenInitial(
        route = FavoriteRoutes.DeleteScreen.router,
        screenSetUp = {
            screen.invoke(it)
        }
    )