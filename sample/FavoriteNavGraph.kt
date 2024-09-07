import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.pixabayapp.navigationNewStructure.multiModule.singleModuleExample.deleteScreen
import com.example.pixabayapp.navigationNewStructure.multiModule.singleModuleExample.navigateToDeleteScreen
import com.example.pixabayapp.navigationNewStructure.multiModule.singleModuleExample.navigateToSearchScreen
import com.example.pixabayapp.navigationNewStructure.multiModule.singleModuleExample.navigateToUnfavoriteScreen
import com.example.pixabayapp.navigationNewStructure.multiModule.singleModuleExample.searchScreen
import com.example.pixabayapp.navigationNewStructure.multiModule.singleModuleExample.unfavoriteScreen

// add this in your main graph or if you have only one module add you NavHost here
fun NavGraphBuilder.favoriteNavGraphBuilder(navController: NavHostController) {

    unfavoriteScreen {
        // you can create viewModel here and the pass it to screen
        // or you can share your viewmodel base on navBack stack
        
     UnfavoriteRoute(
            onBackClick = onBackClick,
            onSearchClick = navController::navigateToSearchScreen
        )
    }

    searchScreen {
        // you can create viewModel here and the pass it to screen
        // or you can share your viewmodel base on navBack stack

      SearchRoute(
            onBackClick = onBackClick,
            onSearchClick = navController::navigateToDeleteScreen
        )
    }

    deleteScreen {
        // you can create viewModel here and the pass it to screen
        // or you can share your viewmodel base on navBack stack

        DeleteRoute(
            onBackClick = onBackClick,
            onSearchClick = navController::navigateToUnfavoriteScreen
        )
    }
}