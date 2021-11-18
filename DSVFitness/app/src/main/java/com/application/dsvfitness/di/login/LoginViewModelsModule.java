package com.application.dsvfitness.di.login;

import androidx.lifecycle.ViewModel;

import com.application.dsvfitness.di.ViewModelKey;
import com.application.dsvfitness.viewmodels.LoginViewModel;
import com.application.dsvfitness.viewmodels.SignupViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class LoginViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel viewModel);
}