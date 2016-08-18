package com.example.yashdeepsingh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Integer count;
    private Button nextButton;

    private static final String TAG = "QuizActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count=0;

        nextButton = (Button) findViewById(R.id.next);
        mTrueButton = (Button) findViewById(R.id.correct);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Correct");
            }
        });

        mFalseButton = (Button) findViewById(R.id.incorrect);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Incorrect");
            }
        });
        check();




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

    boolean calculator(int x) {
        int i = 2;
        while (i < (x / 2)) {
            if ((x % i) == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public void check() {
        Random rand = new Random();
        final int num = rand.nextInt(1000) + 1;
        String newstring = String.valueOf(num);
        TextView shownumber = (TextView) findViewById(R.id.number);
        shownumber.setText(newstring);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calculator(num)) {
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    count++;

                } else {
                    Toast.makeText(MainActivity.this, "InCorrect", Toast.LENGTH_SHORT).show();
                }
                TextView string = (TextView) findViewById(R.id.score);
                string.setText("Your Score : "+count);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calculator(num)) {
                    Toast.makeText(MainActivity.this, "InCorrect", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    count++;
                }

                TextView string = (TextView) findViewById(R.id.score);
                string.setText("Your Score : "+count);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                check();
            }
        });



    }

}


