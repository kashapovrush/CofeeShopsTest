package com.kashapovrush.coffeeshops.presentation.coffeeShopsScreen

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kashapovrush.coffeeshops.R
import com.kashapovrush.coffeeshops.data.model.LocationDto
import com.kashapovrush.coffeeshops.navigation.NavigationState
import com.kashapovrush.coffeeshops.presentation.ViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeShopsScreen(
    navigationState: NavigationState,
    viewModelFactory: ViewModelFactory,
    token: String,
    onBackPressed: () -> Unit
) {


    val viewModel: LocationViewModel = viewModel(factory = viewModelFactory)
    viewModel.getLocations("Bearer $token")
    val screenState = viewModel.stateListLocation.observeAsState(initial = LocationsState.Initial)
    val currentState = screenState.value

    if (currentState is LocationsState.CoffeeShops) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = {
                Column {

                    LazyColumn(
                        modifier = Modifier
                            .padding(it)
                            .weight(1f)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                    ) {
                        items(
                            items = currentState.locations, key = { it.id }
                        ) {location ->
                            CoffeeShopItem(text = location) {
                                navigationState.navigateToMenu(location.id, token)
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
                            )
                    ) {
                        Button(
                            onClick = {

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
fun CoffeeShopItem(
    text: LocationDto,
    navigateToMenu: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navigateToMenu(text.id)
            }
            .padding(start = 8.dp, end = 8.dp),
        contentAlignment = Alignment.Center
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
            shape = RoundedCornerShape(2.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = text.name,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }


}
