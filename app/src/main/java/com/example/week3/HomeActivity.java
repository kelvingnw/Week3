package com.example.week3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tvinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvinfo=findViewById(R.id.textView);
        if(getIntent()!=null){
            Intent pemanggil= getIntent();
            tvinfo.setText("Welcome "+pemanggil.getStringExtra("username"));
        }
        else {
            Intent i= new Intent(this,MainActivity.class);
            startActivity(i);
        }

    }


}
