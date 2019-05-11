package com.example.watchit.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.watchit.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail);

        TextView textView = findViewById(R.id.tvTitleDetail);
        textView.setText(getIntent().getStringExtra("title"));

        TextView textView1 = findViewById(R.id.tvGenresC);
        textView1.setText(getIntent().getStringExtra("genres"));

        TextView textView2 = findViewById(R.id.tvReleaseDateC);
        textView2.setText(getIntent().getStringExtra("release"));

        TextView textView3 = findViewById(R.id.tvCastC);
        textView3.setText(getIntent().getStringExtra("cast"));

        TextView textView4 = findViewById(R.id.tvSynopsisC);
        textView4.setText(getIntent().getStringExtra("synopsis"));

        ImageView imageView = findViewById(R.id.imageView4);
        imageView.setImageResource(getIntent().getIntExtra("image",0));
    }
}
