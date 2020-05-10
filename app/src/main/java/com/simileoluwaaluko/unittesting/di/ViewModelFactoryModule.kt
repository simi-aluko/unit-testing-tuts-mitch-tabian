package com.simileoluwaaluko.unittesting.di

import androidx.lifecycle.ViewModelProvider
import com.simileoluwaaluko.unittesting.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelProviderFactory : ViewModelProviderFactory) :  ViewModelProvider.Factory

}