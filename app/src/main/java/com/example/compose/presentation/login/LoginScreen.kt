package com.example.compose.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.R
import com.example.compose.presentation.components.OutLineTextFieldComponent
import com.example.compose.presentation.components.OutlinedButtonComponent
import com.example.compose.presentation.components.TextFieldComponent

@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds

        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )



        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 0.dp, 10.dp, 10.dp)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.BottomCenter,
        ) {


            val userValue = rememberSaveable {
                mutableStateOf("")
            }

            val passValue = rememberSaveable {
                mutableStateOf("")
            }

            ConstraintLayout {
                val (surface, fab) = createRefs()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = Color.Black.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(
                        percent = 8
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "Bienvenido",
                                style = MaterialTheme.typography.h6.copy(
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White,
                                    textAlign = TextAlign.Start
                                )
                            )

                            TextFieldComponent(
                                modifier = Modifier,
                                value = userValue,
                                textLabel = "Usuario",
                                keyboardType = KeyboardType.Text,
                                unfocusedColor = colorResource(id = R.color.white),
                                focusedColor = colorResource(id = R.color.orange_500),
                                icon = R.drawable.ic_person
                            )

                            OutLineTextFieldComponent(
                                modifier = Modifier,
                                passValue = passValue,
                                textLabel = stringResource(id = R.string.str_password),
                                unfocusedColor = colorResource(id = R.color.white),
                                focusedColor = colorResource(id = R.color.orange_500)
                            )

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                text = "Olvidaste tu contraseña?",
                                style = MaterialTheme.typography.body1.copy(
                                    color = Color.White
                                ),
                                textAlign = TextAlign.End
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            OutlinedButtonComponent()

                            ClickableText(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.White,
                                            fontWeight = FontWeight.Normal
                                        )
                                    ) {
                                        append("Aun no tienes cuenta?, ")
                                    }

                                    withStyle(
                                        style = SpanStyle(
                                            color = colorResource(id = R.color.cyan_500),
                                            fontWeight = FontWeight.Bold
                                        )
                                    ) {
                                        append("registrate aqui")
                                    }
                                },
                                onClick = {}
                            )
                        }
                    }
                }

                FloatingActionButton(
                    modifier = Modifier
                        .size(60.dp)
                        .constrainAs(fab) {
                            bottom.linkTo(surface.top, margin = -(30).dp)
                            end.linkTo(surface.end, margin = 30.dp)
                        },
                    backgroundColor = colorResource(id = R.color.cyan_200),
                    onClick = {},

                    ) {
                    Icon(
                        modifier = Modifier.size(42.dp),
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    }
}