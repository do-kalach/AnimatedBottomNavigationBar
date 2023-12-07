package com.example.animatedbottomnavigationbar

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

object IncludeContent {

    @Composable
    fun getListingContent() {
        val mContext = LocalContext.current
        LazyColumn {

            items(count = 25) {
                val item = it
                Row(
                    modifier = Modifier
                        .clickable {}
                        .padding(vertical = 12.dp, horizontal = 18.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Card(
                        modifier = Modifier.size(40.dp),
                        shape = CircleShape,
                    ) {
                        Image(
                            Icons.Filled.ThumbUp,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.width(18.dp))
                    Column {
                        Text(
                            text = "Order ID #:$item",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W500)
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }

    fun getListHomeData(context: Context): MutableList<HomeModel> {
        var items: MutableList<HomeModel> = ArrayList()
        val images = context.resources.obtainTypedArray(R.array.list_one_image)
        val titles = context.resources.getStringArray(R.array.list_one_title)
        for (i in titles.indices) {
            items.add(
                HomeModel(
                    id = i,
                    title = titles[i],
                    subtitle = "",
                    image = images.getResourceId(i, -1)
                )
            )
        }
        items = items.toMutableList()
        return items
    }
}