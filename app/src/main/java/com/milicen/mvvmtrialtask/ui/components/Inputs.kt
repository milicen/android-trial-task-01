package com.milicen.mvvmtrialtask.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.milicen.mvvmtrialtask.R
import com.milicen.mvvmtrialtask.ui.theme.MVVMTrialTaskTheme

@Composable
fun Input(
    value: String,
    onChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    @StringRes labelRes: Int,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onChange,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        modifier = modifier,
        placeholder = {
            Text(
                text = stringResource(id = labelRes),
                color = colorResource(id = R.color.dark_grey),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        visualTransformation = visualTransformation,
        shape = MaterialTheme.shapes.extraSmall,
        colors = TextFieldDefaults.colors(
            unfocusedLeadingIconColor = colorResource(id = R.color.dark_grey),
            focusedLeadingIconColor = colorResource(id = R.color.dark_grey),
            unfocusedTrailingIconColor = colorResource(id = R.color.dark_grey),
            focusedTrailingIconColor = colorResource(id = R.color.dark_grey),
            focusedContainerColor = colorResource(id = R.color.light_grey),
            unfocusedContainerColor = colorResource(id = R.color.light_grey),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        )

    )
}

@Preview(showBackground = true)
@Composable
fun InputPreview() {
    MVVMTrialTaskTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            var username by remember { mutableStateOf("") }

            Input(
                value = username,
                onChange = {username = it},
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

            Spacer(modifier = Modifier.height(8.dp))

            var password by remember { mutableStateOf("") }

            Input(
                value = password,
                onChange = {password = it},
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
        }
    }
}