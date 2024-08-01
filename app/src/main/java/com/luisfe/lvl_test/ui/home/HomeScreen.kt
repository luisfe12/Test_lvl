package com.luisfe.lvl_test.ui.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.luisfe.lvl_test.navigation.Routes
import com.luisfe.lvl_test.ui.stateclase.StateHomeProducts
import com.luisfe.lvl_test.ui.theme.BackgroundScreens
import com.luisfe.lvl_test.ui.theme.colorJira
import okhttp3.Route

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val searchBarText by homeViewModel.textSearBar.collectAsStateWithLifecycle()
    var showDialogSearch by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundScreens)
            .padding(15.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        HeaderHome(
            navigateToProfile = {
                navController.navigate(Routes.Profile.routes)
            }
        )
        BoardSearchBar(
            value = searchBarText,
            onChangeText = {
                homeViewModel.changeTextSearBar(
                    newValue = it
                )
            },
            onShowDialogSearch = {
                showDialogSearch = true
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Tableros",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(15.dp))
        StateHomeScreen(
            homeViewModel = homeViewModel,
            goToNewProject = {
                navController.navigate(Routes.NewProject.routes)
            },
            modifier = Modifier.weight(1f),
            searchProduct =  searchBarText
        )
    }
}


@Composable
fun StateHomeScreen(
    homeViewModel: HomeViewModel,
    goToNewProject:() ->Unit,
    modifier: Modifier,
    searchProduct: String
) {

    val context = LocalContext.current

    Box(modifier = modifier.fillMaxWidth()) {


        when (val stateHome = homeViewModel.stateProducts) {
            StateHomeProducts.Loading -> {

                CircularProgressIndicator(
                    color = colorJira,
                    modifier = Modifier.align(Alignment.Center)
                )

            }

            is StateHomeProducts.Succes -> {
                if (stateHome.state) {
                    LaunchedEffect(stateHome) {
                        Toast.makeText(context, stateHome.message, Toast.LENGTH_SHORT).show()
                    }
                    LazyColumnHome(
                        listProducts = stateHome.listproducts,
                        searchProduct = searchProduct
                        )
                } else {
                    LaunchedEffect(stateHome) {
                        Toast.makeText(context, stateHome.message, Toast.LENGTH_SHORT).show()
                    }

                    Text(
                        text = "No hay datos",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }

            else -> {

            }
        }


        FloatingActionButton(
            onClick = {
                goToNewProject()
            },
            containerColor = colorJira,
            shape = RoundedCornerShape(7.dp),
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Icono que agrega valores",
                tint = Color.White
            )
        }
    }
}