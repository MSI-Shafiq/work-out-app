package com.application.dsvfitness.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.dsvfitness.BaseActivity;
import com.application.dsvfitness.R;
import com.application.dsvfitness.utils.Constants;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

public class ExerciseDetailsActivity extends BaseActivity {

    private ImageView exerciseImageView;

    private TextView titleTextview;
    private TextView descriptionTextview;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        initializeViews();

        Intent intent = getIntent();

        // getting the title, description and imageUrl from the list activity and show
        if (intent.hasExtra(Constants.IMAGE_URL) && intent.hasExtra(Constants.TITLE) && intent.hasExtra(Constants.DESCRIPTION)) {

            String imageUrl = intent.getStringExtra(Constants.IMAGE_URL);
            String title = intent.getStringExtra(Constants.TITLE);
            String description = intent.getStringExtra(Constants.DESCRIPTION);

            // injecting glide and using it
            requestManager
                    .load(imageUrl)
                    .into(exerciseImageView);

            titleTextview.setText(title);
            descriptionTextview.setText(description);
        }


    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.slide_right_out);
    }

    private void initializeViews() {
        exerciseImageView = findViewById(R.id.exercise_image_view);
        titleTextview = findViewById(R.id.title_text_view);
        descriptionTextview = findViewById(R.id.description_text_view);
    }
}