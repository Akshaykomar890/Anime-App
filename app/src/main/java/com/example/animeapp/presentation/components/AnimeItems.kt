package com.example.animeapp.presentation.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material.icons.rounded.StarRate
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.animeapp.AnimeData.domain.model.AnimeList
import com.example.animeapp.AnimeData.util.Screen


@Composable
fun AnimeItems(
    navController: NavHostController,
    animeList: AnimeList,
) {


    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(animeList.attributes.posterImage.large)
            .size(Size.ORIGINAL)
            .build()
    ).state


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.outlineVariant)
            .clickable {
                navController.navigate(Screen.Details.route + "/${animeList.id}")
            }

    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .padding(start = 11.dp, top = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color.White),

        ) {
            if( imageState is AsyncImagePainter.State.Error){
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = Icons.Rounded.ImageNotSupported, contentDescription = null
                )
            }

            if(imageState is AsyncImagePainter.State.Loading){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            if(imageState is AsyncImagePainter.State.Success){
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    painter = imageState.painter , contentDescription = animeList.attributes.titles.en
                )
            }
        }

        Column(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = MaterialTheme.colorScheme.secondaryContainer)
            )
            {
                Icon(imageVector = Icons.Rounded.StarRate, contentDescription = null, tint = Color.Yellow)
                Text(
                    modifier = Modifier.padding(end = 5.dp),
                    text = animeList.attributes.averageRating,
                    fontWeight = FontWeight.SemiBold
                )

            }
            Spacer(modifier = Modifier.height(5.dp))
            
            Text(
                text = animeList.attributes.canonicalTitle,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = animeList.attributes.synopsis,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        }

    }

}
