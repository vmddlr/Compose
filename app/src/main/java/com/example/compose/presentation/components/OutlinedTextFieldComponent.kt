package com.example.compose.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import com.example.compose.R

@Composable
fun OutLineTextFieldComponent(
    modifier: Modifier,
    passValue: MutableState<String>,
    textLabel : String,
    unfocusedColor: Color,
    focusedColor: Color,
) {
    val focusManager = LocalFocusManager.current

    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.ic_visibility)
    else
        painterResource(id = R.drawable.ic_visibility_off)

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = passValue.value,
        onValueChange = { newValue ->
            passValue.value = newValue
        },
        label = {
            Text(
                color = unfocusedColor,
                text = textLabel,
                style = MaterialTheme.typography.subtitle1.copy(
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
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = stringResource(id = R.string.str_password),
                tint = unfocusedColor
            )
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "visible",
                    tint = unfocusedColor
                )
            }
        },
        visualTransformation = if (passwordVisibility)
            VisualTransformation.None
        else
            PasswordVisualTransformation()
    )
}