package cn.huacheng.safebaiyun.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cn.huacheng.safebaiyun.unlock.UnlockRepo

/**
 *
 *@description:
 *@author: guangzhou
 *@create: 2024-05-10
 */


@Composable
fun LogView(modifier: Modifier = Modifier) {
    val logList by UnlockRepo.logFlow.collectAsState()
    if (logList.isEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "暂无日志")
        }
    } else {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(logList, contentType = { 0 }) {
                Text(it)
            }
        }
    }
}
