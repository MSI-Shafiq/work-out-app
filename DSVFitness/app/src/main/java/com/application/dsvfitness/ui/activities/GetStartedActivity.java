package com.application.dsvfitness.ui.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.application.dsvfitness.R;
import com.application.dsvfitness.utils.Constants;
import com.astritveliu.boom.Boom;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;

import es.dmoral.toasty.Toasty;

public class GetStartedActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;

    private CardView doneCardView;
    private CardView signupCardView;

    private TextView bmiResultTextView;
    private TextView bmiStatusTextView;

    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        initializeViews();

        // done button function for calculating the bmi of the user
        doneCardView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(heightEditText.getText().toString())) {
                return;
            }
            if (TextUtils.isEmpty(weightEditText.getText().toString())) {
                return;
            }
            calculateBMI();
        });

        // starting the sign up activity and passing the weight, height and level
        signupCardView.setOnClickListener(view -> {
            if (level == null) {
                Toasty.error(getApplicationContext(), getResources().getString(R.string.please_choose_level)).show();
                return;
            }
            Intent intent = new Intent(this, SignupActivity.class);
            intent.putExtra(Constants.WEIGHT, weightEditText.getText().toString());
            intent.putExtra(Constants.HEIGHT, heightEditText.getText().toString());
            intent.putExtra(Constants.LEVEL, level);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_right, R.anim.nothing);
        });
    }

    private void calculateBMI() {
        int weight = Integer.parseInt(weightEditText.getText().toString());
        float height = Float.parseFloat(heightEditText.getText().toString()) / 100;

        float bmi = weight / (height * height);

        String bmiText = getResources().getString(R.string.your_bmi_result_is) + " " + bmi + " kg/m^2";

        bmiResultTextView.setText(bmiText);
        bmiStatusTextView.setText(bmiState(bmi));

        if (signupCardView.getVisibility() != View.VISIBLE)
            signupCardView.setVisibility(View.VISIBLE);

    }

    // bmi states according to the bmi value
    private String bmiState(float bmi) {
        Resources resources = getResources();
        if (bmi < 16) {
            return resources.getString(R.string.severe_thinness);
        } else if (bmi <= 17 && bmi >= 16) {
            return resources.getString(R.string.moderate_thinness);
        } else if (bmi <= 18.5 && bmi > 17) {
            return resources.getString(R.string.mild_thinness);
        } else if (bmi <= 25.5 && bmi > 18.5) {
            return resources.getString(R.string.normal);
        } else if (bmi <= 30 && bmi > 25.5) {
            return resources.getString(R.string.overweight);
        } else if (bmi <= 35 && bmi > 30) {
            return resources.getString(R.string.obese_class_i);
        } else if (bmi <= 40 && bmi > 35) {
            return resources.getString(R.string.obese_class_ii);
        } else {
            return resources.getString(R.string.obese_class_iii);
        }
    }

    private void initializeViews() {
        weightEditText = findViewById(R.id.weight_edit_text);
        heightEditText = findViewById(R.id.height_edit_text);
        doneCardView = findViewById(R.id.done_button_card_view);
        signupCardView = findViewById(R.id.signup_button_card_view);
        PowerSpinnerView levelDropdownView = findViewById(R.id.level_drop_down);
        bmiResultTextView = findViewById(R.id.bmi_result_text_view);
        bmiStatusTextView = findViewById(R.id.bmi_status_text_view);

        levelDropdownView.setOnSpinnerItemSelectedListener((OnSpinnerItemSelectedListener<String>) (i, string) -> {
            switch (i) {
                case 0:
                    level = Constants.BEGINNER;
                    break;
                case 1:
                    level = Constants.INTERMEDIATE;
                    break;
                default:
                    level = Constants.ADVANCED;
                    break;
            }

        });

        new Boom(doneCardView);
        new Boom(signupCardView);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.slide_right_out);
    }
}