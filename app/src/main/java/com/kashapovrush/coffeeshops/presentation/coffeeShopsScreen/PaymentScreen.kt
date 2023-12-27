package com.kashapovrush.coffeeshops.presentation.coffeeShopsScreen

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kashapovrush.coffeeshops.R
import com.kashapovrush.coffeeshops.domain.Payment
import com.kashapovrush.coffeeshops.presentation.ViewModelFactory
import com.kashapovrush.coffeeshops.presentation.customView.MinusEnabled
import com.kashapovrush.coffeeshops.presentation.customView.PlusEnabled
import com.kashapovrush.coffeeshops.ui.theme.BrownColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    viewModelFactory: ViewModelFactory,
    lifecycleOwner: LifecycleOwner,
    shop: Int,
    token: String,
    payment: Payment,
    onBackPressed: () -> Unit
) {

    val viewModel: LocationViewModel = viewModel(factory = viewModelFactory)
    viewModel.getMenu(shop, "Bearer $token")
    val items = viewModel.stateMenu.observeAsState(initial = MenuState.Initial)
    val currentState = items.value

    var new = mutableListOf<Payment>()
    val emptyItems = remember {
        mutableStateOf(true)
    }

    viewModel.paymentList.observe(lifecycleOwner) { list ->
        new = list.toMutableList().apply {
            removeIf { it.count == 0 }
        }
    }

    if (currentState is MenuState.MenuItem) {
        Scaffold(
            content = {
                Column  {
                    LazyColumn(
                        modifier = Modifier
                            .padding(it)
                            .weight(1f)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        items(items = currentState.items, key = {it.id} ) {
                            new.forEachIndexed { index, payment ->
                                if (new[index].id == it.id) {
                                        Item(new[index])
                                        emptyItems.value = false
                                }
                            }


                        }

                        
                            item {
                                
                                if (!emptyItems.value) {
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
                                } else {
                                    Box (modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center){
                                        Text(text = "Пусто")
                                    }

                                }
                                
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
                    shape = RoundedCornerShape(0.dp)
                )

                {
                    Card(
                        shape = RoundedCornerShape(0.dp),
                        colors = CardDefaults.cardColors(
                            disabledContainerColor = MaterialTheme.colorScheme.surface,
                            containerColor = MaterialTheme.colorScheme.surface
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
                                    modifier = Modifier
                                        .padding(start = 16.dp)
                                        .clickable {
                                            onBackPressed()
                                        }
                                )
                            },
                            modifier = Modifier.clip(RoundedCornerShape(0.dp)),
                        )
                    }

                }

            },
            modifier = Modifier.fillMaxSize()
        )
    }


}

@Composable
fun Item(
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
                            text = payment.name,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "${payment.price * count.value} руб",
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


