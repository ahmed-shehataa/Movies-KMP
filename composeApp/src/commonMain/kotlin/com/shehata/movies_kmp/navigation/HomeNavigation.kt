package com.shehata.movies_kmp.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorContent
import com.shehata.movies_kmp.favorite.FavoriteScreen
import com.shehata.movies_kmp.movies.MoviesScreen

private val homeScreens = listOf(MoviesScreen, FavoriteScreen)

@Composable
fun HomeNavigator(content: NavigatorContent = { CurrentScreen() }) =
    Navigator(screens = homeScreens, content = content)