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
    Button cmdSetAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refs();

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
    }
}