package com.example.servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    public void onPulsar(View v) {
        Intent i = new Intent(this,MyService.class);
        Button b= (Button) v;
        i.putExtra("etiqueta", b.getText().toString());
        startService(i);
    }
}