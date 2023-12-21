package com.kashapovrush.cofeeshopstest.presentation.signInScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashapovrush.cofeeshopstest.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                TextFieldWithTitle(
                    title = "e-mail",
                    hint = "example@example.ru",
                    type = KeyboardType.Email
                )
                TextFieldWithTitle(
                    title = "Пароль",
                    hint = "********",
                    visualTransformation = PasswordVisualTransformation(),
                    type = KeyboardType.Password
                )

                Box(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 4.dp
                    )
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    ) {
                        Text(
                            text = stringResource(R.string.sign_in),
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                        )
                    }
                }

            }
        },
        topBar = {
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                ),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
            )
            {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.sign_in),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    },
                )
            }

        }
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TextFieldWithTitle(
    title: String,
    hint: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    type: KeyboardType
) {
    var inputTextEmail by rememberSaveable {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
    ) {
        Column {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onBackground
            )
            OutlinedTextField(
                placeholder = {
                    Text(
                        text = hint,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .alpha(0.4f)
                            .padding(start = 8.dp)
                    )
                },
                value = inputTextEmail,
                onValueChange = { inputTextEmail = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = RoundedCornerShape(32.dp)
                    )
                    .wrapContentHeight(),
                shape = RoundedCornerShape(32.dp),
                keyboardOptions = KeyboardOptions(keyboardType = type),
                visualTransformation = visualTransformation
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    SignInScreen()
}