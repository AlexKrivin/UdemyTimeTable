package com.example.elena.udemytimetable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<String> timesTableContent;
    ListView timeTableListView;

    public void updateList(int timeTable){
       timesTableContent = new ArrayList<String>();
        for(int i = 1; i <=10; i ++){
            timesTableContent.add(Integer.toString(timeTable*i));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);
        timeTableListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTableListView = (ListView)findViewById(R.id.timesTableListView);

        final SeekBar timeTableSeekBar = (SeekBar)findViewById(R.id.timesTableSeekBar);
        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);
        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;
                if(progress<min){
                    timesTable=min;
                    timeTableSeekBar.setProgress(min);
                }else {timesTable=progress;}
                updateList(timesTable);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar){

            }
            @Override public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        updateList(10);
    }




}
