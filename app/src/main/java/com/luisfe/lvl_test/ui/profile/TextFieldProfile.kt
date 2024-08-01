package com.luisfe.lvl_test.ui.profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
fun TextFieldNameProfile(
    name:String,
    onTextChange:(String) -> Unit
) {
    OutlinedTextField(
        value = name,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Nombres")
        },
        placeholder = {
            Text(text = "Nombres")
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
fun TextFieldLastNameProfile(
    name:String,
    onTextChange:(String) -> Unit
) {
    OutlinedTextField(
        value = name,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Apellidos")
        },
        placeholder = {
            Text(text = "Apellidos")
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
fun TextFieldNameEnterpriceProfile(
    nameE:String,
    onTextChange:(String) -> Unit
) {
    OutlinedTextField(
        value = nameE,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Nombre de empresa")
        },
        placeholder = {
            Text(text = "Nombre de empresa")
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
fun TextFieldChargeEnterpriceProfile(
    chargeE:String,
    onTextChange:(String) -> Unit
) {
    OutlinedTextField(
        value = chargeE,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Cargo en la empresa")
        },
        placeholder = {
            Text(text = "Cargo en la empresa")
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
fun TextFieldPhoneProfile(
    phone:String,
    onTextChange:(String) -> Unit
) {
    OutlinedTextField(
        value = phone,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Telefono")
        },
        placeholder = {
            Text(text = "Telefono")
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
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Default
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextFieldEmailProfile(
    email:String,
    onTextChange:(String) -> Unit
) {
    OutlinedTextField(
        value = email,
        onValueChange = {
            onTextChange(it)
        },
        label = {
            Text(text = "Correo electronico")
        },
        placeholder = {
            Text(text = "Correo electronico")
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
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Default
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

