// base on each screen you can have a file [screenName]+Actions
fun NavController.navigateToUnfavoriteScreen()  {
    safeNavigate(FavoriteRoutes.UnfavoriteScreen.router, args = listOf("a"), popUpTo = "Details_ROUTE")
}
fun NavController.navigateToDeleteScreen(navOptions: NavOptions? =null) = safeNavigate(FavoriteRoutes.DeleteScreen.router, navOptions)
fun NavController.navigateToSearchScreen(navOptions: NavOptions? =null) = navigate(FavoriteRoutes.SearchScreen.router, navOptions)