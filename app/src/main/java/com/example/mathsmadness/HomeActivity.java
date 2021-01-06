package com.example.mathsmadness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button buttonAdd;
    private Button buttonSub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        buttonAdd = (Button) findViewById(R.id.button_addition);
        buttonSub = (Button) findViewById(R.id.button_subtraction);

        buttonAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });

        buttonSub.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySubtraction();
            }
        });
    }

    public void openActivityMain() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void openActivitySubtraction() {

        Intent intent = new Intent(this, MainActivitySubtraction.class);
        startActivity(intent);
    }
}
