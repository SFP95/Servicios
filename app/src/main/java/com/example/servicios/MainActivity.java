package com.example.servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLanzar(View view) {
        Intent i = new Intent(this, MyService.class);
        startService(i);
    }

    public void onDetener(View view) {
        Intent i = new Intent(this, MyService.class);
        stopService(i);
    }
}