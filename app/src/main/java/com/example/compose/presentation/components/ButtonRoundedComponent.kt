package com.example.compose.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ButtonRoundedComponent(
    modifier: Modifier,
    backgroundColor: Color,
    textLabel: String,
    textColor: Color
) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        onClick = { /*T. ODO*/ },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Text(
            text = textLabel,
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.Medium,
                color = textColor
            )
        )
    }

}