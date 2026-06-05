package com.gamevault.auth.presentation

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamevault.common.AppStrings

// Auth uses default Russian until language is set — it's the first screen
private val S = AppStrings.RU

@Composable
fun AuthScreen(onAuthSuccess: (String) -> Unit) {
    val primary = MaterialTheme.colorScheme.primary
    val bg      = MaterialTheme.colorScheme.background
    val surface = MaterialTheme.colorScheme.surface
    val onBg    = MaterialTheme.colorScheme.onBackground
    val sub     = onBg.copy(alpha = 0.5f)

    var isLoginMode     by remember { mutableStateOf(true) }
    var username        by remember { mutableStateOf("") }
    var email           by remember { mutableStateOf("") }
    var password        by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorMsg        by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(surface, bg)))) {
        Column(modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            Box(modifier = Modifier.size(80.dp).background(primary, RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center) { Text("🎮", fontSize = 40.sp) }
            Spacer(Modifier.height(16.dp))
            Text("GameVault", color = onBg, fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Text(S.authSubtitle, color = sub, fontSize = 14.sp)
            Spacer(Modifier.height(40.dp))

            Row(modifier = Modifier.fillMaxWidth().background(surface, RoundedCornerShape(12.dp)).padding(4.dp)) {
                TabBtn(S.login, isLoginMode, Modifier.weight(1f)) { isLoginMode = true; errorMsg = "" }
                TabBtn(S.register, !isLoginMode, Modifier.weight(1f)) { isLoginMode = false; errorMsg = "" }
            }
            Spacer(Modifier.height(24.dp))

            Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = surface), shape = RoundedCornerShape(16.dp)) {
                Column(modifier = Modifier.padding(24.dp)) {
                    AnimatedVisibility(visible = !isLoginMode) {
                        Column {
                            AField(username, { username = it }, S.username, Icons.Default.Person)
                            Spacer(Modifier.height(12.dp))
                        }
                    }
                    AField(email, { email = it }, S.email, Icons.Default.Email, KeyboardType.Email)
                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(value = password, onValueChange = { password = it },
                        label = { Text(S.password, color = sub) },
                        leadingIcon = { Icon(Icons.Default.Lock, null, tint = primary) },
                        trailingIcon = { IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility, null, tint = sub) } },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = primary, unfocusedBorderColor = sub.copy(0.4f),
                            focusedTextColor = onBg, unfocusedTextColor = onBg, cursorColor = primary),
                        shape = RoundedCornerShape(10.dp))
                    if (errorMsg.isNotEmpty()) { Spacer(Modifier.height(8.dp)); Text(errorMsg, color = MaterialTheme.colorScheme.error, fontSize = 12.sp) }
                    Spacer(Modifier.height(20.dp))
                    Button(onClick = {
                        when {
                            email.isBlank()             -> errorMsg = S.enterEmail
                            password.length < 4         -> errorMsg = S.passwordShort
                            !isLoginMode && username.isBlank() -> errorMsg = S.enterUsername
                            else -> onAuthSuccess(if (isLoginMode) email.substringBefore("@") else username)
                        }
                    }, modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = primary), shape = RoundedCornerShape(10.dp)) {
                        Text(if (isLoginMode) S.loginBtn else S.registerBtn,
                            color = MaterialTheme.colorScheme.onPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    if (isLoginMode) { Spacer(Modifier.height(12.dp))
                        TextButton(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text(S.forgotPassword, color = primary, fontSize = 13.sp) } }
                }
            }
            Spacer(Modifier.height(24.dp))
            OutlinedButton(onClick = { onAuthSuccess("Гость") }, modifier = Modifier.fillMaxWidth().height(48.dp), shape = RoundedCornerShape(10.dp)) {
                Icon(Icons.Default.Person, null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text(S.loginAsGuest, fontSize = 14.sp)
            }
        }
    }
}

@Composable private fun TabBtn(text: String, selected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = modifier.height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primary else androidx.compose.ui.graphics.Color.Transparent,
            contentColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(10.dp), elevation = ButtonDefaults.buttonElevation(0.dp)) {
        Text(text, fontSize = 13.sp, fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal)
    }
}

@Composable private fun AField(value: String, onChange: (String) -> Unit, label: String, icon: ImageVector, keyboardType: KeyboardType = KeyboardType.Text) {
    val primary = MaterialTheme.colorScheme.primary; val onBg = MaterialTheme.colorScheme.onBackground; val sub = onBg.copy(0.5f)
    OutlinedTextField(value = value, onValueChange = onChange, label = { Text(label, color = sub) },
        leadingIcon = { Icon(icon, null, tint = primary) }, keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = primary, unfocusedBorderColor = sub.copy(0.4f),
            focusedTextColor = onBg, unfocusedTextColor = onBg, cursorColor = primary),
        shape = RoundedCornerShape(10.dp))
}
