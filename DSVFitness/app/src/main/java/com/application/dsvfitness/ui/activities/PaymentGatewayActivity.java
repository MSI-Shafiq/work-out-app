package com.application.dsvfitness.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.application.dsvfitness.R;
import com.astritveliu.boom.Boom;

public class PaymentGatewayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_gateway);

        CardView doneCardView = findViewById(R.id.done_card_view);
        doneCardView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(((EditText) findViewById(R.id.credit_card_number_edit_text)).getText().toString())) {
                return;
            }
            if (TextUtils.isEmpty(((EditText) findViewById(R.id.credit_card_date_edit_text)).getText().toString())) {
                return;
            }
            if (TextUtils.isEmpty(((EditText) findViewById(R.id.cvv_edit_text)).getText().toString())) {
                return;
            }

            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            overridePendingTransition(R.anim.slide_right, R.anim.nothing);
        });

        new Boom(doneCardView);
    }

    @Override
    public void onBackPressed() {
        // nothing
    }
}