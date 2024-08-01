package com.luisfe.lvl_test.ui.peofilephoto

import android.app.Activity
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.activity.result.contract.ActivityResultContracts.TakePicture
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.luisfe.lvl_test.navigation.Routes

@Composable
fun ProfilePhotoScreen(
    navController: NavHostController,
    activity: Activity
) {

    var uri: Uri? by remember {
        mutableStateOf(null)
    }

    val cameraLauncher = rememberLauncherForActivityResult(contract = TakePicture()) {
        if (it && uri?.path?.isNotEmpty() == true) {
            //viewModel.uploadBasicImage(uri!!) //todo solo sube la foto
//            viewModel.uploadAndDownloadImage(uri = uri!!) //todo sube y descarga la imagen de firebase
//            viewModel.changeNameImage("")
        }
    }

    val galleryLauncher = rememberLauncherForActivityResult(contract = GetContent()) { uri ->
        uri?.let {
            //viewModel.uploadBasicImage(it) //todo solo sube la imagen de galeria
//            viewModel.uploadAndDownloadImage(it) //todo sube y descarga la imagen de firebase
        }
    }

    var selectedItemSecond by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black
            ) {
                bottom_actions.forEachIndexed { index, bottom ->
                    NavigationBarItem(
                        selected = selectedItemSecond == index,
                        onClick = {
                            selectedItemSecond = index
                            selectedOptionBottomBar(
                                index = index,
                                cameraLaunchAction = {
                                    uri = generateUri(activity = activity, "hola")
                                    cameraLauncher.launch(uri!!)
                                },
                                galleryLaunchAction = {
                                    galleryLauncher.launch("image/*")
                                }
                            )
//                            selectedIconsBottomCot(
//                                index = selectedItemSecond,
//                                bottomBarViewModel = bottomBarViewModel,
//                                navController = navController,
//                                currentScreen = currentScreeen
//                            )
                        },
                        icon = {
                            //IconBottomBarFieldQuote(index = index, bottom = bottom)
                            Icon(
                                imageVector = bottom.icon,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.height(20.dp)
                            )
                        },
                        label = {
                            Text(
                                text = bottom.labelBtn,
                                modifier = Modifier.wrapContentHeight(),
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        },
                    )
                }

            }
        },
        containerColor = Color.Black
    ) { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(2f))
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(color = Color.White),
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .clickable {
                        navController.navigate(Routes.ProfilePhoto.routes)
                    },
            )
            Spacer(modifier = Modifier.weight(1f))
            HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.White)
        }

    }
}
