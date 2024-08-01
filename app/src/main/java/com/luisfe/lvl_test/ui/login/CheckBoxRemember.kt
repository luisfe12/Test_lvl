package com.luisfe.lvl_test.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun CheckBoxRemenber() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = true,
            onCheckedChange = {},
            colors = CheckboxDefaults.colors(
                checkedColor = colorJira
            )
        )
        Text(text = "Recorddarme", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Olvide mi contraseña", fontWeight = FontWeight.SemiBold, color = colorJira)
    }
}