package com.example.watchit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText etUsername, etEmail, etPassword, etConfirmPassword;
    Button Register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        Register = findViewById(R.id.btnRegister);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkDataEntered()){
                    Intent loginActivity = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(loginActivity);
                }
            }
        });
    }

    protected boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    protected boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    protected boolean checkDataEntered(){
        if (isEmpty(etUsername)){
            Toast t = Toast.makeText(this,"Enter a valid username!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        if (isEmail(etEmail) == false){
            etEmail.setError("Enter valid email!");
            return false;
        }
        if (isEmpty(etPassword)){
            Toast t = Toast.makeText(this,"Enter a valid password!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        if (isEmpty(etConfirmPassword)){
            Toast t = Toast.makeText(this,"Enter a valid confirm password!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        if (!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())){
            Toast t = Toast.makeText(this,"Password doesn't match!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        return true;
    }

}
