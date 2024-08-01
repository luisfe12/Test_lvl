package com.luisfe.lvl_test.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.luisfe.lvl_test.data.model.ResponseProductsItem
import com.luisfe.lvl_test.ui.theme.BackGroundPriceItem
import com.luisfe.lvl_test.ui.theme.CardHomeColor
import com.luisfe.lvl_test.ui.theme.GreyJira
import com.luisfe.lvl_test.ui.theme.ItemImageBackgorund
import org.w3c.dom.Text

@Composable
fun LazyColumnHome(listProducts: List<ResponseProductsItem>, searchProduct:String) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
    ) {
        val newSearchList = listProducts.filter { productSearch ->
            productSearch.title.contains(searchProduct, ignoreCase = true)
        }
        items(newSearchList) { product ->
            ItemCardLazyColumn(item = product)
        }
    }
}


@Composable
fun ItemCardLazyColumn(item: ResponseProductsItem) {
    Card(
        modifier = Modifier
            .size(250.dp)
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(
            12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = CardHomeColor
        ),
        shape = RoundedCornerShape(
            topStart = 10.dp,
            topEnd = 20.dp,
            bottomStart = 10.dp,
            bottomEnd = 10.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, shape = RoundedCornerShape(topEnd = 80.dp)),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .size(85.dp)
                    .padding(15.dp)
                    .background(color = ItemImageBackgorund, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = item.images[0],
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)

                )
            }

            Text(
                text = item.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Text(
                text = item.category.name,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = GreyJira,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Text(
                text = item.price.toString()+" soles",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .background(color = BackGroundPriceItem)

            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}