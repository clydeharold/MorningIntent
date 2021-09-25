package com.example.morningintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView lblMessage;
    Button cmdBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lblMessage = findViewById(R.id.lblMessage);
        cmdBack = findViewById(R.id.cmdBack);

        Bundle extra = getIntent().getExtras();
        String str = extra.getString("msg");

        lblMessage.setText(str);

        cmdBack.setOnClickListener(backToPrev);
    }

    View.OnClickListener backToPrev = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };
}