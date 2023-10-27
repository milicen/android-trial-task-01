package com.milicen.mvvmtrialtask.ui

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.edit
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.milicen.mvvmtrialtask.R
import com.milicen.mvvmtrialtask.ui.components.BottomBar
import com.milicen.mvvmtrialtask.ui.data.FormViewModel
import com.milicen.mvvmtrialtask.ui.screens.HomeScreen
import com.milicen.mvvmtrialtask.ui.screens.LoginScreen
import com.milicen.mvvmtrialtask.ui.screens.RegisterScreen


enum class Screens() {
    Login,
    Register,
    Home
}

const val PREF_ID = "pref_id"
const val PREF_FIRSTNAME = "pref_firstname"
const val PREF_LASTNAME = "pref_lastname"
const val PREF_EMAIL = "pref_email"

@Composable
fun TrialTaskApp(
    owner: LifecycleOwner,
    navController: NavHostController = rememberNavController(),
    viewModel: FormViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.data.collectAsState()
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("userData", Context.MODE_PRIVATE)

    val config = LocalConfiguration.current
    var showBottomBar by remember { mutableStateOf(false) }
    var showCardDetail by remember {
        mutableStateOf(false)
    }

    viewModel.loginResponse.observe(owner, Observer { response ->
        if (response.isSuccessful) {
            viewModel.reset()
            val data = response.body()
            sharedPref.edit {
                putInt(PREF_ID, data?.id ?: 0)
                putString(PREF_FIRSTNAME, data?.firstName)
                putString(PREF_LASTNAME, data?.lastName)
                putString(PREF_EMAIL, data?.email)
                apply()
            }
            navController.navigate(Screens.Home.name) {
                popUpTo(0)
            }
            showBottomBar = true
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

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (showBottomBar) {
                BottomBar(navController = navController)
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Login.name,
            modifier = Modifier.padding(0.dp).fillMaxSize()
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
                        navController.navigate(Screens.Register.name)
                    },
                    modifier = Modifier.padding(paddingValues)
                )
            }

            composable(route = Screens.Register.name) {
                RegisterScreen(
                    username = uiState.username,
                    password = uiState.password,
                    email = viewModel.emailString,
                    onUsernameChange = { viewModel.setUsername(it) },
                    onPasswordChange = { viewModel.setPassword(it) },
                    onEmailChange = { viewModel.setEmail(it) },
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

            composable(route = Screens.Home.name) {
                HomeScreen(
                    onCardClick = {
                        showCardDetail = true
                        showBottomBar = false
                    }
                )

                if (showCardDetail) {
                    AndroidView(
                        factory = {context ->
                            val view = LayoutInflater.from(context).inflate(R.layout.fragment_details, null)

                            val id = sharedPref.getInt(PREF_ID, 0).toString()
                            val firstname = sharedPref.getString(PREF_FIRSTNAME, "")
                            val lastname = sharedPref.getString(PREF_LASTNAME, "")
                            val email = sharedPref.getString(PREF_EMAIL, "")

                            view.findViewById<TextView>(R.id.tv_id).text = id
                            view.findViewById<TextView>(R.id.tv_fullname).text = "$firstname $lastname"
                            view.findViewById<TextView>(R.id.tv_email).text = email

                            view.findViewById<ImageButton>(R.id.btn_close_detail).setOnClickListener {
                                showCardDetail = false
                                showBottomBar = true
                            }

                            view
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }
        }
    }
}


