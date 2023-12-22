package com.kashapovrush.cofeeshopstest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.kashapovrush.cofeeshopstest.ui.theme.CofeeShopsTestTheme
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey("bc643812-32f4-442b-a714-c5539de24d89")
        MapKitFactory.initialize(this)
        setContent {
            CofeeShopsTestTheme {



                MapKitFactory.getInstance().onStart()
                MapView.
            }
        }
    }

}
@Composable
fun MapView() {

}
