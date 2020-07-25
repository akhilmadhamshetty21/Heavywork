/*
Assignment: In Class Assignment 03
File name: MainActivity.java
Full name:
Akhil Madhamshetty-801165622
Tarun thota-801164383
 */
package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button calButton;
    TextView mintext,maxtext,averagetext,seekbarValue,tvmin,tvmax,tvavg;
    SeekBar seekBar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calButton = findViewById(R.id.button);
        mintext = findViewById(R.id.valueMinimum);
        maxtext = findViewById(R.id.valueMaximum);
        averagetext = findViewById(R.id.valueAverage);
        tvmin=findViewById(R.id.textView3);
        tvmax=findViewById(R.id.textView4);
        tvavg=findViewById(R.id.textView5);
        seekBar= findViewById(R.id.seekBar);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        seekbarValue=findViewById(R.id.seekbarvalue);
        seekBar.setMax(10);
        seekBar.setMin(0);
        seekbarValue.setText(0 + " times");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarValue.setText(progress + " " +   "times");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int times= seekBar.getProgress();
                if(times>0)
                    new CalculateTask().execute(times);
                else
                    Toast.makeText(MainActivity.this,"Enter the value greater than zero",Toast.LENGTH_SHORT).show();

            }
        });
    }
    class CalculateTask extends AsyncTask<Integer,Void, ArrayList<Double>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            mintext.setVisibility(View.INVISIBLE);
            maxtext.setVisibility(View.INVISIBLE);
            averagetext.setVisibility(View.INVISIBLE);
            tvmin.setVisibility(View.INVISIBLE);
            tvmax.setVisibility(View.INVISIBLE);
            tvavg.setVisibility(View.INVISIBLE);

        }

        @Override
        protected void onPostExecute(ArrayList<Double> doubles) {
            super.onPostExecute(doubles);
            double minimum=getMinimum(doubles);
            double maximum=getMaximum(doubles);
            double average=getAverage(doubles);
            mintext.setText(minimum + "");
            maxtext.setText(maximum + "");
            averagetext.setText(average + "");
            progressBar.setVisibility(View.INVISIBLE);
            mintext.setVisibility(View.VISIBLE);
            maxtext.setVisibility(View.VISIBLE);
            averagetext.setVisibility(View.VISIBLE);
            tvmin.setVisibility(View.VISIBLE);
            tvmax.setVisibility(View.VISIBLE);
            tvavg.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<Double> doInBackground(Integer... integers) {
            ArrayList<Double> arrayList = new ArrayList<Double>();
            arrayList=HeavyWork.getArrayNumbers(integers[0]);
            return arrayList;
        }
    }

    private double getAverage(ArrayList<Double> doubles) {
        double sum=0.0;
        for(double value:doubles){
            sum = sum + value;
        }
        return sum/doubles.size();
    }

    private double getMaximum(ArrayList<Double> doubles) {
        double max=Double.MIN_VALUE;
        for(double value:doubles){
            if(max<value)
                max=value;
        }
        return  max;
    }

    private double getMinimum(ArrayList<Double> doubles) {
        double min=Double.MAX_VALUE;
        for(double value:doubles){
            if(min>value)
                min=value;
        }
        return  min;
    }


}
