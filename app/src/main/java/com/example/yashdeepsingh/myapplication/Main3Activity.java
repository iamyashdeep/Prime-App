package com.example.yashdeepsingh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private static final String TAG = "Main3Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        int temp1 = intent.getIntExtra("message",-1);
        if(temp1==-1)
        {
            TextView shownumber1 = (TextView) findViewById(R.id.cheat);
            shownumber1.setText(" Number is Prime");}
        else {
            String newstring = String.valueOf(temp1);
            TextView shownumber = (TextView) findViewById(R.id.cheat);
            shownumber.setText(" Number is NOT PRIME and divisible by :" + temp1);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnREsume");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

    public void back(View view)
    {finish();}
}
