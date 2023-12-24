package com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashapovrush.cofeeshopstest.R
import com.kashapovrush.cofeeshopstest.navigation.NavigationState
import com.kashapovrush.cofeeshopstest.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeShopsScreen(
    navigationState: NavigationState
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            Column {
                LazyColumn(
                    modifier = Modifier
                        .padding(it)
                        .weight(1f)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    items(20) {


                        CoffeeShopItem()


                    }
                }
                Box(
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 8.dp,
                            bottom = 4.dp
                        )
                ) {
                    Button(
                        onClick = {
                                  navigationState.navigateTo(Screen.MenuScreen.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    ) {
                        Text(
                            text = "На карте",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                        )
                    }
                }
            }

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
                            text = stringResource(R.string.near_cofee_shops),
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
fun CoffeeShopItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            ),
            shape = RoundedCornerShape(2.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "CoffeeLike",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "2 км от вас",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .alpha(0.5f)
            )
            Spacer(modifier = Modifier.height(8.dp))

        }
    }


}
