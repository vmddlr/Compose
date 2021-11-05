package com.example.compose.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldComponent(
    modifier: Modifier,
    value: MutableState<String>,
    maxChar: Int? = null,
    textLabel: String,
    keyboardType: KeyboardType,
    unfocusedColor: Color,
    focusedColor: Color,
    icon: Int
) {
    val focusManager = LocalFocusManager.current

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value.value.take(maxChar ?: 40),
        onValueChange = { newValue ->
            value.value = newValue
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        textStyle = TextStyle(
            fontSize = 18.sp
        ),
        label = {
            Text(
                color = unfocusedColor,
                text = textLabel,
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight.Medium
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = focusedColor,
            unfocusedBorderColor = unfocusedColor,
            backgroundColor = Color.Transparent,
            textColor = unfocusedColor
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Icono",
                tint = unfocusedColor
            )
        }
    )
}
