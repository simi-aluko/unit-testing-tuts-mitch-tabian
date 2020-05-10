package com.simileoluwaaluko.unittesting.di

import android.app.Application
import com.simileoluwaaluko.unittesting.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * Created by Simileoluwa Aluko on 2020-05-05.
 */

@Component(
    modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuildersModule::class,
    ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application : Application) : Builder

        fun build() : AppComponent
    }
}