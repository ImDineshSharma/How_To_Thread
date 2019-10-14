package com.example.threads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // we need this to handle any Changes in our UI when we this thread runs
    Handler h = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            // reference to the text
            TextView MyText = (TextView)findViewById(R.id.MyText);
            // changes the text
            MyText.setText("Nice Job Hoss");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // this is the code we want to be handeled by new thread
                synchronized (this){
                    try {
                        wait(5000);
                    }catch (Exception e){}
                }
                // remember to add this inside run method
            h.sendEmptyMessage(0);
            }
        };

        // start the thread
        Thread th = new Thread(r);
        th.start();



    }



}
