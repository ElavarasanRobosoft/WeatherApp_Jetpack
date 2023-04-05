package com.robosoft.weatherappjetpack.presentation.recent_search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.robosoft.weatherappjetpack.presentation.ItemView
import com.robosoft.weatherappjetpack.presentation.ui.theme.WeatherAppJetpackTheme


@Composable
fun RecentContent(navController: NavController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (toolbar) = createRefs()
        val (content) = createRefs()

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .constrainAs(toolbar) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.navigate("Home_Screen") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
                Text(
                    text = "Recent Search", textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f), fontSize = 20.sp, color = Color.Black
                )
                IconButton(onClick = { navController.navigate("Search_screen") }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        tint = Color.Black
                    )
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(content) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(toolbar.bottom)
            }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 22.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "You recently searched for",
                        fontSize = 13.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 15.dp)
                            .weight(1f)
                    )
                    Text(
                        text = "Clear All",
                        fontSize = 13.sp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 16.dp, top = 15.dp)
                    )
                }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.padding(
                        top = 23.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
                ) {
                    items(count = 4) {
                        ItemView()
                    }
                }
            }
        }
    }
}


