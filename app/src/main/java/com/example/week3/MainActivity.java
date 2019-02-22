package com.example.week3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtPass;
    Button btnView;
    EditText txtUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPass=findViewById(R.id.txtPass);
        txtUsername=findViewById(R.id.txtUsername);
        btnView=findViewById(R.id.btnView);
        btnView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    txtPass.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    txtPass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

                }
                return true;
            }
        });

    }

    public void btnLogicClick(View v){
        //passing data lewat intent
        Intent intent=new Intent(this,HomeActivity.class);
        intent.putExtra("username", txtUsername.getText().toString());
        startActivity(intent);
    }
    public void btnSmsClick(View v){
        Uri nohp= Uri.parse("smsto:777");
        Intent intentsms=new Intent(Intent.ACTION_SENDTO,nohp);
        intentsms.putExtra("sms_body","Request Login"+txtUsername.getText().toString());
        startActivity(intentsms);
    }
}
