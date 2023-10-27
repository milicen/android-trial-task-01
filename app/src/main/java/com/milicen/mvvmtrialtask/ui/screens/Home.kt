package com.milicen.mvvmtrialtask.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.milicen.mvvmtrialtask.R
import com.milicen.mvvmtrialtask.ui.components.IconButtonWithText
import com.milicen.mvvmtrialtask.ui.theme.MVVMTrialTaskTheme
import com.milicen.mvvmtrialtask.ui.theme.QuicksandFont
import com.milicen.mvvmtrialtask.ui.theme.RubikFont

@Composable
fun HomeScreen(
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(scrollState)
    ) {
        Header()

        Spacer(modifier = Modifier.height(40.dp))

        CardOverview(
            onClick = onCardClick,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        IconButtonList(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(44.dp))

        TransactionList(
            modifier = Modifier.fillMaxWidth()
        )
        
    }
}

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = stringResource(id = R.string.wallet_title),
                style = MaterialTheme.typography.titleLarge,
            )

            Text(
                text = stringResource(id = R.string.wallet_status),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.grey),
                modifier = Modifier.offset(y = -(4.dp))
            )
        }

        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(56.dp)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardOverview(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.large,
        onClick = onClick,
        modifier = modifier,
        elevation = CardDefaults.cardElevation(16.dp)
    ) {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.card_overview),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .padding(40.dp)
            ) {
                CardOverviewDetail(
                    titleTextRes = R.string.balance_title,
                    detailTextRes = R.string.balance_amount
                )

                Spacer(modifier = Modifier.weight(1f))

                CardOverviewDetail(
                    titleTextRes = R.string.card_title,
                    detailTextRes = R.string.card_bank_name
                )
            }
        }

    }
}


@Composable
fun CardOverviewDetail(
    @StringRes titleTextRes: Int,
    @StringRes detailTextRes: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = titleTextRes),
            style = TextStyle(
                fontFamily = QuicksandFont,
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(16f, TextUnitType.Sp)
            ),
            color = colorResource(id = R.color.white)
        )

        Text(
            text = stringResource(id = detailTextRes),
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id = R.color.white)
        )
    }
}


@Composable
fun IconButtonList(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        IconButtonWithText(
            onClick = { },
            iconRes = R.drawable.convert,
            textRes = R.string.transfer)

        IconButtonWithText(
            onClick = { },
            iconRes = R.drawable.export,
            textRes = R.string.payment)

        IconButtonWithText(
            onClick = { },
            iconRes = R.drawable.money_send,
            textRes = R.string.payout)

        IconButtonWithText(
            onClick = { },
            iconRes = R.drawable.add_circle,
            textRes = R.string.top_up)
    }
}


@Composable
fun TransactionList(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row {
            Text(
                text = stringResource(id = R.string.transaction_list_title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = stringResource(id = R.string.view_all),
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.accent)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        TransactionItem(
            imgRes = R.drawable.netflix,
            textRes = R.string.netflix_title,
            descRes = R.string.netflix_desc,
            amountRes = R.string.netflix_amount
        )

        Spacer(modifier = Modifier.height(20.dp))

        TransactionItem(
            imgRes = R.drawable.paypal,
            textRes = R.string.paypal_title,
            descRes = R.string.paypal_desc,
            amountRes = R.string.paypal_amount
        )

        Spacer(modifier = Modifier.height(20.dp))

        TransactionItem(
            imgRes = R.drawable.gopay,
            textRes = R.string.gopay_title,
            descRes = R.string.gopay_desc,
            amountRes = R.string.gopay_amount
        )
    }
}

@Composable
fun TransactionItem(
    @DrawableRes imgRes: Int,
    @StringRes textRes: Int,
    @StringRes descRes: Int,
    @StringRes amountRes: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imgRes),
            contentDescription = "",
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    shape = CircleShape,
                    clip = false
                )
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(id = textRes),
                style = TextStyle(
                    fontFamily = RubikFont,
                    fontSize = TextUnit(16f, TextUnitType.Sp)
                )
            )
            Text(
                text = stringResource(id = descRes),
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.grey),
                modifier = Modifier.offset(y = -(4.dp))
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stringResource(id = amountRes),
            style = TextStyle(
                fontFamily = RubikFont,
                fontSize = TextUnit(16f, TextUnitType.Sp)
            )
        )
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    MVVMTrialTaskTheme {
        Surface {
            HomeScreen(onCardClick = {})
        }
    }
}