package com.luisfe.lvl_test.ui.newitem

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun RowChangeIconProject() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center,

            ) {

            Icon(
                imageVector = Icons.Default.Cloud,
                contentDescription = "incono por defecto",
                tint = Color.Green
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Cambiar icono aleatorio")
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "icono que genera otro icono",
                tint = colorJira
            )
        }

    }
}