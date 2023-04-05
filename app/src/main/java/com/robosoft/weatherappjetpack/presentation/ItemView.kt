package com.robosoft.weatherappjetpack.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.robosoft.weatherappjetpack.R


@Preview
@Composable
fun ItemView() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = Color.Gray.copy(alpha = 0.3f))

    ) {
        val (place) = createRefs()
        val (icon) = createRefs()
        val (temperature) = createRefs()
        val (degree) = createRefs()
        val (description) = createRefs()
        val (like) = createRefs()

        Text(
            text = "Udupi, Karnataka",
            fontSize = 15.sp,
            color = Color.Yellow,
            modifier = Modifier
                .constrainAs(place) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
                .padding(start = 15.dp, top = 15.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
            contentDescription = "weather",
            modifier = Modifier
                .constrainAs(icon) {
                    start.linkTo(parent.start)
                    top.linkTo(place.bottom)
                }
                .padding(start = 15.dp, top = 10.dp)
        )

        Text(text = "31", fontSize = 18.sp, color = Color.White, modifier = Modifier
            .constrainAs(temperature) {
                start.linkTo(icon.end)
                top.linkTo(place.bottom)
            }
            .padding(start = 9.dp, top = 11.dp)
        )

        Text(text = "℃", fontSize = 12.sp, color = Color.White, modifier = Modifier
            .constrainAs(degree) {
                start.linkTo(temperature.end)
                top.linkTo(place.bottom)
            }
            .padding(start = 1.dp, top = 16.dp)
        )

        Text(text = "Mostly Sunny", fontSize = 14.sp, color = Color.White, modifier = Modifier
            .constrainAs(description) {
                start.linkTo(degree.end)
                top.linkTo(place.bottom)
            }
            .padding(start = 17.dp, top = 14.dp))

        Image(
            painter = painterResource(id = R.drawable.icon_favourite_active),
            contentDescription = "favourite icon", modifier = Modifier
                .constrainAs(like) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(end = 20.dp, top = 32.dp)
                .size(18.dp))
    }
}