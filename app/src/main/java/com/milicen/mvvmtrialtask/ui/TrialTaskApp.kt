package com.milicen.mvvmtrialtask.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.milicen.mvvmtrialtask.MainActivity
import com.milicen.mvvmtrialtask.R
import com.milicen.mvvmtrialtask.ui.data.FormViewModel


enum class Screens() {
    Login,
    Register
}

@Composable
fun TrialTaskApp(
    owner: LifecycleOwner,
    navController: NavHostController = rememberNavController(),
    viewModel: FormViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.data.collectAsState()
    val context = LocalContext.current

    viewModel.loginResponse.observe(owner, Observer { response ->
        if (response.isSuccessful) {
            viewModel.reset()
            Toast.makeText(
                context,
                "Logged in as ${response.body()?.firstName} ${response.body()?.lastName}",
                Toast.LENGTH_LONG
            )
                .show()
        }
        else {
            viewModel.reset()
            Toast.makeText(
                context,
                "User not recognized.",
                Toast.LENGTH_LONG
            )
                .show()
        }
    })

    Scaffold(modifier = modifier) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Login.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screens.Login.name) {
                LoginScreen(
                    username = uiState.username,
                    password = uiState.password,
                    onUsernameChange = { viewModel.setUsername(it) },
                    onPasswordChange = { viewModel.setPassword(it) },
                    onLoginClick = {
                        viewModel.login()
                    },
                    onRegisterClick = {
                        navController.navigate(Screens.Register.name) }
                )
            }

            composable(route = Screens.Register.name) {
                RegisterScreen(
                    username = uiState.username,
                    password = uiState.password,
                    confirmPassword = viewModel.confirmPass,
                    onUsernameChange = { viewModel.setUsername(it) },
                    onPasswordChange = { viewModel.setPassword(it) },
                    onConfirmPasswordChange = { viewModel.setConfirmPassword(it) },
                    onRegisterClick = {
                        viewModel.reset()
                        Toast.makeText(
                            context,
                            "User registered",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        navController.navigateUp()
                    },
                    onBackClick = {
                        viewModel.reset()
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

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
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), 
            contentDescription = "Logo",
        )

        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = onUsernameChange,
            label = {
                Text(text = stringResource(id = R.string.username_label))
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = {
                Text(text = stringResource(id = R.string.password_label))
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onLoginClick,
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.login_label))
        }

        OutlinedButton(
            onClick = onRegisterClick,
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.register_label))
        }

    }
}

@Composable
fun RegisterScreen(
    username: String,
    password: String,
    confirmPassword: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo",
        )

        Text(
            text = "Register",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = onUsernameChange,
            label = {
                Text(text = stringResource(id = R.string.username_label))
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = {
                Text(text = stringResource(id = R.string.password_label))
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            label = {
                Text(text = stringResource(id = R.string.confirm_password_label))
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onRegisterClick,
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.register_label))
        }

        OutlinedButton(
            onClick = onBackClick,
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.back_label))
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview(){
//    LoginScreen(
//        onRegisterClick = {},
//        onLoginClick = {},
//        username = "",
//        password = ""
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun RegisterScreenPreview() {
//    RegisterScreen(
//        username = "",
//        password = "",
//        confirmPassword = "",
//        onRegisterClick = {}
//    )
//}
