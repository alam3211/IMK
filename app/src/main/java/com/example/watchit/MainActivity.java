package com.example.watchit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    ImageButton btnTwitter,btnFacebook,btnGoogle;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tvRegister);

        SpannableString ss =  new SpannableString("feel new? go REGISTER");
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD_ITALIC);

        ss.setSpan(boldSpan,13,21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);

        etUsername = (EditText) findViewById(R.id.etUsernameLog);
        etPassword = (EditText) findViewById(R.id.etPasswordLog);

        btnTwitter = (ImageButton) findViewById(R.id.imgbtnTwitter);
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent indexIntent = new Intent(MainActivity.this,IndexActivity.class);
                startActivity(indexIntent);
            }
        });

        btnFacebook= (ImageButton) findViewById(R.id.imgbtnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent indexIntent = new Intent(MainActivity.this,IndexActivity.class);
                startActivity(indexIntent);
            }
        });

        btnGoogle = (ImageButton) findViewById(R.id.imgbtnGoogle);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent indexIntent = new Intent(MainActivity.this,IndexActivity.class);
                startActivity(indexIntent);
            }
        });

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataToast();
                if (!isEmpty(etPassword) && !isEmpty(etUsername)){
                    Intent indexIntent;
                    indexIntent = new Intent(MainActivity.this,IndexActivity.class);
                    startActivity(indexIntent);
                }
            }
        });
    }

    protected void checkDataToast(){
        if (isEmpty(etUsername)){
            Toast t = Toast.makeText(this,"Username is empty",Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(etPassword)){
            Toast t = Toast.makeText(this,"Password is empty",Toast.LENGTH_SHORT);
            t.show();
        }
    }

    protected boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    public void goRegister(View v){
        TextView tvRegister= (TextView) findViewById(R.id.tvRegister);
        Intent regIntent = new Intent(this,RegisterActivity.class);
        startActivity(regIntent);
    }
}
