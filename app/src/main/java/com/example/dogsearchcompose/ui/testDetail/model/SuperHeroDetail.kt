package com.example.dogsearchcompose.ui.testDetail.model

import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.dogsearchcompose.R
import com.example.dogsearchcompose.ui.testDetail.model.viewmodel.HeroViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun SuperHeroDetail(viewModel: HeroViewModel = hiltViewModel()) {
    val hero by viewModel.heroo.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = hero.image.url),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp), contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 300.dp, start = 1.dp, end = 1.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
            shape = RoundedCornerShape(42.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = hero.name,
                    fontSize = 42.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )

                Text(
                    text = hero.biography.fullName,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )

                Text(
                    text = hero.biography.publisher,
                    fontSize = 8.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Color.White

                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(
                                        hero.powerStats.intelligence
                                            .toInt()
                                            .plus(100).dp
                                    )
                                    .background(colorResource(id = R.color.superhero_stat_intelligence))
                            )
                            Text(text = stringResource(id = R.string.Intelligence), fontSize = 10.sp)
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(
                                        hero.powerStats.strength
                                            .toInt()
                                            .plus(100).dp
                                    )
                                    .background(colorResource(id = R.color.superhero_stat_strength))
                            )
                            Text(text = stringResource(id = R.string.Strength) , fontSize = 10.sp)
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(
                                        hero.powerStats.speed
                                            .toInt()
                                            .plus(100).dp
                                    )
                                    .background(colorResource(id = R.color.superhero_stat_speed))
                            )
                            Text(text = stringResource(id = R.string.Speed), fontSize = 10.sp)
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(
                                        hero.powerStats.durability
                                            .toInt()
                                            .plus(100).dp
                                    )
                                    .background(colorResource(id = R.color.superhero_stat_durability))
                            )
                            Text(text = stringResource(id = R.string.Durability), fontSize = 10.sp)
                        }
                    }
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(
                                        hero.powerStats.power
                                            .toInt()
                                            .plus(100).dp
                                    )
                                    .background(colorResource(id = R.color.superhero_stat_power))
                            )
                            Text(text = stringResource(id = R.string.Power), fontSize = 10.sp)
                        }
                    }
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(
                                        hero.powerStats.combat
                                            .toInt()
                                            .plus(100).dp
                                    )
                                    .background(colorResource(id = R.color.superhero_stat_combat))
                            )
                            Text(text = stringResource(id = R.string.Combat), fontSize = 10.sp)
                        }
                    }


                }

                Row {
                    Button(onClick = { /*TODO*/ }) {

                    }
                    Button(onClick = { /*TODO*/ }) {

                    }
                }
            }
        }


    }
}





