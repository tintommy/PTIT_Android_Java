package com.example.bt1;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.e("myTag","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("myTag","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("myTag","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("myTag","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("myTag","onDestroy");
    }
}