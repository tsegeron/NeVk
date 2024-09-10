package com.laru.chats.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laru.app.ui.theme.VKMessengerTheme
import com.laru.chats.ui.composable.ChatsListItemRow
import com.laru.chats.ui.model.ChatsListItem
import com.laru.common.preview.ThemePreviews
import com.laru.ui.composable.VKMTabRow
import com.laru.ui.composable.TabItem
import com.laru.ui.composable.bottombar.VKMBottomAppBar
import com.laru.ui.model.Paddings
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatsScreen(
    chats: List<ChatsListItem> // maybe null/empty
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "NeVk") })
        },
        bottomBar = { VKMBottomAppBar({}, {}, {}) },
        snackbarHost = {

        },
        floatingActionButton = {
            IconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
            }
        }
    ) { innerPadding ->


        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            item { VKMTabRow(
                tabItems = TabItem.entries,
//                pagerState = ,
            ) }

            items(chats) { chat ->
                ChatsListItemRow(
                    chat = chat,
                    onClick = { /*TODO*/ })

            }
        }
    }
}

@Composable
@ThemePreviews
fun ChatsScreenPreview() {
    val mockData = listOf(
        ChatsListItem.mockDataShort, ChatsListItem.mockDataLong, ChatsListItem.mockDataShortMuted, ChatsListItem.mockDataLongMuted,
        ChatsListItem.mockDataShort, ChatsListItem.mockDataLong, ChatsListItem.mockDataShortMuted, ChatsListItem.mockDataLongMuted,
        ChatsListItem.mockDataShort, ChatsListItem.mockDataLong, ChatsListItem.mockDataShortMuted, ChatsListItem.mockDataLongMuted,
    )
    VKMessengerTheme {
        ChatsScreen(mockData)
    }
}
