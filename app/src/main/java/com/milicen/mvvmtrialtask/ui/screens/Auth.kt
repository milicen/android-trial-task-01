package com.milicen.mvvmtrialtask.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.milicen.mvvmtrialtask.R
import com.milicen.mvvmtrialtask.ui.components.FacebookButton
import com.milicen.mvvmtrialtask.ui.components.GoogleButton
import com.milicen.mvvmtrialtask.ui.components.Input
import com.milicen.mvvmtrialtask.ui.components.PrimaryButton
import com.milicen.mvvmtrialtask.ui.theme.MVVMTrialTaskTheme


@Composable
fun LoginScreen(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login_title),
            style = MaterialTheme.typography.titleLarge,
            color = colorResource(id = R.color.primary_xx_dark),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(72.dp))

        SSOButtons()

        Spacer(modifier = Modifier.height(40.dp))

        Input(
            value = username,
            onChange = onUsernameChange,
            labelRes = R.string.username_label,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Input(
            value = password,
            onChange = onPasswordChange,
            labelRes = R.string.password_label,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.key_square),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.eye_slash),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(60.dp))

        PrimaryButton(
            textRes = R.string.login_label,
            onClick = onLoginClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = stringResource(id = R.string.no_account_label),
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.grey)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = stringResource(id = R.string.register_label),
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.light_blue),
                modifier = Modifier
                    .clickable(
                        enabled = true,
                        onClick = onRegisterClick
                    )
            )
        }
    }
}

@Composable
fun RegisterScreen(
    username: String,
    password: String,
    email: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = stringResource(id = R.string.register_title),
            style = MaterialTheme.typography.titleLarge,
            color = colorResource(id = R.color.primary_xx_dark),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(64.dp))

        SSOButtons()

        Spacer(modifier = Modifier.height(40.dp))

        Input(
            value = username,
            onChange = onUsernameChange,
            labelRes = R.string.username_label,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Input(
            value = email,
            onChange = onEmailChange,
            labelRes = R.string.email_label,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.sms),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Input(
            value = password,
            onChange = onPasswordChange,
            labelRes = R.string.password_label,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.key_square),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.eye_slash),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(60.dp))

        PrimaryButton(
            textRes = R.string.register_label,
            onClick = onRegisterClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = stringResource(id = R.string.hv_account_label),
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.grey)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = stringResource(id = R.string.login_label),
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.light_blue),
                modifier = Modifier
                    .clickable(
                        enabled = true,
                        onClick = onBackClick
                    )
            )
        }

    }
}

@Composable
fun SSOButtons(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.sign_up_with_label),
            style = MaterialTheme.typography.bodySmall,
            color = colorResource(id = R.color.grey)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            GoogleButton(onClick = { }, modifier = Modifier.width(135.dp))

            Spacer(modifier = Modifier.width(20.dp))

            FacebookButton(onClick = { }, modifier = Modifier.width(135.dp))
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    MVVMTrialTaskTheme {
        Surface {
            LoginScreen(
                username = "",
                password = "",
                onUsernameChange = {},
                onPasswordChange = {},
                onLoginClick = { /*TODO*/ },
                onRegisterClick = { /*TODO*/ })
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    MVVMTrialTaskTheme {
        Surface {
            RegisterScreen(
                username = "",
                password = "",
                email = "",
                onUsernameChange = {},
                onPasswordChange = {},
                onEmailChange = {},
                onBackClick = {},
                onRegisterClick = { /*TODO*/ })
        }
    }
}