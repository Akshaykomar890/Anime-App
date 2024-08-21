package com.example.animeapp.presentation.detailScreen.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material.icons.rounded.StarRate
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.animeapp.presentation.detailScreen.DetailsViewModel


@Composable
fun DetailsScreen(){
        
    
    val detailsViewModel = hiltViewModel<DetailsViewModel>()
    
    val animeState = detailsViewModel.animeState.collectAsState().value



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
    ) {

        val imageState = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(animeState.animeId?.attributes?.coverImage?.original)
                .size(Size.ORIGINAL)
                .build()
        ).state


        Box (
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)),
            contentAlignment = Alignment.Center
        ){
            if (imageState is AsyncImagePainter.State.Error){
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                        .align(Alignment.Center),
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
                    modifier = Modifier.fillMaxSize(),
                    painter = imageState.painter,
                    contentDescription = animeState.animeId?.attributes?.canonicalTitle,
                    contentScale = ContentScale.Crop
                )

            }
        }

        Spacer(modifier = Modifier.height(15.dp))


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = animeState.animeId?.attributes?.canonicalTitle.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Row {
                Icon(imageVector = Icons.Rounded.StarRate, contentDescription = null, tint = Color.Yellow)
                Text(
                    modifier = Modifier.padding(end = 5.dp),
                    text = animeState.animeId?.attributes?.averageRating.toString(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
            }

        }


        Spacer(modifier = Modifier.height(20.dp))


        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = "Synopsis",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )




        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            text = animeState.animeId?.attributes?.synopsis.toString() ,
            textAlign = TextAlign.Justify
        )

    }


}