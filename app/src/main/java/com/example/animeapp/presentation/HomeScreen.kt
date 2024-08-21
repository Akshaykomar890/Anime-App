package com.example.animeapp.presentation



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.animeapp.AnimeData.data.presentation.AnimeViewModel
import com.example.animeapp.presentation.components.AnimeItems
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {

    val viewModel = hiltViewModel<AnimeViewModel>()

    val animeState = viewModel.animeListState.collectAsState().value

    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.View)

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.inverseSurface,
                ),
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Trending Anime"
                    )
                }
            )
        }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ){
            if (animeState.isLoading) {
                LazyColumn {
                    items(20) { index ->
                        ShimmerItem(shimmerInstance)
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(5.dp)
                ) {
                    items(animeState.animeList.size) { index ->
                       AnimeItems(navController = navController,
                           animeList = animeState.animeList[index],
                       )
                    }
                }
            }

        }

    }

}


@Composable
fun ShimmerItem(shimmerInstance: Shimmer) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(100.dp)
            .padding(start = 11.dp, top = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .shimmer(shimmerInstance)
            .background(color = Color(0xFFC2C2C2))
        ){
        }
        Spacer(modifier = Modifier.width(5.dp))

        Column {
            Text(
                modifier = Modifier
                    .height(18.dp)
                    .width(100.dp)
                    .shimmer(shimmerInstance)
                    .background(color = Color(0xFFC2C2C2)),
                text = ""
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier
                    .height(18.dp)
                    .width(150.dp)
                    .shimmer(shimmerInstance)
                    .background(color = Color(0xFFC2C2C2)),
                text = ""
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier
                    .height(18.dp)
                    .width(180.dp)
                    .shimmer(shimmerInstance)
                    .background(color = Color(0xFFC2C2C2)),
                text = ""
            )
        }
    }

}
