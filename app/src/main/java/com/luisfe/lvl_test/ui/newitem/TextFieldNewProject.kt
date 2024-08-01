package com.luisfe.lvl_test.ui.newitem

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.luisfe.lvl_test.ui.theme.GreyJiraTextfield
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun TextFieldNameNewPoject(
    name: String,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = name,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Nombre del proyecto")
        },
        placeholder = {
            Text(text = "Nombre del proyecto")
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorJira,
            unfocusedBorderColor = GreyJiraTextfield,
            focusedLabelColor = colorJira,
            unfocusedLabelColor = colorJira,
            focusedPlaceholderColor = Color.Transparent,
            unfocusedPlaceholderColor = colorJira,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Default
        ),
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun TextFieldDescriptionNewPoject(
    description: String,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = description,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Descripcion")
        },
        placeholder = {
            Text(text = "Descripcion")
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorJira,
            unfocusedBorderColor = GreyJiraTextfield,
            focusedLabelColor = colorJira,
            unfocusedLabelColor = colorJira,
            focusedPlaceholderColor = Color.Transparent,
            unfocusedPlaceholderColor = colorJira,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Default
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextFieldStateNewPoject(
    state: String,
    onTextChange: (String) -> Unit,
    onIconClick:() -> Unit
) {
    OutlinedTextField(
        value = state,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Estado de projecto")
        },
        placeholder = {
            Text(text = "Estado de projecto")
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorJira,
            unfocusedBorderColor = GreyJiraTextfield,
            focusedLabelColor = colorJira,
            unfocusedLabelColor = colorJira,
            focusedPlaceholderColor = Color.Transparent,
            unfocusedPlaceholderColor = colorJira,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
        ),
        trailingIcon = {
            IconButton(onClick = { onIconClick() }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "icono de estado",
                    tint = colorJira
                )
            }
        },
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Default
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextFieldStateStartDatePoject(
    startD: String,
    onTextChange: (String) -> Unit,
    onIconClick: () -> Unit
) {
    OutlinedTextField(
        value = startD,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Fecha de inicio")
        },
        placeholder = {
            Text(text = "Fecha de inicio")
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorJira,
            unfocusedBorderColor = GreyJiraTextfield,
            focusedLabelColor = colorJira,
            unfocusedLabelColor = colorJira,
            focusedPlaceholderColor = Color.Transparent,
            unfocusedPlaceholderColor = colorJira,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
        ),
        trailingIcon = {
            IconButton(onClick = { onIconClick() }) {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = "icono de calendario",
                    tint = colorJira
                )
            }
        },
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Default
        ),
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun TextFieldStateEndDatePoject(
    endD: String,
    onTextChange: (String) -> Unit,
    onIconClick: () -> Unit
) {
    OutlinedTextField(
        value = endD,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Fecha de finalizacion")
        },
        placeholder = {
            Text(text = "Fecha de finalizacion")
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorJira,
            unfocusedBorderColor = GreyJiraTextfield,
            focusedLabelColor = colorJira,
            unfocusedLabelColor = colorJira,
            focusedPlaceholderColor = Color.Transparent,
            unfocusedPlaceholderColor = colorJira,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
        ),
        trailingIcon = {
            IconButton(onClick = { onIconClick() }) {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = "icono de calendario",
                    tint = colorJira
                )
            }
        },
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Default
        ),
        modifier = Modifier.fillMaxWidth()
    )
}