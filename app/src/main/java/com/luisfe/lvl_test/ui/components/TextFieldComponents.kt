package com.luisfe.lvl_test.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.luisfe.lvl_test.ui.theme.GreyJiraTextfield
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun TextFieldUserComponent(
    email:String,
    onTextCahnge:(String) -> Unit
) {
    OutlinedTextField(
        value = email,
        onValueChange = {
            onTextCahnge(it)
        },
        label = {
            Text(text = "Correo electrónico")
        },
        placeholder = {
            Text(text = "Correo electrónico")
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorJira,
            unfocusedBorderColor = GreyJiraTextfield,
            focusedLabelColor = colorJira,
            unfocusedLabelColor = colorJira,
            focusedPlaceholderColor = Color.Transparent,
            unfocusedPlaceholderColor = colorJira
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Default
        ),
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun TextFieldPasswordComponent(
    password:String,
    onTextCahnge:(String) -> Unit
) {
    var isVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = password,
        onValueChange = {
            onTextCahnge(it)
        },
        label = {
            Text(text = "Contraseña")
        },
        placeholder = {
            Text(text = "Contraseña")
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorJira,
            unfocusedBorderColor = GreyJiraTextfield,
            focusedLabelColor = colorJira,
            unfocusedLabelColor = colorJira,
            focusedPlaceholderColor = Color.Transparent,
            unfocusedPlaceholderColor = colorJira
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Default
        ),
        trailingIcon = {

            val icon = if (isVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(
                    imageVector = icon,
                    contentDescription = "icono para ver la contraseña",
                    tint = colorJira
                )
            }
        },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}