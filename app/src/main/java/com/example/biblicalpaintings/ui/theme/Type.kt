package com.example.biblicalpaintings.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.biblicalpaintings.R

val firaSans = FontFamily(
    Font(R.font.firasans_bold),
    Font(R.font.firasans_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(

    displayMedium = TextStyle(
        fontFamily = firaSans,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
    )
    ,
    bodyLarge = TextStyle(
        fontFamily = firaSans,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = firaSans,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = firaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),

    bodySmall = TextStyle(
        fontFamily = firaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

)