package com.example.servicedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Button buttonStart, buttonStop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.button_play);
        buttonStop = (Button) findViewById(R.id.button_pause);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
    }


    @Override
    public void onClick(View src) {
        switch (src.getId()){
            case R.id.button_play:
                Log.d(TAG, "onCLick: starting service");
                startService(new Intent(this, MyService.class));
                break;
            case R.id.button_pause:
                Log.d(TAG, "OnClick: stopping service");
                stopService(new Intent(this, MyService.class));
                break;
        }

    }
}

