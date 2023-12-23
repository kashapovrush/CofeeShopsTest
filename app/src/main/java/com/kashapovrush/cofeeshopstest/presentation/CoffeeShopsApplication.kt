package com.kashapovrush.cofeeshopstest.presentation

import android.app.Application
import com.kashapovrush.cofeeshopstest.di.ApplicationComponent
import com.kashapovrush.cofeeshopstest.di.DaggerApplicationComponent

class CoffeeShopsApplication: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}