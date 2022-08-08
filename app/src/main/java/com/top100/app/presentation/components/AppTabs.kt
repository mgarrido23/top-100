package com.top100.app.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.top100.app.presentation.theme.AppTheme
import com.top100.app.presentation.theme.selectedTabText

@Composable
fun AppTabs(
    titles: List<String>,
    selectedTabIndex: Int,
    onSelectTab: (Int) -> Unit,
) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        titles.forEachIndexed { index, tabTitle ->
            Tab(
                text = { Text(tabTitle) },
                selected = selectedTabIndex == index,
                onClick = { onSelectTab(index) },
                selectedContentColor = MaterialTheme.colors.selectedTabText,
            )
        }
    }
}

@Preview
@Composable
fun AppTabsPreview() {
    AppTheme {
        AppTabs(
            titles = listOf("Tab #1", "Tab #2"),
            selectedTabIndex = 0,
            onSelectTab = {},
        )
    }
}
