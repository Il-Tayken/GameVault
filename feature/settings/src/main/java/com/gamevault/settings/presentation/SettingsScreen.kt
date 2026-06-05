package com.gamevault.settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamevault.common.AppPrefs
import com.gamevault.common.AppStrings
import com.gamevault.common.getStrings

private val SD = Color(0xFF171A21); private val SC = Color(0xFF1E2328)
private val SB = Color(0xFF1B2838); private val SA = Color(0xFF66C0F4)
private val ST = Color(0xFFC7D5E0); private val SS = Color(0xFF8F98A0)
private val SR = Color(0xFFEF5350); private val SG = Color(0xFFA4D007)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    username: String,
    initialPrefs: AppPrefs = AppPrefs(),
    onBackClick: () -> Unit,
    onApply: (AppPrefs) -> Unit = {},
    onClearCache: () -> Unit = {},
    cacheSize: Int = 0,
    onLogout: () -> Unit
) {
    var notif      by remember { mutableStateOf(initialPrefs.notifications) }
    var autoRef    by remember { mutableStateOf(initialPrefs.autoRefresh) }
    var ratings    by remember { mutableStateOf(initialPrefs.showRatings) }
    var metacritic by remember { mutableStateOf(initialPrefs.showMetacritic) }
    var adult      by remember { mutableStateOf(initialPrefs.adultFilter) }
    var cache      by remember { mutableStateOf(initialPrefs.cacheEnabled) }
    var compact    by remember { mutableStateOf(initialPrefs.isCompact) }
    var language   by remember { mutableStateOf(initialPrefs.language) }
    var hasChanges by remember { mutableStateOf(false) }
    var showLogout by remember { mutableStateOf(false) }
    var showClear  by remember { mutableStateOf(false) }
    var showLang   by remember { mutableStateOf(false) }
    var cleared    by remember { mutableStateOf(false) }

    // Sync when initialPrefs change
    LaunchedEffect(initialPrefs) {
        notif = initialPrefs.notifications; autoRef = initialPrefs.autoRefresh
        ratings = initialPrefs.showRatings; metacritic = initialPrefs.showMetacritic
        adult = initialPrefs.adultFilter; cache = initialPrefs.cacheEnabled
        compact = initialPrefs.isCompact; language = initialPrefs.language
    }

    // Strings update instantly when language changes
    val s: AppStrings = getStrings(language)

    fun currentPrefs() = AppPrefs(showRatings=ratings, showMetacritic=metacritic, isCompact=compact,
        language=language, adultFilter=adult, autoRefresh=autoRef, cacheEnabled=cache, notifications=notif)
    fun markChanged() { hasChanges = true }

    val languages = listOf("Русский 🇷🇺", "English 🇬🇧", "Español 🇪🇸", "Deutsch 🇩🇪", "Français 🇫🇷", "中文 🇨🇳")

    if (showLogout) {
        AlertDialog(onDismissRequest = { showLogout = false }, containerColor = SC,
            title = { Text(s.logoutTitle, color = ST, fontWeight = FontWeight.Bold) },
            text = { Text(s.logoutConfirm, color = SS) },
            confirmButton = { TextButton(onClick = { showLogout = false; onLogout() }) { Text(s.logout, color = SR, fontWeight = FontWeight.Bold) } },
            dismissButton = { TextButton(onClick = { showLogout = false }) { Text(s.cancel, color = SA) } })
    }
    if (showClear) {
        AlertDialog(onDismissRequest = { showClear = false }, containerColor = SC,
            title = { Text(s.clearCacheTitle, color = ST, fontWeight = FontWeight.Bold) },
            text = { Text(s.clearCacheConfirm, color = SS) },
            confirmButton = { TextButton(onClick = { showClear = false; cleared = true; onClearCache() }) { Text(s.confirm, color = SR, fontWeight = FontWeight.Bold) } },
            dismissButton = { TextButton(onClick = { showClear = false }) { Text(s.cancel, color = SA) } })
    }
    if (showLang) {
        ModalBottomSheet(onDismissRequest = { showLang = false }, containerColor = SC) {
            Column(Modifier.padding(bottom = 32.dp)) {
                Text(s.chooseLanguage, color = ST, fontWeight = FontWeight.Bold, fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp))
                HorizontalDivider(color = SS.copy(alpha = 0.2f))
                languages.forEach { lang ->
                    val sel = language == lang
                    Row(modifier = Modifier.fillMaxWidth()
                        .clickable { language = lang; showLang = false; markChanged() }
                        .background(if (sel) SA.copy(0.1f) else Color.Transparent)
                        .padding(horizontal = 20.dp, vertical = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text(lang, color = if (sel) SA else ST, fontSize = 15.sp,
                            fontWeight = if (sel) FontWeight.SemiBold else FontWeight.Normal)
                        if (sel) Icon(Icons.Default.Check, null, tint = SA, modifier = Modifier.size(18.dp))
                    }
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(s.settingsTitle, color = ST, fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onBackClick) { Icon(Icons.Default.ArrowBack, null, tint = ST) } },
                actions = {
                    if (hasChanges) {
                        TextButton(onClick = { onApply(currentPrefs()); hasChanges = false },
                            modifier = Modifier.padding(end = 8.dp)) {
                            Icon(Icons.Default.Check, null, tint = SG, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(4.dp))
                            Text(s.apply, color = SG, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = SB)
            )
        },
        containerColor = SD
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState())) {

            // Профиль
            Card(Modifier.fillMaxWidth().padding(16.dp), colors = CardDefaults.cardColors(containerColor = SC), shape = RoundedCornerShape(16.dp)) {
                Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(60.dp).clip(CircleShape).background(SA), Alignment.Center) {
                        Text(username.firstOrNull()?.uppercaseChar()?.toString() ?: "G", color = SD, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.width(16.dp))
                    Column(Modifier.weight(1f)) {
                        Text(username, color = ST, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("GameVault ${s.gameLibrary.lowercase()}", color = SS, fontSize = 13.sp)
                    }
                    Surface(shape = RoundedCornerShape(6.dp), color = SG.copy(0.15f)) {
                        Text(s.online, color = SG, fontSize = 11.sp, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
                    }
                }
            }

            // Несохранённые изменения
            if (hasChanges) {
                Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = SA.copy(0.12f)), shape = RoundedCornerShape(10.dp)) {
                    Row(Modifier.padding(horizontal = 16.dp, vertical = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Info, null, tint = SA, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(10.dp))
                        Text(s.unsavedChanges, color = SA, fontSize = 12.sp)
                    }
                }
            }

            STitle(s.langTitle)
            SPickerItem(Icons.Default.Language, s.langInterface, language) { showLang = true }

            STitle(s.displayTitle)
            SToggle(Icons.Default.ViewCompact, s.compactCards, s.compactCardsSub, compact) { compact = it; markChanged() }
            SToggle(Icons.Default.Star, s.showRating, s.showRatingSub, ratings) { ratings = it; markChanged() }
            SToggle(Icons.Default.Score, s.showMeta, s.showMetaSub, metacritic) { metacritic = it; markChanged() }

            STitle(s.contentTitle)
            SToggle(Icons.Default.Block, s.adultFilter, s.adultFilterSub, adult) { adult = it; markChanged() }

            STitle(s.appTitle)
            SToggle(Icons.Default.Notifications, s.notifications, s.notificationsSub, notif) { notif = it; markChanged() }
            SToggle(Icons.Default.Refresh, s.autoRefresh, s.autoRefreshSub, autoRef) { autoRef = it; markChanged() }
            SToggle(Icons.Default.Storage, s.caching, s.cachingSub, cache) { cache = it; markChanged() }

            STitle(s.dataTitle)
            SInfo(Icons.Default.Api, s.dataSource, "RAWG.io — 900 000+")
            SInfo(Icons.Default.DataObject, s.database, "SQLDelight")
            Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp).clickable { showClear = true },
                colors = CardDefaults.cardColors(containerColor = SC), shape = RoundedCornerShape(12.dp)) {
                Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.DeleteSweep, null, tint = Color(0xFFFFB300), modifier = Modifier.size(22.dp))
                    Spacer(Modifier.width(16.dp))
                    Column(Modifier.weight(1f)) {
                        Text(s.clearCache, color = ST, fontSize = 15.sp)
                        val cacheSizeText = if (cacheSize > 0) "${cacheSize} ${s.games}" else s.clearCacheSub
                        Text(if (cleared) s.clearCacheDone else cacheSizeText, color = if (cleared) SG else SS, fontSize = 12.sp)
                    }
                    Icon(Icons.Default.ChevronRight, null, tint = SS)
                }
            }

            STitle(s.aboutTitle)
            SInfo(Icons.Default.Info, s.version, "GameVault 1.0.0")
            SInfo(Icons.Default.Code, s.tech, "Kotlin · Compose · Hilt · SQLDelight")

            Spacer(Modifier.height(24.dp))
            if (hasChanges) {
                Button(onClick = { onApply(currentPrefs()); hasChanges = false },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = SA), shape = RoundedCornerShape(12.dp)) {
                    Icon(Icons.Default.Check, null, tint = SD)
                    Spacer(Modifier.width(8.dp))
                    Text(s.applyChanges, color = SD, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(10.dp))
            }
            Button(onClick = { showLogout = true },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SR.copy(0.15f)), shape = RoundedCornerShape(12.dp)) {
                Icon(Icons.Default.Logout, null, tint = SR)
                Spacer(Modifier.width(8.dp))
                Text(s.logout, color = SR, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(Modifier.height(40.dp))
        }
    }
}

