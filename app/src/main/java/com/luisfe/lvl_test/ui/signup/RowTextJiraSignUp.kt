package com.luisfe.lvl_test.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun RowTextJiraSignUp(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "en ", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "JIRA Atllassia",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorJira
        )
        Text(text = "!", fontSize = 25.sp, fontWeight = FontWeight.Bold)
    }
}