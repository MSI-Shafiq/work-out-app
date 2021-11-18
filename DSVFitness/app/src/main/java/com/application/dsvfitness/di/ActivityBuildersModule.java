package com.application.dsvfitness.di;


import com.application.dsvfitness.BaseActivity;
import com.application.dsvfitness.di.login.LoginScope;
import com.application.dsvfitness.di.login.LoginViewModelsModule;
import com.application.dsvfitness.di.main.MainModule;
import com.application.dsvfitness.di.main.MainScope;
import com.application.dsvfitness.di.main.MainViewModelsModule;
import com.application.dsvfitness.di.signup.SignupScope;
import com.application.dsvfitness.di.signup.SignupViewModelsModule;
import com.application.dsvfitness.ui.activities.ExerciseDetailsActivity;
import com.application.dsvfitness.ui.activities.LoginActivity;
import com.application.dsvfitness.ui.activities.MainActivity;
import com.application.dsvfitness.ui.activities.SignupActivity;
import com.application.dsvfitness.ui.activities.SplashScreenActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @SignupScope
    @ContributesAndroidInjector(
            modules = {SignupViewModelsModule.class})
    abstract SignupActivity contributeSignupActivity();

    @LoginScope
    @ContributesAndroidInjector(
            modules = {LoginViewModelsModule.class})
    abstract LoginActivity contributeLoginActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainModule.class,})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract ExerciseDetailsActivity contributeExerciseDetailsActivity();

    @ContributesAndroidInjector
    abstract SplashScreenActivity contributeSplashScreenActivity();

    @ContributesAndroidInjector
    abstract BaseActivity contributeBaseActivity();
}
