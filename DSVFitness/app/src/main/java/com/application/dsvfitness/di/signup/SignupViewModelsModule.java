package com.application.dsvfitness.di.signup;

import androidx.lifecycle.ViewModel;
import com.application.dsvfitness.di.ViewModelKey;
import com.application.dsvfitness.viewmodels.SignupViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class SignupViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignupViewModel.class)
    public abstract ViewModel bindSignupViewModel(SignupViewModel viewModel);
}