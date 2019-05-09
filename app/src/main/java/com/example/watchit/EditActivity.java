package com.example.watchit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    EditText etEditUsername;
    TextView tvUsername;
    Button btnEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_edit);
        etEditUsername = findViewById(R.id.etEditUsername);
        tvUsername = findViewById(R.id.tvUsername);

        btnEdit = (Button) findViewById(R.id.btnSaveProfile);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = etEditUsername.getText().toString();
                tvUsername.setText(newUsername);

                Fragment selectedFragment = new ProfileFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            }
        });
    }
}
