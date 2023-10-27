package com.milicen.mvvmtrialtask.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.milicen.mvvmtrialtask.R

val RubikFont = FontFamily(
    Font(R.font.rubik_regular),
    Font(R.font.rubik_medium, FontWeight.Medium)
)

val QuicksandFont = FontFamily(
    Font(R.font.quicksand_medium, FontWeight.Medium),
    Font(R.font.quicksand_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = RubikFont,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
//        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = RubikFont,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
//        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = QuicksandFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
//        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = QuicksandFont,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = QuicksandFont,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp
    ),
    labelSmall = TextStyle(
        fontFamily = QuicksandFont,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    )
)