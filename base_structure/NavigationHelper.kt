package com.example.pixabayapp.navigationNewStructure

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

// a General class for for customize item
fun NavGraphBuilder.safeScreenInitial(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    screenSetUp: @Composable (NavBackStackEntry) -> Unit,
    deepLink: List<NavDeepLink> = emptyList(),
    getArgumentName: List<String>? = emptyList()
) {
    composable(
        route = getArgument(route, getArgumentName),
        arguments = arguments,
        deepLinks = deepLink
    ) { navBackStackEntry ->
        screenSetUp.invoke(navBackStackEntry)
    }
}

// a helper class for navigate safe between screens with parameters
fun NavController.safeNavigate(
    destinationScreen: String,
    popUpTo: String? = null,
    inclusiveScreen: Boolean = false,
    args: List<Any>? = emptyList()
) {
    if (args?.isNotEmpty() == true) {
        navigate(route = passArgument(destinationScreen, args)) {
            if (popUpTo != null) {
                popUpTo(popUpTo) { inclusive = inclusiveScreen }
            }
        }
    } else {
        navigate(route = destinationScreen) {
            if (popUpTo != null) {
                popUpTo(popUpTo) { inclusive = inclusiveScreen }
            }
        }
    }
}


// a helper class for navigate safe between screens with parameters
fun NavController.safeNavigate(
    destinationScreen: String,
    navOptions: NavOptions?=null,
    args: List<Any>? = emptyList()
) {
    if (args?.isNotEmpty() == true) {
        navigate(route = passArgument(destinationScreen, args),navOptions)
    } else {
        navigate(route = destinationScreen, navOptions)
    }
}


// use this function for passing your parameter and we use it in navigate
fun passArgument(router: String, args: List<Any>): String {
    return buildString {
        append(router)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}

// use this function for get your parameter and we use it in our screens
fun getArgument(router: String, value: List<String>?): String {
    return buildString {
        append(router)
        value?.forEach { arg ->
            append("/{$arg}")
        }
    }
}