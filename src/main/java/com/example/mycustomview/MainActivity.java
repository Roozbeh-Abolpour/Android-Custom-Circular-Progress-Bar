package com.example.mycustomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public ProgressBar progressBar1;
    public ProgressBar progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar1=(ProgressBar)findViewById(R.id.pb1);
        progressBar2=(ProgressBar)findViewById(R.id.pb2);
        progressBar1.setValue(80);
        progressBar2.setValue(30);
        progressBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar1.getValue()<100) {
                    progressBar1.setValue(progressBar1.getValue() + 5);
                }else{
                    progressBar1.setValue(0);
                }
            }
        });
        progressBar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar2.getValue()<100) {
                    progressBar2.setValue(progressBar2.getValue() + 5);
                }else{
                    progressBar2.setValue(0);
                }
            }
        });
    }
}
