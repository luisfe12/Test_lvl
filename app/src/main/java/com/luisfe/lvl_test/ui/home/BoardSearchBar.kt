package com.luisfe.lvl_test.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChecklistRtl
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.luisfe.lvl_test.ui.theme.GreyJiraTextfield
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun BoardSearchBar(
    value: String,
    onChangeText: (String) -> Unit,
    onShowDialogSearch: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onChangeText(it)
        },
        label = {
            Text(text = "Buscar en tableros")
        },
        placeholder = {
            Text(text = "Buscar en tableros")
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = GreyJiraTextfield,
            focusedPlaceholderColor = Color.Transparent,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedBorderColor = colorJira,
            focusedLabelColor = colorJira

        ),
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = "icono de la lupa", tint = colorJira)
        },
        trailingIcon = {
            IconButton(onClick = { onShowDialogSearch() }) {
                Icon(imageVector = Icons.Outlined.ChecklistRtl, contentDescription = "icono que abre dialogo",tint = colorJira)
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}