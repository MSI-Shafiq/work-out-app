package com.application.dsvfitness.di.main;

import androidx.lifecycle.ViewModel;

import com.application.dsvfitness.di.ViewModelKey;
import com.application.dsvfitness.viewmodels.LoginViewModel;
import com.application.dsvfitness.viewmodels.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel viewModel);
}