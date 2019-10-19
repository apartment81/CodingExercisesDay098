package com.example.mirodone.clockwords;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    Runnable mRunnable;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mHandler = new Handler();

        mRunnable = new Runnable() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR);
                int minutes = calendar.get(Calendar.MINUTE);

                if (hours == 0){
                    hours =12;
                }

                mTextView.setText(NumberToWords.convert(hours) + "si \n "
                        + NumberToWords.convert(minutes));

                mHandler.postDelayed(mRunnable, 1000);
            }
        };

        mHandler.postDelayed(mRunnable, 1000);
    }

    @Override
    public void onBackPressed() {
        mHandler.removeCallbacksAndMessages(null);
        finish();
    }
}
