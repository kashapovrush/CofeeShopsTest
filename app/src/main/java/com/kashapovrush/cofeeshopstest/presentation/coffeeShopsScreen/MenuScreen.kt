package com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.kashapovrush.cofeeshopstest.R
import com.kashapovrush.cofeeshopstest.data.model.Menu
import com.kashapovrush.cofeeshopstest.domain.Payment
import com.kashapovrush.cofeeshopstest.navigation.NavigationState
import com.kashapovrush.cofeeshopstest.navigation.Screen
import com.kashapovrush.cofeeshopstest.presentation.ViewModelFactory
import com.kashapovrush.cofeeshopstest.presentation.customView.MinusDisabled
import com.kashapovrush.cofeeshopstest.presentation.customView.MinusEnabled
import com.kashapovrush.cofeeshopstest.presentation.customView.PlusEnabled

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    navigationState: NavigationState,
    viewModelFactory: ViewModelFactory,
    token: String,
    shop: Int,
    onBackPressed: () -> Unit
) {
    val scrollState = rememberLazyGridState()

    val viewModel: LocationViewModel = viewModel(factory = viewModelFactory)
    val stateMenu = viewModel.stateMenu.observeAsState(MenuState.Initial)
    val currentState = stateMenu.value
    viewModel.getMenu(shop, "Bearer $token")



    if (currentState is MenuState.MenuItem) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = { paddingValues ->

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(paddingValues),
                    content = {
                        items(items = currentState.items, key = { it.id }) { menu ->
                            val payment = MenuCard(menu)
                            viewModel.addPaymentItem(payment)
                        }

                        item(span = {
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
                                        onClick = {
                                            navigationState.navigateToPayment(
                                                shop,
                                                token,
                                                Payment(0, "", 0, 0)
                                            )

                                        },
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
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
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
                                tint = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.clickable {
                                    onBackPressed()
                                }
                            )
                        },
                        modifier = Modifier.clip(RoundedCornerShape(0.dp))
                    )
                }
            }
        )
    }
}

@Composable
fun MenuCard(
    menu: Menu
): Payment {

    var list = mutableListOf<Payment>()

    val count = remember {
        mutableIntStateOf(0)
    }

    val enabledMinus = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
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
            AsyncImage(
                model = menu.imageUrl, contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(170.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = menu.name, modifier = Modifier.padding(start = 8.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Text(
                    text = "${menu.price} руб",
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(10.dp)
                        .clickable {
                            if (count.value >= 1) {
                                count.value -= 1
                                if (count.value < 1) {
                                    enabledMinus.value = false
                                }
                            }
                        }
                ) {
                    if (enabledMinus.value) {
                        MinusEnabled()
                    } else {
                        MinusDisabled()
                    }

                }
                Spacer(modifier = Modifier.width(14.dp))
                Box(modifier = Modifier.padding(2.dp)) {
                    Text(text = count.value.toString())
                }
                Spacer(modifier = Modifier.width(14.dp))
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(10.dp)
                        .clickable {
                            enabledMinus.value = true
                            count.value++
                        }
                ) {
                    PlusEnabled()
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }

    return Payment(id = menu.id, count = count.value, name = menu.name, price = menu.price)
}
