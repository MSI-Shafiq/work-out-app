package com.application.dsvfitness.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.application.dsvfitness.R;
import com.application.dsvfitness.utils.Constants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SplashScreenActivity extends DaggerAppCompatActivity {

    @Inject
    FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuthStateListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            // if user is logged in start the main activity
            Intent intent;
            if (user != null) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                // if user is not logged in start the get started or login activity
            } else {
                intent = new Intent(getApplicationContext(), GetStartedOrLoginActivity.class);
            }
            startActivity(intent);
            overridePendingTransition(R.anim.slide_right, R.anim.nothing);
            finish();
        };

        new Handler().postDelayed(() -> firebaseAuth.addAuthStateListener(firebaseAuthStateListener), Constants.SPLASH_SCREEN_DELAY_TIME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        firebaseAuth.removeAuthStateListener(firebaseAuthStateListener);
    }
}