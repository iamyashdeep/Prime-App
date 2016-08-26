package com.example.yashdeepsingh.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
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
    private Button hint;
    public  int temp;
    public  int hidden;
    private Button show;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main_land);
        }
        setContentView(R.layout.activity_main);
        count=0;
        //hidden=2;

        show=(Button)findViewById(R.id.button2);
        hint = (Button) findViewById(R.id.hintbutton);
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
        if(savedInstanceState!=null){
            String randstr = savedInstanceState.getString("randstr");
            TextView textView = (TextView) findViewById(R.id.number);
            textView.setText(randstr);
        }

       else check();
    }



    public void onSaveInstanceState(Bundle savedInstanceState){
        TextView textView = (TextView) findViewById(R.id.number);
        String randstr =  textView.getText().toString();
        savedInstanceState.putString("randstr", randstr);
        super.onSaveInstanceState(savedInstanceState);
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
        temp=-1;
        while (i < (x / 2)) {
            if ((x % i) == 0) {
                temp=i;
                return false;
            }
            i++;
        }
        return true;
    }

    public void check() {
        Random rand = new Random();
        final int num = rand.nextInt(1000) + 1;
        hidden=num;
        String newstring = String.valueOf(num);
        TextView shownumber = (TextView) findViewById(R.id.number);
        shownumber.setText(newstring);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTrueButton.setEnabled(false);
                mFalseButton.setEnabled(false);
                if (calculator(num)) {
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    count++;

                } else {
                    Toast.makeText(MainActivity.this, "InCorrect", Toast.LENGTH_SHORT).show();
                    if(count>0)
                    {count--;}
                }
                TextView string = (TextView) findViewById(R.id.score);
                string.setText("Your Score : "+count);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFalseButton.setEnabled(false);
                mTrueButton.setEnabled(false);
                if (calculator(num)) {
                    Toast.makeText(MainActivity.this, "InCorrect", Toast.LENGTH_SHORT).show();
                    if(count>0)
                    {count--;}
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
                mFalseButton.setEnabled(true);
                mTrueButton.setEnabled(true);
                hint.setEnabled(true);
                show.setEnabled(true);
                check();
            }
        });

    }

    public void hint(View view) {

        hint.setEnabled(false);

        Intent intent = new Intent(this, Main2Activity.class);
        calculator(hidden);
        intent.putExtra("message",temp);
        startActivity(intent);

//        Intent intent1 = new Intent(this, Main2Activity.class);
//         intent1.putExtra("message1",hidden);
//        startActivity(intent1);
//
//        Intent intent2 = new Intent(this, MainActivity.class);
//        intent.putExtra("message",temp);
//        startActivity(intent);
    }

    public void checksol(View view)
    {   show.setEnabled(false);
        Intent intent = new Intent(this, Main3Activity.class);
        calculator(hidden);
        intent.putExtra("message",temp);
        startActivity(intent);}

}



