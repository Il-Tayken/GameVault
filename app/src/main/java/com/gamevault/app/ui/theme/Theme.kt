package com.gamevault.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary      = Color(0xFF66C0F4),
    secondary    = Color(0xFFA4D007),
    background   = Color(0xFF171A21),
    surface      = Color(0xFF1E2328),
    onPrimary    = Color(0xFF171A21),
    onBackground = Color(0xFFC7D5E0),
    onSurface    = Color(0xFFC7D5E0),
)

@Composable
fun GameVaultTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = DarkColorScheme, content = content)
}
