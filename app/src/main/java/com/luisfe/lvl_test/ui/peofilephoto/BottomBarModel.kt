package com.luisfe.lvl_test.ui.peofilephoto

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraEnhance
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.SendAndArchive
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.outlined.CameraEnhance
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Store
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarModel (
    val icon:ImageVector,
    val labelBtn:String
)


val bottom_actions = listOf(
    BottomBarModel(
        icon = Icons.Outlined.Edit,
        labelBtn = "Editar",
    ),

    BottomBarModel(
        icon = Icons.Outlined.CameraEnhance,
        labelBtn = "Foto",
    ),
    BottomBarModel(
        icon = Icons.Outlined.Store,
        labelBtn = "Galeria",
    ),
    BottomBarModel(
        icon = Icons.Outlined.Delete,
        labelBtn = "Eliminar",
    ),
)