package com.simileoluwaaluko.unittesting

import com.simileoluwaaluko.unittesting.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 * Created by Simileoluwa Aluko on 2020-05-05.
 */
class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}