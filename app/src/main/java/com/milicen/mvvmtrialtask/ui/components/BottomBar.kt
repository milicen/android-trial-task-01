package com.milicen.mvvmtrialtask.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.milicen.mvvmtrialtask.R
import com.milicen.mvvmtrialtask.ui.theme.MVVMTrialTaskTheme

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.primary_xx_dark)
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .absoluteOffset(y = -(32.dp)),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                BottomBarButton(iconRes = R.drawable.wallet_2)
                BottomBarButton(iconRes = R.drawable.chart_2)
                BottomBarButton(iconRes = R.drawable.notification_bing)
                BottomBarButton(iconRes = R.drawable.setting)
            }
        }
    }
}

@Composable
fun BottomBarButton(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        onClick = { /*TODO*/ }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = "",
        )
    }
}



@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    MVVMTrialTaskTheme {
        Surface {
            Scaffold(
                bottomBar = {
                    BottomBar(
                        navController = rememberNavController(),
                    )
                }
            ) {
                Box(modifier = Modifier.padding(it))
            }
        }
    }
}