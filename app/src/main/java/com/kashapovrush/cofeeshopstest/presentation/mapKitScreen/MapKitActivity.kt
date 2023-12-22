package com.kashapovrush.cofeeshopstest.presentation.mapKitScreen


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kashapovrush.cofeeshopstest.R
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView

class MapKitActivity : AppCompatActivity() {

    private lateinit var mapKit: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("bc643812-32f4-442b-a714-c5539de24d89")
        setContentView(R.layout.activity_map_kit)

        MapKitFactory.initialize(this)
        mapKit = findViewById(R.id.mapview)



    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()

        mapKit.onStart()
    }
}