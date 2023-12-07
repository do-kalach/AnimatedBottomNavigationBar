package com.example.animatedbottomnavigationbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatedbottomnavigationbar.ui.theme.AnimatedBottomNavigationBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedBottomNavigationBarTheme {
                ContentListingDemo()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, device = "id:pixel_7_pro", showSystemUi = true, name = "First View")
@Composable
private fun ContentListingDemo() {

    val mContext = LocalContext.current

    var selectedItem by remember { mutableStateOf(0) }

    val manuIcons = listOf(
        Icons.Filled.Home,
        Icons.Filled.Favorite,
        Icons.Filled.ThumbUp,
        Icons.Filled.AccountCircle
    )

    val menuTitle = listOf(
        "Home",
        "Favorite",
        "Explore",
        "Profile"
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text ="Listing Demo") })
        },
        content = { innerpadding ->
            Column(modifier = Modifier.padding(innerpadding)) {
                LazyColumn {
                    val listingData = IncludeContent.getListHomeData(mContext)
                    items(listingData.size) {
                        val items = listingData[it]
                        //ui
                        Row(
                            Modifier
                                .padding(vertical = 10.dp, horizontal = 8.dp)
                                .clickable { }, verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.width(10.dp))
                            Image(
                                painter = painterResource(id = items.image),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(modifier = Modifier.width(18.dp))
                            Text(
                                text = items.title,
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W500)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.MoreVert, contentDescription = "menu")
                            }
                        }
                        Divider(color = MaterialTheme.colorScheme.outlineVariant)
                    }
                }
            }
        },
        bottomBar = {
            NavigationBar {
                manuIcons.forEachIndexed { index, icon ->
                    NavigationBarItem(selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = {
                            Icon(
                                imageVector = icon,
                                contentDescription = ""
                            )
                        },
                        label = if (selectedItem == index) {
                            { Text(text = menuTitle[index]) }
                        } else {
                            null
                        }
                    )
                }
            }
        }
    )
}