package com.milicen.mvvmtrialtask.ui.components

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.milicen.mvvmtrialtask.R
import com.milicen.mvvmtrialtask.ui.theme.MVVMTrialTaskTheme
import com.milicen.mvvmtrialtask.ui.theme.QuicksandFont

@Composable
fun GoogleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SSOButton(
        buttonColorRes = R.color.white,
        iconResourceRes = R.drawable.google,
        iconDescription = "Google icon",
        textRes = R.string.google_sso,
        textColorRes = R.color.grey,
        onClick = onClick,
        modifier = modifier)
}

@Composable
fun FacebookButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SSOButton(
        buttonColorRes = R.color.fb_blue,
        iconResourceRes = R.drawable.facebook,
        iconDescription = "Facebook icon",
        textRes = R.string.facebook_sso,
        textColorRes = R.color.white,
        onClick = onClick,
        modifier = modifier)
}

@Composable
fun IconButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(50.dp),
        shape = MaterialTheme.shapes.small,
        contentPadding = PaddingValues(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(4.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = "",
            tint = Color.Unspecified
        )
    }
}

@Composable
fun IconButtonWithText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    @StringRes textRes: Int
) {
    Column(
        modifier = modifier
    ) {
        IconButton(
            onClick = onClick,
            modifier = modifier,
            iconRes = iconRes
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.bodySmall,
            color = colorResource(id = R.color.primary)
        )
    }
}

@Composable
fun SSOButton(
    @ColorRes buttonColorRes: Int,
    @DrawableRes iconResourceRes: Int,
    iconDescription: String,
    @StringRes textRes: Int,
    @ColorRes textColorRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = buttonColorRes)),
        shape = MaterialTheme.shapes.extraSmall,
        elevation = ButtonDefaults.buttonElevation(8.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResourceRes),
            contentDescription = iconDescription,
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(28.dp)
        )
        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = textColorRes)
        )
    }
}

@Composable
fun PrimaryButton(
    @StringRes textRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minWidth = 180.dp),
        contentPadding = PaddingValues(16.dp),
        shape = MaterialTheme.shapes.extraSmall,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primary_x_dark)
        )
    ) {
        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.bodyLarge,
            fontSize = TextUnit(18f, TextUnitType.Sp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GoogleButtonPreview() {
    MVVMTrialTaskTheme {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        ) {
            GoogleButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentSize()
                    .width(135.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FacebookButtonPreview() {
    MVVMTrialTaskTheme {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        ) {
            FacebookButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentSize()
                    .width(135.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconButtonWithTextPreview() {
    MVVMTrialTaskTheme {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        ) {
            IconButtonWithText(
                iconRes = R.drawable.convert,
                textRes = R.string.transfer,
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    MVVMTrialTaskTheme {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        ) {
            PrimaryButton(
                textRes = R.string.login_label,
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentSize()
            )
        }
    }
}