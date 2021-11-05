package com.example.compose.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.compose.R

@Composable
fun OutlinedButtonComponent() {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.cyan_700).copy(
                alpha = .3f
            )
        ),
        onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, Color.Red),
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = stringResource(id = R.string.str_following),
            style = MaterialTheme.typography.h6.copy(
                color = Color.White
            )
        )
    }
}