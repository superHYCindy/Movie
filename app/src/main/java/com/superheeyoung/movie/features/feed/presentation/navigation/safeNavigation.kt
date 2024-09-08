package com.superheeyoung.movie.features.feed.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavController.safeNavigate(direction : NavDirections) {
    currentDestination?.getAction(direction.actionId)?.run { navigate(direction) }
}