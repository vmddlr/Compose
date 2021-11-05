package com.example.compose.presentation.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.presentation.components.ButtonRoundedComponent
import com.example.compose.presentation.components.OutLineTextFieldComponent
import com.example.compose.presentation.components.TextFieldComponent


@Composable
fun RegistrationScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val nameMSO = rememberSaveable {
                mutableStateOf("")
            }

            val emailMSO = rememberSaveable() {
                mutableStateOf("")
            }

            val phoneMSO = rememberSaveable() {
                mutableStateOf("")
            }

            val passwordMSO = rememberSaveable() {
                mutableStateOf("")
            }

            val confirmPasswordMSO = rememberSaveable() {
                mutableStateOf("")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = stringResource(id = R.string.str_back),
                        tint = colorResource(id = R.color.cyan_700)
                    )
                }

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.str_create_account),
                    style = MaterialTheme.typography.h6.copy(
                        color = colorResource(id = R.color.cyan_700),
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextFieldComponent(
                    modifier = Modifier,
                    value = nameMSO,
                    textLabel = "Nombre",
                    keyboardType = KeyboardType.Text,
                    unfocusedColor = Color.Black,
                    focusedColor = colorResource(id = R.color.cyan_700),
                    icon = R.drawable.ic_person
                )

                TextFieldComponent(
                    modifier = Modifier,
                    value = emailMSO,
                    textLabel = "Email",
                    keyboardType = KeyboardType.Email,
                    unfocusedColor = Color.Black,
                    focusedColor = colorResource(id = R.color.cyan_700),
                    icon = R.drawable.ic_email
                )

                TextFieldComponent(
                    modifier = Modifier,
                    value = phoneMSO,
                    textLabel = "Telefono",
                    maxChar = 10,
                    keyboardType = KeyboardType.Phone,
                    unfocusedColor = Color.Black,
                    focusedColor = colorResource(id = R.color.cyan_700),
                    icon = R.drawable.ic_phone
                )

                OutLineTextFieldComponent(
                    modifier = Modifier,
                    passValue = passwordMSO,
                    textLabel = stringResource(id = R.string.str_password),
                    unfocusedColor = Color.Black,
                    focusedColor = colorResource(id = R.color.cyan_700)
                )

                OutLineTextFieldComponent(
                    modifier = Modifier,
                    passValue = confirmPasswordMSO,
                    textLabel = stringResource(id = R.string.str_password_confirm),
                    unfocusedColor = Color.Black,
                    focusedColor = colorResource(id = R.color.cyan_700)
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(20.dp))

                    ButtonRoundedComponent(
                        modifier = Modifier,
                        backgroundColor = colorResource(id = R.color.cyan_700),
                        textLabel = "Registrar",
                        textColor = Color.White
                    )

                    ClickableText(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal
                                )
                            ){
                                append("Ya tengo una cuenta? ")
                            }

                            withStyle(
                                SpanStyle(
                                    color = colorResource(id = R.color.cyan_700),
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append("Ingresar")
                            }
                        },
                        onClick = {}

                    )
                }
            }
        }
    }

}