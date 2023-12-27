package com.kashapovrush.coffeeshops.presentation

import android.app.Application
import com.kashapovrush.coffeeshops.di.ApplicationComponent
import com.kashapovrush.coffeeshops.di.DaggerApplicationComponent

class CoffeeShopsApplication: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this, this)
    }
}