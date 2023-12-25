package com.kashapovrush.cofeeshopstest.presentation.paymentScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kashapovrush.cofeeshopstest.R
import com.kashapovrush.cofeeshopstest.data.model.Menu
import com.kashapovrush.cofeeshopstest.domain.Payment
import com.kashapovrush.cofeeshopstest.presentation.ViewModelFactory
import com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen.LocationViewModel
import com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen.MenuState
import com.kashapovrush.cofeeshopstest.presentation.customView.MinusEnabled
import com.kashapovrush.cofeeshopstest.presentation.customView.PlusEnabled
import com.kashapovrush.cofeeshopstest.ui.theme.BrownColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    viewModelFactory: ViewModelFactory,
    shop: Int,
    token: String,
    payment: Payment
) {

    val viewModel: LocationViewModel = viewModel(factory = viewModelFactory)
    viewModel.getMenu(shop, "Bearer $token")
    val items = viewModel.stateMenu.observeAsState(initial = MenuState.Initial)
    val currentState = items.value

    if (currentState is MenuState.MenuItem) {
        Scaffold(
            content = {
                Column {
                    LazyColumn(
                        modifier = Modifier
                            .padding(it)
//                            .weight(1f)
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        items(count = 1) {
                            currentState.items.forEachIndexed { index, menu ->
                                if (menu.id == payment.id) {
                                    Item(menu, payment)
                                }
                            }

                        }

                        item {
                            Spacer(modifier = Modifier.height(48.dp))
                            Text(
                                text = "Время ожидания заказа",
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 24.sp,
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 20.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            Text(
                                text = "15 мин!",
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 24.sp,
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 20.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            Text(
                                text = "Спасибо, что выбрали нас!",
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 24.sp,
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 20.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(48.dp))
                        }

                    }



                    Box(
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp,
                                top = 8.dp,
                                bottom = 4.dp
                            ),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                        ) {
                            Text(
                                text = "Оплатить",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                            )
                        }
                    }


                }


            },
            topBar = {
                Card(
                    colors = CardDefaults.cardColors(disabledContainerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(0.dp),
//                modifier = Modifier.padding(start = 16.dp)
                )

                {
                    Card(
                        shape = RoundedCornerShape(0.dp),
                        colors = CardDefaults.cardColors(
                            disabledContainerColor = MaterialTheme.colorScheme.surface,
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        )
                    ) {

                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.surface),
                            title = {
                                Text(
                                    text = "Ваш заказ",
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
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                            },
                            modifier = Modifier.clip(RoundedCornerShape(0.dp)),
                        )
                    }

                }

            }
        )
    }


}

@Composable
fun Item(
    menu: Menu,
    payment: Payment
) {

    val count = remember {
        mutableIntStateOf(payment.count)
    }

    val enabledMinus = remember {
        mutableStateOf(false)
    }

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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.weight(1f)
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = menu.name,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "${menu.price * count.value} руб",
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .alpha(0.5f)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }


                Spacer(modifier = Modifier.width(24.dp))
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
                    MinusEnabled()

                }
                Spacer(modifier = Modifier.width(18.dp))
                Box(modifier = Modifier.padding(2.dp)) {
                    Text(text = count.value.toString(), color = BrownColor, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.width(18.dp))
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(10.dp)
                        .padding(2.dp)
                        .size(10.dp)
                        .clickable {
                            enabledMinus.value = true
                            count.value++
                        }
                ) {
                    PlusEnabled()
                }
                Spacer(modifier = Modifier.width(12.dp))

            }


        }


    }
}


