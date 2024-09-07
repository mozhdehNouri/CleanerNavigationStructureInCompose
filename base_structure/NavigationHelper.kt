package com.example.pixabayapp.navigationNewStructure

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

// A custom function for safely initializing a composable screen in a NavGraph.
// It supports arguments, deep links, and customizable route generation.
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


// A helper function for safe navigation between screens with optional parameters.
// It handles passing arguments, pop-up behavior, and screen inclusion in the back stack.
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

// A helper function for constructing a navigation route with arguments.
// It appends each argument to the base route for use in safe navigation.
fun passArgument(router: String, args: List<Any>): String {
    return buildString {
        append(router)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}

// A helper function for generating a route with placeholders for arguments.
// It formats the route with argument keys to retrieve them in the destination screen.
fun getArgument(router: String, value: List<String>?): String {
    return buildString {
        append(router)
        value?.forEach { arg ->
            append("/{$arg}")
        }
    }
}
