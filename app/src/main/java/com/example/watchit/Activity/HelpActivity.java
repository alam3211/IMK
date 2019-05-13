package com.example.watchit.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.watchit.R;

public class HelpActivity extends AppCompatActivity {
    Button btnDone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        btnDone = findViewById(R.id.btnUnderstand);
        btnDone.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent newIndex = new Intent(HelpActivity.this,IndexActivity.class);
                        startActivity(newIndex);
                    }
                }
        );
    }
}
