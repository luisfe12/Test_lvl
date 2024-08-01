package com.luisfe.lvl_test.ui.newitem

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.luisfe.lvl_test.ui.theme.GreyJira
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun RowSwitchOptionNewProject() {
    var checked by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Compartir con otro miembros?", color = GreyJira, fontSize = 17.sp)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = colorJira,
                checkedTrackColor = colorJira
            )
        )
        
    }
}