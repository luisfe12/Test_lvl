package com.luisfe.lvl_test.ui.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun ButtonLogin(
    onClickLogin:() -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorJira
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = { onClickLogin() }) {

        Text(text = "Iniciar Sesión", fontSize = 19.sp, modifier = Modifier.padding(vertical = 10.dp))
    }
}