package com.example.servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private  static  final String TAG = "PDMD";

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand (intente, flags, starId): ("+ intent+"-"+flags+"-"+startId+")");
        int i =0;
        while (i==0){
            //bucle infinito, si aplicamos un true, el return se queja y de esta forma lo engañamos
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}