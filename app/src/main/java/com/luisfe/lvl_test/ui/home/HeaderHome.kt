package com.luisfe.lvl_test.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luisfe.lvl_test.ui.theme.GreyJira
import com.luisfe.lvl_test.ui.theme.GreyJiraTextfield
import com.luisfe.lvl_test.ui.theme.colorJira
import dagger.Provides

@Composable
fun HeaderHome(navigateToProfile:() -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp).clickable {
                navigateToProfile()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = CircleShape
                ),
        )
        ColumnNameUser(
            userName = "Pedrito del pedral",
            userCharge = "el jefe de todos",
            modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier
                .clip(CircleShape)
                .size(30.dp)
                .border(
                    width = 2.dp,
                    color = GreyJiraTextfield,
                    shape = CircleShape
                ),
            imageVector = Icons.Outlined.Notifications, contentDescription = "icono de notificacion",
            tint = colorJira
        )

    }
}


@Composable
fun ColumnNameUser(userName: String, userCharge: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = userName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(
            text = userCharge,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = GreyJira
        )
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewHeaderHome(){
//    HeaderHome()
//}
