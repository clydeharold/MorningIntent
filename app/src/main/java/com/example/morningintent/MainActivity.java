package com.example.morningintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button cmdExplicit;
    EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmdExplicit = findViewById(R.id.cmdExplicit);
        txtMessage = findViewById(R.id.txtMessage);

        cmdExplicit.setOnClickListener(startNewActivity);
    }

    View.OnClickListener startNewActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String str = txtMessage.getText().toString();

            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("msg", str);
            startActivity(intent);
        }
    };
}