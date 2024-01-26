package com.shehata.movies_kmp.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

open class CompactDimen(private val factor: Float = 1F) {
    open val spaceXXXSmall: Dp = 2.dp
        get() = field * factor
   open val spaceXXSmall: Dp = 4.dp
        get() = field * factor
   open val spaceXSmall: Dp = 6.dp
        get() = field * factor
   open val spaceSmall: Dp = 8.dp
        get() = field * factor
   open val spaceMedium: Dp = 10.dp
        get() = field * factor
   open val spaceLarge: Dp = 12.dp
        get() = field * factor
   open val spaceXLarge: Dp = 14.dp
        get() = field * factor
   open val spaceXXLarge: Dp = 16.dp
        get() = field * factor
   open val spaceXXXLarge: Dp = 18.dp
        get() = field * factor

    open val movieCardSize: Dp = 120.dp
        get() = field * factor
}
class MediumDimen: CompactDimen(factor = 1.5f)
class ExpandedDimen: CompactDimen(factor = 2f)