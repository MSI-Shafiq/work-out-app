package com.application.dsvfitness.di.main;

import com.application.dsvfitness.ui.adapters.ExercisesRecyclerViewAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @MainScope
    @Provides
    static ExercisesRecyclerViewAdapter provideAdapter(){
        return new ExercisesRecyclerViewAdapter();
    }

}
