package com.kashapovrush.cofeeshopstest.presentation.paymentScreen

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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashapovrush.cofeeshopstest.R
import com.kashapovrush.cofeeshopstest.presentation.customView.MinusEnabled
import com.kashapovrush.cofeeshopstest.presentation.customView.PlusEnabled
import com.kashapovrush.cofeeshopstest.ui.theme.BrownColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen() {

    Scaffold(
//        modifier = Modifier.fillMaxSize(),
        content = {
            Column {
                LazyColumn(
                    modifier = Modifier
                        .padding(it)
                        .weight(1f)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Top,
                ) {
                    items(10) {
                        Item()
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
                        )
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
                        containerColor = MaterialTheme.colorScheme.surface),
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

@Composable
fun Item() {
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
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Капучино",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "200 руб",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .alpha(0.5f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Spacer(modifier = Modifier.width(128.dp))
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(10.dp)
                ) {
                    MinusEnabled()
                }
                Spacer(modifier = Modifier.width(20.dp))
                Box(modifier = Modifier.padding(2.dp)) {
                    Text(text = "2", color = BrownColor, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.width(18.dp))
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(10.dp)
                ) {
                    PlusEnabled()
                }
            }
            Spacer(modifier = Modifier.width(8.dp))


        }


    }
}


