package com.kashapovrush.cofeeshopstest.presentation.menuScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashapovrush.cofeeshopstest.R
import com.kashapovrush.cofeeshopstest.presentation.customView.MinusEnabled
import com.kashapovrush.cofeeshopstest.presentation.customView.PlusEnabled

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen() {
    val scrollState = rememberLazyGridState()



    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(it),
                content = {
                    items(10) {
                        MenuCard()
                    }

                    item (span = {
                        GridItemSpan(2)
                    },
                        content = {
                                Box(
                                    modifier = Modifier.padding(
                                        start = 8.dp,
                                        end = 8.dp,
                                        top = 8.dp,
                                        bottom = 4.dp
                                    )
                                ) {
                                    Button(
                                        onClick = { },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .wrapContentHeight(),
                                    ) {
                                        Text(
                                            text = "Перейти к оплате",
                                            fontSize = 18.sp,
                                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                                        )
                                    }
                                }


                        })


                },
                state = scrollState
            )


        },
        topBar = {
            Card(
                colors = CardDefaults.cardColors(
                    disabledContainerColor = MaterialTheme.colorScheme.surface,
                    containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier.padding(start = 16.dp)
            )

            {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.surface),
                    title = {
                        Text(
                            text = stringResource(R.string.menu_coffee),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    },
                    navigationIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_button),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    modifier = Modifier.clip(RoundedCornerShape(0.dp))
                )
            }

        }
    )

}

@Composable
fun MenuCard() {
    Box(modifier = Modifier.padding(8.dp)) {
        Card(
            colors = CardDefaults.cardColors(
                disabledContainerColor = MaterialTheme.colorScheme.background,
                containerColor = MaterialTheme.colorScheme.background

            ),
            shape = RoundedCornerShape(4.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_coffee_item),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Эспрессо", modifier = Modifier.padding(start = 8.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Text(
                    text = "200 руб",
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(32.dp))
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(10.dp)
                ) {
                    MinusEnabled()
                }
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.padding(2.dp)) {
                    Text(text = "2")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(10.dp)
                ) {
                    PlusEnabled()
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
