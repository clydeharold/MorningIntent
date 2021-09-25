package com.example.morningintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.provider.AlarmClock;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtHour, txtMinutes, txtMessage;
    Button cmdSetAlarm, cmdExplicit;
    //Added comment for git visibility

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refs();

        cmdExplicit.setOnClickListener(startNewActivity);
        cmdSetAlarm.setOnClickListener(setAlarm);
    }

    View.OnClickListener setAlarm = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String msg = txtMessage.getText().toString();
            int hour = Integer.parseInt(txtHour.getText().toString());
            int min = Integer.parseInt(txtMinutes.getText().toString());

            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, msg)
                    .putExtra(AlarmClock.EXTRA_HOUR, hour);

            intent.putExtra(AlarmClock.EXTRA_MINUTES,min);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
    };

    private void refs() {
        txtHour = findViewById(R.id.txtHour);
        txtMinutes = findViewById(R.id.txtMinutes);
        txtMessage = findViewById(R.id.txtMessage);
        cmdSetAlarm = findViewById(R.id.cmdSetAlarm);
        cmdExplicit = findViewById(R.id.cmdExplicit);
        txtMessage = findViewById(R.id.txtMessage);
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