@Composable private fun STitle(t: String) =
    Text(t.uppercase(), color = SA, fontSize = 11.sp, fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 16.dp, top = 20.dp, bottom = 4.dp))

@Composable private fun SToggle(icon: ImageVector, title: String, sub: String, checked: Boolean, onChange: (Boolean) -> Unit) {
    Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = SC), shape = RoundedCornerShape(12.dp)) {
        Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, tint = SA, modifier = Modifier.size(22.dp))
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) { Text(title, color = ST, fontSize = 14.sp); Text(sub, color = SS, fontSize = 11.sp) }
            Switch(checked = checked, onCheckedChange = onChange,
                colors = SwitchDefaults.colors(checkedThumbColor = SD, checkedTrackColor = SA, uncheckedThumbColor = SS, uncheckedTrackColor = SC))
        }
    }
}

@Composable private fun SPickerItem(icon: ImageVector, title: String, value: String, onClick: () -> Unit) {
    Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp).clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = SC), shape = RoundedCornerShape(12.dp)) {
        Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 14.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, tint = SA, modifier = Modifier.size(22.dp))
            Spacer(Modifier.width(16.dp))
            Text(title, color = ST, fontSize = 14.sp, modifier = Modifier.weight(1f))
            Text(value, color = SA, fontSize = 13.sp)
            Spacer(Modifier.width(4.dp))
            Icon(Icons.Default.ChevronRight, null, tint = SS, modifier = Modifier.size(18.dp))
        }
    }
}

@Composable private fun SInfo(icon: ImageVector, title: String, sub: String) {
    Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = SC), shape = RoundedCornerShape(12.dp)) {
        Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, tint = SA, modifier = Modifier.size(22.dp))
            Spacer(Modifier.width(16.dp))
            Column { Text(title, color = ST, fontSize = 14.sp); Text(sub, color = SS, fontSize = 11.sp) }
        }
    }
}
